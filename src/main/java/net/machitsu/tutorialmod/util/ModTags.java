package net.machitsu.tutorialmod.util;

import net.machitsu.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.openjdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks{
        public static TagKey<Block> NEEDS_ATOM_TOOL = createTag("needs_atom_tool");
        public static TagKey<Block> INCORRECT_FOR_ATOM_TOOL = createTag("incorrect_for_atom_tool");



        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
        }
    }
}
