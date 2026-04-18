package net.chaosgames.ringchaos.datagen;

import com.google.gson.JsonObject;
import net.chaosgames.ringchaos.init.RecipeInit;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

public class LeaveBehindFinishedRecipe implements FinishedRecipe {
    private final FinishedRecipe original;
    private final ResourceLocation serializerId;

    public LeaveBehindFinishedRecipe(FinishedRecipe original, ResourceLocation serializerId) {
        this.original = original;
        this.serializerId = serializerId;
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {
        original.serializeRecipeData(pJson);
        pJson.addProperty("type", serializerId.toString());
    }

    @Override
    public ResourceLocation getId() {
        return original.getId();
    }

    @Override
    public RecipeSerializer<?> getType() {
        return RecipeInit.LEAVE_BEHIND.get();
    }

    @Override
    public @Nullable JsonObject serializeAdvancement() {
        return original.serializeAdvancement();
    }

    @Override
    public @Nullable ResourceLocation getAdvancementId() {
        return original.getAdvancementId();
    }
}
