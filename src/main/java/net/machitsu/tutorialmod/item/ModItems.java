package net.machitsu.tutorialmod.item;

import net.machitsu.tutorialmod.TutorialMod;
import net.machitsu.tutorialmod.blocks.ModBlocks;
import net.machitsu.tutorialmod.item.custom.ChiselItem;
import net.machitsu.tutorialmod.item.custom.FuelItem;
import net.machitsu.tutorialmod.item.custom.HammerItem;
import net.machitsu.tutorialmod.item.custom.ModArmorItem;
import net.machitsu.tutorialmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraft.core.registries.BuiltInRegistries.ITEM;

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


    public static final RegistryObject<Item> ATOM_SWORD = ITEMS.register("atom_sword",
            () -> new SwordItem(ModToolTiers.ATOM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ATOM, 3, -2.4f))));
    public static final RegistryObject<Item> ATOM_PICKAXE = ITEMS.register("atom_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ATOM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ATOM, 1, -2.8f))));
    public static final RegistryObject<Item> ATOM_SHOVEL = ITEMS.register("atom_shovel",
            () -> new ShovelItem(ModToolTiers.ATOM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ATOM, 1.5f, -3.0f))));
    public static final RegistryObject<Item> ATOM_AXE = ITEMS.register("atom_axe",
            () -> new AxeItem(ModToolTiers.ATOM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ATOM, 6, -3.2f))));
    public static final RegistryObject<Item> ATOM_HOE = ITEMS.register("atom_hoe",
            () -> new HoeItem(ModToolTiers.ATOM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ATOM, 0, -3.0f))));


    public static final RegistryObject<Item> ATOM_HAMMER = ITEMS.register("atom_hammer",
            () -> new HammerItem(ModToolTiers.ATOM, new Item.Properties()
                    .attributes(HammerItem.createAttributes(ModToolTiers.ATOM, 6, -3f))));


    public static final RegistryObject<Item> ATOM_HELMET = ITEMS.register("atom_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ATOM_ARMOR_MATERIAl, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));

    public static final RegistryObject<Item> ATOM_CHESTPLATE = ITEMS.register("atom_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ATOM_ARMOR_MATERIAl, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));

    public static final RegistryObject<Item> ATOM_LEGGINGS = ITEMS.register("atom_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ATOM_ARMOR_MATERIAl, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));

    public static final RegistryObject<Item> ATOM_BOOTS = ITEMS.register("atom_boots",
            () -> new ModArmorItem(ModArmorMaterials.ATOM_ARMOR_MATERIAl, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));


    public static final RegistryObject<Item> ATOM_HORSE_ARMOR = ITEMS.register("atom_horse_armor",
    ()-> new AnimalArmorItem(ModArmorMaterials.ATOM_ARMOR_MATERIAl, AnimalArmorItem.BodyType.EQUESTRIAN,
                             false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MACHI_SMITHING_TEMPLATE = ITEMS.register("machi_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "machi")));

    public static final RegistryObject<Item> SAIKYOU_BOW = ITEMS.register("saikyou_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));

    public static final RegistryObject<Item> CHARLES_MUSIC_DISC = ITEMS.register("charles_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.CHARLES_KEY).stacksTo(1)));

    public static final RegistryObject<Item> SUSHI_SEEDS = ITEMS.register("sushi_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SUSHI_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> BUSH_CAMP = ITEMS.register("bush_camp",
            () -> new ItemNameBlockItem(ModBlocks.BUSH_CAMP_BUSH.get(), new Item.Properties().food(ModFoodProperties.BUSH_CAMP)));


    //eventbus is an object holding event listeners and parameters for them
    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);
    }


}
