package com.zmy15.veinminermod;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static KeyBinding VEIN_MINER_KEY;

    public static void register() {
        VEIN_MINER_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.veinminer.activate",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_GRAVE_ACCENT, // ~键
                "连锁采集"
            ));
        }
}
