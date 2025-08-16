package com.zmy15.veinminermod.block.jukebox;

import com.zmy15.veinminermod.Veinminermod;
import com.zmy15.veinminermod.sound.ModSoundEvents;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public interface ModJukeboxSongs {
    RegistryKey<JukeboxSong> SWAY_TO_MY_BEAT_IN_COSMOS = of("sway_to_my_beat_in_cosmos");
    RegistryKey<JukeboxSong> IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING = of("if_i_can_stop_one_heart_from_breaking");
    RegistryKey<JukeboxSong> HOPE_IS_THE_THING_WITH_FEATHERS = of("hope_is_the_thing_with_feathers");
    RegistryKey<JukeboxSong> HAD_I_NOT_SEEN_THE_SUN = of("had_i_not_seen_the_sun");

    private static RegistryKey<JukeboxSong> of(String id) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Veinminermod.MOD_ID,id));
    }

    private static void register(
            Registerable<JukeboxSong> registry, RegistryKey<JukeboxSong> key, RegistryEntry.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput
    ) {
        registry.register(
                key, new JukeboxSong(soundEvent, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), lengthInSeconds, comparatorOutput)
        );
    }
    static void bootstrap(Registerable<JukeboxSong> registry) {
        register(registry, SWAY_TO_MY_BEAT_IN_COSMOS, ModSoundEvents.SWAY_TO_MY_BEAT_IN_COSMOS, 165, 15);
        register(registry, IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING, ModSoundEvents.IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING, 202, 15);
        register(registry, HOPE_IS_THE_THING_WITH_FEATHERS, ModSoundEvents.HOPE_IS_THE_THING_WITH_FEATHERS, 230, 15);
        register(registry, HAD_I_NOT_SEEN_THE_SUN, ModSoundEvents.HAD_I_NOT_SEEN_THE_SUN, 145, 15);
    }
}

