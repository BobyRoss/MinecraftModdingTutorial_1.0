package net.machitsu.tutorialmod.datagen;

import com.ibm.icu.impl.StringRange;
import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.blocks.ModBlocks;
import net.machitsu.tutorialmod.item.ModItems;
import net.machitsu.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> aSuper, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, aSuper, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ALEXANDRITE.get())
                .add(ModItems.SUSHI.get())
                .add(Items.COAL);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ATOM_HELMET.get())
                .add(ModItems.ATOM_CHESTPLATE.get())
                .add(ModItems.ATOM_LEGGINGS.get())
                .add(ModItems.ATOM_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ATOM.get());

        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.MACHI_SMITHING_TEMPLATE.get());


        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MADAGASCAR_LOG.get().asItem())
                .add(ModBlocks.MADAGASCAR_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MADAGASCAR_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MADAGASCAR_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.MADAGASCAR_PLANKS.get().asItem());
    }
}
