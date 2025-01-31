package net.machitsu.tutorialmod.datagen;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.blocks.ModBlocks;
import net.machitsu.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.MIGI_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.EDAMAME_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MIGI_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.MIGI_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.MIGI_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.MIGI_WALL.get());


        tag(ModTags.Blocks.NEEDS_ATOM_TOOL)
                .add(ModBlocks.EDAMAME_ORE.get())
                .add(ModBlocks.MIGI_BLOCK.get())
                .add(Blocks.BEDROCK)
                .addTags(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_ATOM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_ATOM_TOOL);

    }
}
