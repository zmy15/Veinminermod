package com.zmy15.veinminermod;
import com.zmy15.veinminermod.block.ModBlocks;
import com.zmy15.veinminermod.item.ModItemGroups;
import com.zmy15.veinminermod.item.Moditems;
import com.zmy15.veinminermod.sound.ModSoundEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Veinminermod implements ModInitializer {
	public static final String MOD_ID = "veinminer";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// 注册方块破坏事件
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
			if (VeinMiner.shouldTrigger(world, player, pos, state)) {
				Veinminermod.LOGGER.info("触发挖掘");
				VeinMiner.mineVein(world, player, pos, state.getBlock());
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

		KeyBindings.register();
		Moditems.initialize();
		ModBlocks.initialize();
		ModSoundEvents.initialize();
		ModItemGroups.initialize();
	}
}