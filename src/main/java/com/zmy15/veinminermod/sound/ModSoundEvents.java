package com.zmy15.veinminermod.sound;

import com.zmy15.veinminermod.Veinminermod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModSoundEvents extends SoundEvents {
    private ModSoundEvents() {
        // Private constructor to prevent instantiation
    }

    public static final SoundEvent ROBIN_PLACE = registerSound("robin_place");
    public static final SoundEvent ROBIN_STEP = registerSound("robin_step");
    public static final SoundEvent ROBIN_HIT = registerSound("robin_hit");
    public static final SoundEvent ROBIN_FALL = registerSound("robin_fall");
    public static final SoundEvent ROBIN_BREAK = registerSound("robin_break");
    public static final SoundEvent ROBIN_SWAY_TO_MY_BEAT_IN_COSMOS = registerSound("robin_sway_to_my_beat_in_cosmos");
    public static final SoundEvent ROBIN_IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING = registerSound("robin_if_i_can_stop_one_heart_from_breaking");
    public static final SoundEvent ROBIN_HOPE_IS_THE_THING_WITH_FEATHERS = registerSound("robin_hope_is_the_thing_with_feathers");
    public static final SoundEvent ROBIN_HAD_I_NOT_SEEN_THE_SUN = registerSound("robin_had_i_not_seen_the_sun");
    public static final RegistryEntry.Reference<SoundEvent> SWAY_TO_MY_BEAT_IN_COSMOS = registerReference("robin.sway_to_my_beat_in_cosmos");
    public static final RegistryEntry.Reference<SoundEvent> IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING = registerReference("robin.if_i_can_stop_one_heart_from_breaking");
    public static final RegistryEntry.Reference<SoundEvent> HOPE_IS_THE_THING_WITH_FEATHERS = registerReference("robin.hope_is_the_thing_with_feathers");
    public static final RegistryEntry.Reference<SoundEvent> HAD_I_NOT_SEEN_THE_SUN = registerReference("robin.had_i_not_seen_the_sun");

    public static final SoundEvent NIANXI_PLACE = registerSound("nianxi_place");
    public static final SoundEvent NIANXI_BREAK = registerSound("nianxi_break");
    public static final SoundEvent WE_ARE_THE_CHAMPIONS = registerSound("we_are_the_champions");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(Veinminermod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void initialize() {
        // Initialization logic for sound events can be added here if needed
        Veinminermod.LOGGER.info("Registering " + Veinminermod.MOD_ID + " Sounds");
    }
    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        return registerReference(Identifier.of(Veinminermod.MOD_ID, id));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id) {
        return registerReference(id, id);
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }
}
