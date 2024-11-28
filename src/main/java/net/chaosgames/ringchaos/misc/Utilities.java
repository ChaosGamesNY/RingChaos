package net.chaosgames.ringchaos.misc;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public static int calcPlayerTotalXp(double playerXp, int playerLevel) {
        int playerXpPoints = (int) (playerXp * calcTotalXpForLevel(playerLevel));
        if (playerLevel >= 0 && playerLevel <= 16) {
            return (int) (playerXpPoints + Math.pow(playerLevel, 2) + (6 * playerLevel));
        } else if (playerLevel <= 31) {
            return (int) (playerXpPoints + (2.5 * Math.pow(playerLevel, 2)) - (40.5 * playerLevel) + 360);
        } else {
            return (int) (playerXpPoints + (4.5 * Math.pow(playerLevel, 2)) - (162.5 * playerLevel) + 2220);
        }
    }

    public static int calcTotalXpForLevel(int playerLevel) {
        if (playerLevel >= 0 && playerLevel <= 15) {
            return 2 * playerLevel + 7;
        } else if(playerLevel <= 30) {
            return 5 * playerLevel - 38;
        } else {
            return 9 * playerLevel - 158;
        }
    }

    public static List<Block> getBlocksByTag(TagKey<Block> blockTagKey) {
        List<Block> blocksWithTag = new ArrayList<>();

        for (Block block : ForgeRegistries.BLOCKS) {
            if (block.defaultBlockState().is(blockTagKey)) {
                blocksWithTag.add(block);
            }
        }

        return blocksWithTag;
    }

    public static ItemLike getItemLikeFromIngredient(Ingredient ingredient) {
        ItemStack[] matchingStacks = ingredient.getItems();
        if(matchingStacks.length > 0) {
            return matchingStacks[0].getItem();
        }
        return null;
    }

}
