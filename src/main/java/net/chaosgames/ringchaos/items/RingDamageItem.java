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
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        Inventory inventory = pPlayer.getInventory();
        for (int i = 0; i <= 40; i++) {
            ItemStack itemStack = inventory.getItem(i);
            if(itemStack.isDamageableItem()) {
                itemStack.setDamageValue(itemStack.getMaxDamage() - 5);
            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
}
