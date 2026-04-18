package net.chaosgames.ringchaos.misc;

import net.minecraft.core.NonNullList;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;

import java.util.Map;

public class LeaveBehindRecipe extends ShapedRecipe {

    private final Map<Item, Item> leaveBehinds;

    public LeaveBehindRecipe(ShapedRecipe original, Map<Item, Item> leaveBehinds) {
        super(original.getId(), original.getGroup(), original.category(),
                original.getWidth(), original.getHeight(), original.getIngredients(),
                original.getResultItem(null));
        this.leaveBehinds = leaveBehinds;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer inv) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(inv.getContainerSize(), ItemStack.EMPTY);

        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            Item leaveBehind = leaveBehinds.get(stack.getItem());

            if (leaveBehind != null) {
                remaining.set(i, new ItemStack(leaveBehind));
            } else {
                remaining.set(i, net.minecraftforge.common.ForgeHooks.getCraftingRemainingItem(stack));
            }
        }

        return remaining;
    }
}
