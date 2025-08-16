package com.zmy15.veinminermod.item;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class Intertwined_FateItem extends Item {
    private final String tooltipKey;

    public Intertwined_FateItem(Settings settings, String tooltipKey) {
        super(settings);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable(tooltipKey + ".line1").formatted(Formatting.GOLD));
        textConsumer.accept(Text.translatable(tooltipKey + ".line2").formatted(Formatting.GOLD));
        textConsumer.accept(Text.translatable(tooltipKey + ".line3").formatted(Formatting.GOLD));
        textConsumer.accept(Text.translatable(tooltipKey + ".line4").formatted(Formatting.GOLD));
    }
}

