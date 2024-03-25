package net.chaosgames.ringchaos.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RingMendingInstantItem extends Item {
    public RingMendingInstantItem(Properties pProperties) { super(pProperties); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        Inventory inventory = pPlayer.getInventory();
        for (int i = 0; i <= 40; i++) {
            ItemStack itemStack = inventory.getItem(i);
            int playerXP = pPlayer.totalExperience;
            if(itemStack.getDamageValue() <= playerXP) {
                pPlayer.giveExperiencePoints(-itemStack.getDamageValue());
                itemStack.setDamageValue(0);
            } else if (itemStack.isDamaged() && playerXP > 0) {
                itemStack.setDamageValue(itemStack.getDamageValue() - playerXP);
                pPlayer.giveExperiencePoints(-playerXP);
            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
}
