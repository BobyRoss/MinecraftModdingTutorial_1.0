package net.machitsu.tutorialmod.datagen;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.blocks.ModBlocks;
import net.machitsu.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipieProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipieProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.CHISEL.get(), ModItems.BOKUKUN.get());


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has (ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        //build sword
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATOM_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.ATOM.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.ATOM.get()), has (ModItems.ATOM.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get())).save(pRecipeOutput);

        //added id to the save method below to differentiate the file names that would be created. default file
        // names are the result items (alexandrite, in this case)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 32)
                .requires(ModBlocks.MIGI_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID+"alexandrite_from_magic_block");


        oreSmelting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
        oreBlasting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

        stairBuilder(ModBlocks.MIGI_STAIR.get(), Ingredient.of(ModItems.ATOM.get())).group("migi")
                .unlockedBy(getHasName(ModItems.ATOM.get()), has(ModItems.ATOM.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIGI_SLAB.get(), ModItems.ATOM.get());

        buttonBuilder(ModBlocks.MIGI_BUTTON.get(), Ingredient.of(ModItems.ATOM.get())).group("migi")
                .unlockedBy(getHasName(ModItems.ATOM.get()), has(ModItems.ATOM.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.MIGI_PRESSURE_PLATE.get(), ModItems.ATOM.get());

        fenceBuilder(ModBlocks.MIGI_FENCE.get(), Ingredient.of(ModItems.ATOM.get())).group("migi")
                .unlockedBy(getHasName(ModItems.ATOM.get()), has(ModItems.ATOM.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.MIGI_FENCE_GATE.get(), Ingredient.of(ModItems.ATOM.get())).group("migi")
                .unlockedBy(getHasName(ModItems.ATOM.get()), has(ModItems.ATOM.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIGI_WALL.get(), ModItems.ATOM.get());

        doorBuilder(ModBlocks.MIGI_DOOR.get(), Ingredient.of(ModItems.ATOM.get())).group("migi")
                .unlockedBy(getHasName(ModItems.ATOM.get()), has(ModItems.ATOM.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.MIGI_TRAP_DOOR.get(), Ingredient.of(ModItems.ATOM.get())).group("migi")
                .unlockedBy(getHasName(ModItems.ATOM.get()), has(ModItems.ATOM.get())).save(pRecipeOutput);

    }
}
