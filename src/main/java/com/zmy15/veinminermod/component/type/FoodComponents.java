package com.zmy15.veinminermod.component.type;

import net.minecraft.component.type.FoodComponent;


public class FoodComponents{
    public static final FoodComponent PRIMOGEMS = (new FoodComponent.Builder()).nutrition(6).saturationModifier(0.4F).build();
    public static final FoodComponent STELLAR_JADE = (new FoodComponent.Builder()).nutrition(10).saturationModifier(0.6F).build();
    public static final FoodComponent INTERTWINED_FATE = (new FoodComponent.Builder()).nutrition(14).saturationModifier(1.0F).alwaysEdible().build();
    public static final FoodComponent RUBERT_EMPIRE_DIFFERENCE_MACHINE = (new FoodComponent.Builder()).nutrition(12).saturationModifier(0.9F).alwaysEdible().build();

    public FoodComponents() {
    }

    private static FoodComponent.Builder createStew(int nutrition) {
        return (new FoodComponent.Builder()).nutrition(nutrition).saturationModifier(0.6F);
    }
}
