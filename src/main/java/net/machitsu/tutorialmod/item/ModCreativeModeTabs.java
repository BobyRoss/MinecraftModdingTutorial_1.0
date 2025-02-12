package net.machitsu.tutorialmod.item;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> MYMOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("mymod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BOKUKUN.get()))
                    .title(Component.translatable("creativetab.tutorialmod.mymod_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE.get());
                        output.accept(ModItems.BOKUKUN.get());

                        output.accept(ModItems.CHISEL.get());

                        output.accept(ModItems.SUSHI.get());

                        output.accept(ModItems.KARUSHIFAH.get());

                        output.accept(ModItems.ATOM.get());

                        output.accept(ModItems.ATOM_SWORD.get());
                        output.accept(ModItems.ATOM_PICKAXE.get());
                        output.accept(ModItems.ATOM_SHOVEL.get());
                        output.accept(ModItems.ATOM_HOE.get());
                        output.accept(ModItems.ATOM_AXE.get());

                        output.accept(ModItems.ATOM_HAMMER.get());

                        output.accept(ModItems.ATOM_HELMET.get());
                        output.accept(ModItems.ATOM_LEGGINGS.get());
                        output.accept(ModItems.ATOM_CHESTPLATE.get());
                        output.accept(ModItems.ATOM_BOOTS.get());

                        output.accept(ModItems.ATOM_HORSE_ARMOR.get());

                        output.accept(ModItems.MACHI_SMITHING_TEMPLATE.get());

                        output.accept(ModItems.SAIKYOU_BOW.get());
                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());

                        output.accept(ModItems.CHARLES_MUSIC_DISC.get());

                        output.accept(ModItems.SUSHI_SEEDS.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> MYMOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("mymod_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MIGI_BLOCK.get()))
                    .withTabsBefore(MYMOD_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.mymod_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.MIGI_BLOCK.get());

                        output.accept(ModBlocks.EDAMAME_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());

                        output.accept(ModBlocks.MIGI_TRAP_DOOR.get());
                        output.accept(ModBlocks.MIGI_BUTTON.get());
                        output.accept(ModBlocks.MIGI_DOOR.get());
                        output.accept(ModBlocks.MIGI_FENCE.get());
                        output.accept(ModBlocks.MIGI_STAIR.get());
                        output.accept(ModBlocks.MIGI_SLAB.get());
                        output.accept(ModBlocks.MIGI_WALL.get());
                        output.accept(ModBlocks.MIGI_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MIGI_BUTTON.get());

                        output.accept(ModBlocks.ATOM_LAMP_BLOCK.get());




                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
