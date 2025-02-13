package net.machitsu.tutorialmod.datagen;

import net.machitsu.tutorialmod.blocks.ModBlocks;
import net.machitsu.tutorialmod.blocks.custon.SushiCropBlock;
import net.machitsu.tutorialmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.EDAMAME_ORE.get());

        this.add(ModBlocks.ALEXANDRITE_ORE.get(), block->createOreDrop(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.ALEXANDRITE.get()));
        this.add(ModBlocks.ALEXANDRITE_NETHER_ORE.get(), block->createOreDrop(ModBlocks.ALEXANDRITE_NETHER_ORE.get(), ModItems.ALEXANDRITE.get()));
        this.add(ModBlocks.ALEXANDRITE_END_ORE.get(), block->createMultipleOreDrops(ModBlocks.ALEXANDRITE_END_ORE.get(), ModItems.ALEXANDRITE.get(), 1, 6));

        this.add(ModBlocks.MIGI_BLOCK.get(), block -> createMultipleOreDrops(ModBlocks.MIGI_BLOCK.get(), ModItems.BOKUKUN.get(), 1.0f, 100.0f));

        dropSelf(ModBlocks.MIGI_BUTTON.get());
        dropSelf(ModBlocks.MIGI_WALL.get());
        dropSelf(ModBlocks.MIGI_TRAP_DOOR.get());
        dropSelf(ModBlocks.MIGI_FENCE.get());
        dropSelf(ModBlocks.MIGI_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.MIGI_FENCE_GATE.get());
        dropSelf(ModBlocks.MIGI_STAIR.get());

        this.add(ModBlocks.MIGI_DOOR.get(), block -> createDoorTable(ModBlocks.MIGI_DOOR.get()));
        this.add(ModBlocks.MIGI_SLAB.get(), block -> createSlabItemTable(ModBlocks.MIGI_SLAB.get()));

        dropSelf(ModBlocks.ATOM_LAMP_BLOCK.get());

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SUSHI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SushiCropBlock.AGE, 6));

        this.add(ModBlocks.SUSHI_CROP.get(), this.createCropDrops(ModBlocks.SUSHI_CROP.get(),
                ModItems.SUSHI.get(), ModItems.SUSHI_SEEDS.get(), lootItemConditionBuilder));


        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.BUSH_CAMP_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BUSH_CAMP_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.BUSH_CAMP.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BUSH_CAMP_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.BUSH_CAMP.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
