package net.machitsu.tutorialmod.datagen;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.enchantment.ModEnchantments;
import net.machitsu.tutorialmod.trim.ModTrimMaterials;
import net.machitsu.tutorialmod.trim.ModTrimPatterns;
import net.machitsu.tutorialmod.worldgen.ModBiomeModifiers;
import net.machitsu.tutorialmod.worldgen.ModConfiguredFeatures;
import net.machitsu.tutorialmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackEntries  extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::bootStrap)
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);


    public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TutorialMod.MOD_ID));
    }
}
