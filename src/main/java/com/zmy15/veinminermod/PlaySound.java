package com.zmy15.veinminermod;

import com.zmy15.veinminermod.block.ModBlocks;
import com.zmy15.veinminermod.item.Moditems;
import com.zmy15.veinminermod.sound.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class PlaySound {
    public static boolean PlayNianxiSound(PlayerEntity player, World world, BlockHitResult hitResult, Hand hand) {
        if (player.getStackInHand(hand).getItem() == Moditems.Rubert_Empire_Difference_Machine) {
            // 判断被右键的方块是否为指定方块
            if (world.getBlockState(hitResult.getBlockPos()).getBlock() == ModBlocks.NIANXI_BLOCK) {
                // 播放指定声音
                world.playSound(
                        player,
                        hitResult.getBlockPos(),
                        ModSoundEvents.WE_ARE_THE_CHAMPIONS,
                        SoundCategory.PLAYERS,
                        1.0F, // 音量
                        1.0F  // 音调
                );
                return true;
            }
        }
        return false;
    }

    public static boolean PlayRobinSound(PlayerEntity player, World world, BlockHitResult hitResult, Hand hand) {
        // 判断被右键的方块是否为指定方块
        if (world.getBlockState(hitResult.getBlockPos()).getBlock() == ModBlocks.ROBIN_BLOCK) {
            // 播放指定声音
            Direction side = hitResult.getSide();
            BlockPos pos = hitResult.getBlockPos();
            if (side == Direction.NORTH) {
                world.playSound(player, pos, ModSoundEvents.ROBIN_HAD_I_NOT_SEEN_THE_SUN, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return true;
            } else if (side == Direction.SOUTH) {
                world.playSound(player, pos, ModSoundEvents.ROBIN_HOPE_IS_THE_THING_WITH_FEATHERS, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return true;
            } else if (side == Direction.EAST) {
                world.playSound(player, pos, ModSoundEvents.ROBIN_IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return true;
            } else if (side == Direction.WEST) {
                world.playSound(player, pos, ModSoundEvents.ROBIN_SWAY_TO_MY_BEAT_IN_COSMOS, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
