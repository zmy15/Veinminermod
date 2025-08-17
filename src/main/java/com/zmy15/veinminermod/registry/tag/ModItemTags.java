package com.zmy15.veinminermod.registry.tag;

import com.zmy15.veinminermod.Veinminermod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> ROBIN_MUSIC_DISC = of("robin_music_disc");

    private ModItemTags() {
    }

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Veinminermod.MOD_ID, id));
    }
}
