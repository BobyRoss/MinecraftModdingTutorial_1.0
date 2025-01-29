package net.machitsu.tutorialmod.item;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.item.custom.ChiselItem;
import net.machitsu.tutorialmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    //deferred register is a list given by minecraft of all the things in <> at this time


    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOKUKUN = ITEMS.register("bokukun", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel", () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> SUSHI = ITEMS.register("sushi", ()-> new Item(new Item.Properties().food(ModFoodProperties.SUSHI)){
        @Override
        public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
            pTooltipComponents.add(Component.translatable( "tooltips.tutorialmod.sushi"));
            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
    });

    public static final RegistryObject<Item> KARUSHIFAH = ITEMS.register("karushifah", () -> new FuelItem(new Item.Properties(), 1200));


    public static final RegistryObject<Item> ATOM = ITEMS.register("atom", ()-> new Item(new Item.Properties()));

    //eventbus is an object holding event listeners and parameters for them
    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);
    }


}
