package com.zmy15.veinminermod;
import com.zmy15.veinminermod.block.ModBlocks;
import com.zmy15.veinminermod.item.ModItemGroups;
import com.zmy15.veinminermod.item.Moditems;
import com.zmy15.veinminermod.sound.ModSoundEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Veinminermod implements ModInitializer {
	public static final String MOD_ID = "veinminer";
	private static final Item[] ROBIN_MUSIC_DISCS = new Item[] {
			Moditems.SWAY_TO_MY_BEAT_IN_COSMOS,
			Moditems.IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING,
			Moditems.HOPE_IS_THE_THING_WITH_FEATHERS,
			Moditems.HAD_I_NOT_SEEN_THE_SUN
	};

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// 注册方块破坏事件
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
			if (VeinMiner.shouldTrigger(world, player, pos, state)) {
				LOGGER.info("触发挖掘");
				boolean damage = VeinMiner.isSuitableTools(state);
				VeinMiner.mineVein(world, player, pos, state.getBlock(), damage ,true);
			}
		});

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			if(VeinMiner.collect_SWEET_BERRY_BUSH(player, world, hitResult, hand))
			{
				return ActionResult.SUCCESS; // 返回成功，表示事件已处理
			}
			if(PlaySound.PlayNianxiSound(player, world, hitResult, hand))
			{
				return ActionResult.SUCCESS; // 返回成功，表示事件已处理
			}
			if(PlaySound.PlayRobinSound(player, world, hitResult, hand))
			{
				return ActionResult.SUCCESS; // 返回成功，表示事件已处理
			}
			return ActionResult.PASS;
		});

		ServerLivingEntityEvents.AFTER_DEATH.register((LivingEntity entity, DamageSource source) -> {
			if (entity instanceof ParrotEntity && entity.getWorld() instanceof World world) {
				if (source.getName().equals("explosion.player") && source.getAttacker() instanceof CreeperEntity creeper) {
					Random random = world.getRandom();

					// 检查是否为闪电苦力怕
					boolean isCharged = creeper.isCharged();

					// 设置掉落概率：闪电苦力怕100%，普通苦力怕10%
					float dropChance = isCharged ? 1.0f : 0.1f;

					if (random.nextFloat() < dropChance) {
						Item randomDisc = ROBIN_MUSIC_DISCS[random.nextInt(ROBIN_MUSIC_DISCS.length)];
						entity.dropItem((ServerWorld)world, randomDisc);
					}
				}
			}
		});

		KeyBindings.register();
		Moditems.initialize();
		ModBlocks.initialize();
		ModSoundEvents.initialize();
		ModItemGroups.initialize();
	}
}