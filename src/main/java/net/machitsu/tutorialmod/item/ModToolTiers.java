package net.machitsu.tutorialmod.item;

import net.machitsu.tutorialmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier ATOM = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_ATOM_TOOL, () -> Ingredient.of(ModItems.ATOM.get()),
            ModTags.Blocks.INCORRECT_FOR_ATOM_TOOL);

}
