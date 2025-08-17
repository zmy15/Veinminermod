package com.zmy15.veinminermod;

import com.zmy15.veinminermod.registry.tag.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import java.util.*;

public class VeinMiner {
    // 存储玩家最后使用时间，用于冷却
    private static final Map<UUID, Long> lastUseTime = new HashMap<>();

    public static boolean isAllowedBlock(BlockState state) {
        return state.isIn(ModBlockTags.VEIN_MINABLE);
    }
    public static boolean isSuitableTools(BlockState state) {
        return !state.isIn(ModBlockTags.NO_SUITABLE_TOOLS);
    }

    public static boolean collect_SWEET_BERRY_BUSH(PlayerEntity player, World world, BlockHitResult hitResult, Hand hand)
    {
        BlockPos pos = hitResult.getBlockPos();
        BlockState state = world.getBlockState(pos);

        // 检查是否为甜浆果丛且满足连锁采集条件
        if (state.getBlock() == Blocks.SWEET_BERRY_BUSH) {
            int age = state.get(SweetBerryBushBlock.AGE);
            if (age >= 2) { // 只有成熟的浆果才能触发
                Veinminermod.LOGGER.info("触发甜浆果连锁采集");
                VeinMiner.mineVein(world, player, pos, state.getBlock(), false, false);
                return true;
            }
        }
        return false;
    }

    public static boolean shouldTrigger(World world, PlayerEntity player, BlockPos pos, BlockState state) {

        // 检查冷却时间
        long now = System.currentTimeMillis();
        if (now - lastUseTime.getOrDefault(player.getUuid(), 0L) < 1) {
            return false;
        }

        // 检查按键是否按下
        if (!KeyBindings.VEIN_MINER_KEY.isPressed()) {
            Veinminermod.LOGGER.info("没按下");
            return false;
        }

        // 检查工具是否有效
        ItemStack tool = player.getMainHandStack();
        if (isSuitableTools(state) && !tool.isSuitableFor(state)) {
            Veinminermod.LOGGER.info("无效");
            return false;
        }

        // 检查方块是否在允许列表中
        return isAllowedBlock(state);
    }

    public static void mineVein(World world, PlayerEntity player, BlockPos startPos, Block targetBlock, boolean damage, boolean isBreak) {
        Veinminermod.LOGGER.info(String.format("开始连锁:%s",targetBlock.getName().getString()));
        Veinminermod.LOGGER.info(String.format("方块位置:%s",startPos.toShortString()));
        // 记录使用时间
        lastUseTime.put(player.getUuid(), System.currentTimeMillis());

        // 使用队列实现BFS算法
        Queue<BlockPos> queue = new LinkedList<>();
        Set<BlockPos> mined = new HashSet<>();
        queue.add(startPos);
        mined.add(startPos);

        int count = 0;
        int maxBlocks = 99; // 最大连锁方块数量
        ItemStack tool = player.getMainHandStack();

        while (!queue.isEmpty() && count < maxBlocks) {
            BlockPos pos = queue.poll();
            BlockState state = world.getBlockState(pos);
            Veinminermod.LOGGER.info(String.format("出队方块:%s", state.getBlock().getName().getString()));
            // 处理甜浆果丛
            if (!isBreak)
            {
                int age = state.get(SweetBerryBushBlock.AGE);
                if (age >= 2) {
                    // 掉落浆果
                    Block.dropStack(world, pos, new ItemStack(Items.SWEET_BERRIES, age == 3 ? 3 : 1));
                    // 重置为成长阶段1
                    world.setBlockState(pos, state.with(SweetBerryBushBlock.AGE, 1), Block.NOTIFY_ALL);
                    count++;
                }
            }
            else{
                // 破坏方块
                if (player.isCreative() || player.canHarvest(state)) {

                    // 获取工具的掉落物
                    List<ItemStack> drops = Block.getDroppedStacks(state, (ServerWorld)world, pos,
                            world.getBlockEntity(pos), player, tool);

                    // 触发方块破坏事件
                    state.onStacksDropped((ServerWorld)world, pos, tool, true);

                    // 移除方块
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);

                    // 掉落物品
                    for (ItemStack drop : drops) {
                        Block.dropStack(world, pos, drop);
                    }

                    if (damage) {
                        tool.damage(1, player);
                    }
                    count++;
                }
            }
            // 检查相邻方块
            for (Direction direction : Direction.values()) {
                BlockPos nextPos = pos.offset(direction);

                // 跳过已处理的方块
                if (mined.contains(nextPos)) continue;

                // 检查方块是否相同
                BlockState nextState = world.getBlockState(nextPos);
                if (nextState.getBlock().equals(targetBlock)) {
                    queue.add(nextPos);
                    mined.add(nextPos);
                }
            }
        }
    }
}