package net.chaosgames.ringchaos.misc;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LeaveBehindRecipeSerializer implements RecipeSerializer<LeaveBehindRecipe> {

    private static final Map<Item, Item> DEFAULT_LEAVE_BEHINDS = Map.of(
            Items.POWDER_SNOW_BUCKET, Items.BUCKET,
            Items.LAVA_BUCKET, Items.BUCKET
            // Add more as needed
    );

    @Override
    public LeaveBehindRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        ShapedRecipe vanilla = RecipeSerializer.SHAPED_RECIPE.fromJson(pRecipeId, pSerializedRecipe);
        return new LeaveBehindRecipe(vanilla, DEFAULT_LEAVE_BEHINDS);
    }

    @Override
    public @Nullable LeaveBehindRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        ShapedRecipe vanilla = RecipeSerializer.SHAPED_RECIPE.fromNetwork(pRecipeId, pBuffer);
        return new LeaveBehindRecipe(vanilla, DEFAULT_LEAVE_BEHINDS);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, LeaveBehindRecipe pRecipe) {
        RecipeSerializer.SHAPED_RECIPE.toNetwork(pBuffer, pRecipe);
    }
}
