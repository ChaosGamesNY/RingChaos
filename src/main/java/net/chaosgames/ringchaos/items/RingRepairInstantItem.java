package net.chaosgames.ringchaos.items;

import net.chaosgames.ringchaos.setup.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RingRepairInstantItem extends Item {
    public RingRepairInstantItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        Inventory inventory = pPlayer.getInventory();
        for (int i = 0; i <= 40; i++) {
            ItemStack itemStack = inventory.getItem(i);
            if(Config.RING_REPAIR_XP.get()) {
                int playerXP = pPlayer.totalExperience;
                pPlayer.sendSystemMessage(Component.literal("PlayerXP is " + playerXP));
                if(itemStack.getDamageValue() <= playerXP) {
                    pPlayer.giveExperiencePoints(-itemStack.getDamageValue());
                    itemStack.setDamageValue(0);
                } else if (itemStack.isDamaged() && playerXP > 0) {
                    itemStack.setDamageValue(itemStack.getDamageValue() - playerXP);
                    pPlayer.giveExperiencePoints(-playerXP);
                }
            } else {
                if (itemStack.isDamaged()) {
                    itemStack.setDamageValue(0);
                }
            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
}
