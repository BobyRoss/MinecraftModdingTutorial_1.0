package net.machitsu.tutorialmod.item;

import net.machitsu.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    //deferred register is a list given by minecraft of all the things in <> at this time


    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOKUKUN = ITEMS.register("bokukun", () -> new Item(new Item.Properties()));


    //eventbus is a object holding event listeners and parameters for them
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
