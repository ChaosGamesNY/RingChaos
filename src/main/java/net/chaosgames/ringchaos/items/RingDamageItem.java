package net.chaosgames.ringchaos.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RingDamageItem extends Item {
    public RingDamageItem(Properties pProperties) { super(pProperties); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Inventory inventory = player.getInventory();
        for (int i = 0; i <= inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if(stack.isDamageableItem()) {
                stack.setDamageValue(stack.getMaxDamage() - 5);
            }
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

}
