package net.chaosgames.ringchaos.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RingMendingSlowItem extends Item {
    public RingMendingSlowItem(Properties pProperties) { super(pProperties); }

    int tickCount = 0;

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        Player player = (Player) pEntity;
        if (pSlotId == 0) {
            if (tickCount >= 200) {
                Inventory inventory = player.getInventory();

                for (int i = 0; i <= 40; i++) {
                    ItemStack itemStack = inventory.getItem(i);
                    int playerXP = player.totalExperience;
                    if (itemStack.isDamaged() && itemStack.getDamageValue() <= playerXP) {
                        itemStack.setDamageValue(itemStack.getDamageValue() - 1);
                        player.giveExperiencePoints(-1);

                        break;
                    }
                }

                tickCount = 0;
            } else {
                tickCount++;
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
