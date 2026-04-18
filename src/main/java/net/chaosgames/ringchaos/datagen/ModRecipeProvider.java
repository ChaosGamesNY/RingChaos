package net.chaosgames.ringchaos.datagen;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.init.ItemInit;
import net.chaosgames.ringchaos.misc.Utilities;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.RING_REPAIR_SLOW.get())
                .pattern("ARA")
                .pattern("G#G")
                .pattern("GGG")
                .define('A', Items.AMETHYST_SHARD)
                .define('R', Items.REDSTONE)
                .define('#', ItemTags.ANVIL)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.ANVIL), has(ItemTags.ANVIL))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.RING_REPAIR_INSTANT.get())
                .pattern("ADA")
                .pattern("G#G")
                .pattern("GGG")
                .define('A', Items.AMETHYST_SHARD)
                .define('D', Items.DIAMOND)
                .define('#', ItemTags.ANVIL)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.ANVIL), has(ItemTags.ANVIL))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.RING_GLASS.get())
                .pattern("_G_")
                .pattern("C C")
                .pattern("CCC")
                .define('_', Items.SMOOTH_STONE_SLAB)
                .define('G', Tags.Items.GLASS)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.GLASS), has(Tags.Items.GLASS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.GLASS)
                .requires(ItemInit.SHATTERED_GLASS.get(), 4)
                .unlockedBy(getHasName(ItemInit.SHATTERED_GLASS.get()), has(ItemInit.SHATTERED_GLASS.get()))
                .save(pWriter, new ResourceLocation(RingChaos.MOD_ID, "glass_from_shattered_glass"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GLASS_PANE)
                .requires(ItemInit.SHATTERED_GLASS.get(), 2)
                .unlockedBy(getHasName(ItemInit.SHATTERED_GLASS.get()), has(ItemInit.SHATTERED_GLASS.get()))
                .save(pWriter, new ResourceLocation(RingChaos.MOD_ID, "glass_pane_from_shattered_glass"));

        ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.PEARL_FRAGMENTS.get())
                .pattern("ESG")
                .pattern("LPL")
                .pattern("GSE")
                .define('E', Items.ECHO_SHARD)
                .define('S', Items.POWDER_SNOW_BUCKET)
                .define('G', Items.GHAST_TEAR)
                .define('L', Items.LAVA_BUCKET)
                .define('P', Items.ENDER_PEARL)
                .unlockedBy(getHasName(Items.ECHO_SHARD), has(Items.ECHO_SHARD))
                .unlockedBy(getHasName(Items.POWDER_SNOW_BUCKET), has(Items.POWDER_SNOW_BUCKET))
                .unlockedBy(getHasName(Items.GHAST_TEAR), has(Items.GHAST_TEAR))
                .unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET))
                .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL));
        builder.save(finishedRecipe -> pWriter.accept(
                new LeaveBehindFinishedRecipe(
                        finishedRecipe,
                        new ResourceLocation(RingChaos.MOD_ID, "leave_behind")
                )
        ));
    }

    private void oreSmeltingRecipe(Consumer<FinishedRecipe> consumer, Ingredient ingredient, RecipeCategory category, Item result, float experience, int cookTime, String name) {
        SimpleCookingRecipeBuilder.smelting(ingredient, category, result, experience, cookTime)
                .unlockedBy("has_" + name, has(Utilities.getItemLikeFromIngredient(ingredient)))
                .save(consumer, new ResourceLocation(RingChaos.MOD_ID, name));
    }
    private void oreBlastingRecipe(Consumer<FinishedRecipe> consumer, Ingredient ingredient, RecipeCategory category, Item result, float experience, int cookTime, String name) {
        SimpleCookingRecipeBuilder.blasting(ingredient, category, result, experience, cookTime)
                .unlockedBy("has_" + name, has(Utilities.getItemLikeFromIngredient(ingredient)))
                .save(consumer, new ResourceLocation(RingChaos.MOD_ID, name));
    }
}
