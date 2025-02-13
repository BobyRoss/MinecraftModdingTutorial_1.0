package net.machitsu.tutorialmod.datagen;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.blocks.ModBlocks;
import net.machitsu.tutorialmod.blocks.custon.AtomLampBlock;
import net.machitsu.tutorialmod.blocks.custon.BushCampBush;
import net.machitsu.tutorialmod.blocks.custon.SushiCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static net.machitsu.tutorialmod.blocks.ModBlocks.ATOM_LAMP_BLOCK;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_ORE);

        blockWithItem(ModBlocks.MIGI_BLOCK);
        blockWithItem(ModBlocks.EDAMAME_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.MIGI_STAIR.get(), blockTexture(ModBlocks.MIGI_BLOCK.get()));
        slabBlock(ModBlocks.MIGI_SLAB.get(), blockTexture(ModBlocks.MIGI_BLOCK.get()), blockTexture(ModBlocks.MIGI_BLOCK.get()));

        buttonBlock(ModBlocks.MIGI_BUTTON.get(), blockTexture(ModBlocks.MIGI_BLOCK.get()));
        pressurePlateBlock(ModBlocks.MIGI_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MIGI_BLOCK.get()));
        fenceBlock(ModBlocks.MIGI_FENCE.get(), blockTexture(ModBlocks.MIGI_BLOCK.get()));
        fenceGateBlock(ModBlocks.MIGI_FENCE_GATE.get(), blockTexture(ModBlocks.MIGI_BLOCK.get()));
        wallBlock(ModBlocks.MIGI_WALL.get(), blockTexture(ModBlocks.MIGI_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.MIGI_DOOR.get(), modLoc("block/migi_door_bottom"), modLoc("block/migi_door_top"), "solid");
        trapdoorBlockWithRenderType(ModBlocks.MIGI_TRAP_DOOR.get(), modLoc("block/migi_trap_door"), true, "solid");

        blockItem(ModBlocks.MIGI_STAIR);
        blockItem(ModBlocks.MIGI_SLAB);
        blockItem(ModBlocks.MIGI_PRESSURE_PLATE);
        blockItem(ModBlocks.MIGI_FENCE_GATE);
        blockItem(ModBlocks.MIGI_TRAP_DOOR, "_bottom");

        blockWithItem(ModBlocks.ALEXANDRITE_END_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_NETHER_ORE);

        customLamp();

    makeCrop(((CropBlock) ModBlocks.SUSHI_CROP.get()), "sushi_crop_stage", "sushi_crop_stage");
    makeBush(((SweetBerryBushBlock) ModBlocks.BUSH_CAMP_BUSH.get()), "bush_camp_bush_stage", "bush_camp_bush_stage");

    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SushiCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(((SushiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }



    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(BushCampBush.AGE),
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + textureName + state.getValue(BushCampBush.AGE))).renderType("cutout"));

        return models;
    }




    private void customLamp() {
        getVariantBuilder(ATOM_LAMP_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(AtomLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("atom_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "atom_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("atom_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "atom_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.ATOM_LAMP_BLOCK.get(), models().cubeAll("atom_lamp_off",
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "atom_lamp_off")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
