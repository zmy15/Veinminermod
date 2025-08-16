package com.zmy15.veinminermod.component.type;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

import java.util.List;

public class ConsumableComponents {

    public static final ConsumableComponent INTERTWINED_FATE = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 1),
                                    new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0),
                                    new StatusEffectInstance(StatusEffects.SATURATION, 5 * 20, 0),
                                    new StatusEffectInstance(StatusEffects.LUCK, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0)
                                    )
                    )
            )
            .build();
    public static final ConsumableComponent RUBERT_EMPIRE_DIFFERENCE_MACHINE = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.SPEED, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.HASTE, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.STRENGTH, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.REGENERATION, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.WATER_BREATHING, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.INVISIBILITY, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.SATURATION, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.LUCK, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.SLOW_FALLING, 6000, 1),
                                    new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 6000, 0),
                                    new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 6000, 0)
                                    )
                    )
            )
            .build();

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }
}
