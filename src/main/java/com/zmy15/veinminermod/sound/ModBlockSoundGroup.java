package com.zmy15.veinminermod.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

public class ModBlockSoundGroup extends BlockSoundGroup {
    public ModBlockSoundGroup(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        super(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }

    public static final BlockSoundGroup ROBIN = new BlockSoundGroup(
            1.0F,
            1.0F,
            ModSoundEvents.ROBIN_BREAK,
            ModSoundEvents.ROBIN_STEP,
            ModSoundEvents.ROBIN_PLACE,
            ModSoundEvents.ROBIN_HIT,
            ModSoundEvents.ROBIN_FALL
    );
    public static final BlockSoundGroup NIANXI = new BlockSoundGroup(
            1.0F,
            1.0F,
            ModSoundEvents.NIANXI_BREAK,
            ModSoundEvents.INTENTIONALLY_EMPTY,
            ModSoundEvents.NIANXI_PLACE,
            ModSoundEvents.INTENTIONALLY_EMPTY,
            ModSoundEvents.INTENTIONALLY_EMPTY
    );
}
