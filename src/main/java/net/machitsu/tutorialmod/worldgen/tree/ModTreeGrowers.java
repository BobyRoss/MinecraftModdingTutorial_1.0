package net.machitsu.tutorialmod.worldgen.tree;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower MADAGASCAR = new TreeGrower(TutorialMod.MOD_ID + ":madagascar",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MADAGASCAR_KEY), Optional.empty());
}
