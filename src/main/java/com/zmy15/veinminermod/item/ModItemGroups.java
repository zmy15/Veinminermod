package com.zmy15.veinminermod.item;

import com.zmy15.veinminermod.Veinminermod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> VEINMINER_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Veinminermod.MOD_ID, "item_group"));
    public static final ItemGroup VEINMINER_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Moditems.PRIMOGEMS))
            .displayName(Text.translatable("itemGroup.veinminer.item_group"))
            .build();

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, VEINMINER_ITEM_GROUP_KEY, VEINMINER_ITEM_GROUP);
    }
}
