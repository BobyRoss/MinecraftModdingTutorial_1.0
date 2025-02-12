package net.machitsu.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SUSHI = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 400), 0.2f).build();

    public static final FoodProperties BUSH_CAMP = new FoodProperties.Builder().nutrition(2).saturationModifier(0.15f).fast().build();
}
