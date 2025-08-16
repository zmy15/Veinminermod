package com.zmy15.veinminermod.registry.tag;

import com.zmy15.veinminermod.Veinminermod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> VEIN_MINABLE = of("vein_minable");
    public static final TagKey<Block> NO_SUITABLE_TOOLS = of("vein_minable/no_suitable_tools");

    private ModBlockTags() {
    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Veinminermod.MOD_ID, id));
    }
}
