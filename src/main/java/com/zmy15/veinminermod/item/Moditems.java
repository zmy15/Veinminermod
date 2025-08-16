package com.zmy15.veinminermod.item;

import com.zmy15.veinminermod.block.jukebox.ModJukeboxSongs;
import com.zmy15.veinminermod.component.type.FoodComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import com.zmy15.veinminermod.component.type.ConsumableComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import java.util.function.Function;


public class Moditems {
    private Moditems() {
        // Private constructor to prevent instantiation
    }
    public static final Item PRIMOGEMS = registerModItems("primogems",Item::new, new Item.Settings().food(FoodComponents.PRIMOGEMS));
    public static final Item STELLAR_JADE = registerModItems("stellar_jade", Item::new, new Item.Settings().food(FoodComponents.STELLAR_JADE));
    public static final Item INTERTWINED_FATE = registerModItems("intertwined_fate",
            settings -> new Intertwined_FateItem(settings, "itemTooltip.veinminer.intertwined_fate"),
            new Item.Settings()
                    .food(FoodComponents.INTERTWINED_FATE, ConsumableComponents.INTERTWINED_FATE)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item SWAY_TO_MY_BEAT_IN_COSMOS = registerModItems(
            "sway_to_my_beat_in_cosmos", Item::new, new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.SWAY_TO_MY_BEAT_IN_COSMOS)
    );
    public static final Item IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING = registerModItems(
            "if_i_can_stop_one_heart_from_breaking", Item::new, new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING)
    );
    public static final Item HOPE_IS_THE_THING_WITH_FEATHERS = registerModItems(
            "hope_is_the_thing_with_feathers", Item::new, new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.HOPE_IS_THE_THING_WITH_FEATHERS)
    );
    public static final Item HAD_I_NOT_SEEN_THE_SUN = registerModItems(
            "had_i_not_seen_the_sun", Item::new, new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.HAD_I_NOT_SEEN_THE_SUN)
    );
    public static final Item Rubert_Empire_Mechanical_Piston = registerModItems("rubert_empire_mechanical_piston", Item::new, new Item.Settings());
    public static final Item Rubert_Empire_Mechanical_Lever = registerModItems("rubert_empire_mechanical_lever", Item::new, new Item.Settings());
    public static final Item Rubert_Empire_Mechanical_Cogwheel = registerModItems("rubert_empire_mechanical_cogwheel", Item::new, new Item.Settings());
    public static final Item Rubert_Empire_Difference_Machine = registerModItems(
            "rubert_empire_difference_machine", Item::new, new Item.Settings().rarity(Rarity.RARE).maxCount(1)
                    .food(FoodComponents.RUBERT_EMPIRE_DIFFERENCE_MACHINE, ConsumableComponents.RUBERT_EMPIRE_DIFFERENCE_MACHINE));

    public static Item registerModItems(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("veinminer", path));
        return Items.register(registryKey, factory, settings);
    }
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.VEINMINER_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(PRIMOGEMS);
            itemGroup.add(STELLAR_JADE);
            itemGroup.add(INTERTWINED_FATE);
            itemGroup.add(SWAY_TO_MY_BEAT_IN_COSMOS);
            itemGroup.add(IF_I_CAN_STOP_ONE_HEART_FROM_BREAKING);
            itemGroup.add(HOPE_IS_THE_THING_WITH_FEATHERS);
            itemGroup.add(HAD_I_NOT_SEEN_THE_SUN);
            itemGroup.add(Rubert_Empire_Mechanical_Piston);
            itemGroup.add(Rubert_Empire_Mechanical_Lever);
            itemGroup.add(Rubert_Empire_Mechanical_Cogwheel);
            itemGroup.add(Rubert_Empire_Difference_Machine);
        });
    }
}
