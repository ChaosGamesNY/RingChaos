package net.chaosgames.ringchaos.init;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.misc.LeaveBehindRecipe;
import net.chaosgames.ringchaos.misc.LeaveBehindRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RingChaos.MOD_ID);
    public static final RegistryObject<RecipeSerializer<LeaveBehindRecipe>> LEAVE_BEHIND =
            SERIALIZERS.register("leave_behind", LeaveBehindRecipeSerializer::new);
    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
    }
}
