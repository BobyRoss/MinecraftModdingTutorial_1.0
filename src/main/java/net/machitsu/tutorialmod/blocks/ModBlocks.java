package net.machitsu.tutorialmod.blocks;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.blocks.custon.AtomLampBlock;
import net.machitsu.tutorialmod.blocks.custon.MagicBlock;
import net.machitsu.tutorialmod.item.ModItems;
import net.machitsu.tutorialmod.sound.ModSounds;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);


    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MIGI_BLOCK = registerBlock("migi_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .destroyTime(5f)));

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            ()-> new DropExperienceBlock(UniformInt.of(2, 4),BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EDAMAME_ORE = registerBlock("edamame_ore",
            ()-> new DropExperienceBlock(UniformInt.of(3, 6),BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            ()-> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final RegistryObject<StairBlock> MIGI_STAIR  = registerBlock("migi_stairs",
            ()-> new StairBlock(ModBlocks.MIGI_BLOCK.get().defaultBlockState().getBlock().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> MIGI_SLAB  = registerBlock("migi_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> MIGI_PRESSURE_PLATE  = registerBlock("migi_pressure_plate",
            ()-> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> MIGI_BUTTON  = registerBlock("migi_button",
            ()-> new ButtonBlock(BlockSetType.IRON, 1, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> MIGI_FENCE  = registerBlock("migi_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> MIGI_FENCE_GATE  = registerBlock("migi_fence_gate",
            ()-> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> MIGI_WALL  = registerBlock("migi_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> MIGI_DOOR  = registerBlock("migi_door",
            ()-> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> MIGI_TRAP_DOOR  = registerBlock("migi_trapdoor",
            ()-> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));


    public static final RegistryObject<Block> ATOM_LAMP_BLOCK = registerBlock("atom_lamp_block",
    () -> new AtomLampBlock(BlockBehaviour.Properties.of().strength(3f).lightLevel(state->state.getValue(AtomLampBlock.CLICKED)?15:0 )));


    private static<T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
