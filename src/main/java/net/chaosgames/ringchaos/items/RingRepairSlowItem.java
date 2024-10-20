package net.chaosgames.ringchaos.items;

import net.chaosgames.ringchaos.setup.Config;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RingRepairSlowItem extends Item {
    public RingRepairSlowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        Player player = (Player) pEntity;
        if(pSlotId == 0) {
            if(Math.floorMod(pLevel.getGameTime(), 200) == 0) {
                Inventory inventory = player.getInventory();

                for (int i = 0; i <= 40; i++) {
                    ItemStack itemStack = inventory.getItem(i);
                    if(Config.RING_REPAIR_XP.get()) {
                        int playerXP = player.totalExperience;
                        if (itemStack.isDamaged() && playerXP > 0) {
                            itemStack.setDamageValue(itemStack.getDamageValue() - 1);
                            player.giveExperiencePoints(-1);

                            break;
                        }
                    } else {
                        if (itemStack.isDamaged()) {
                            itemStack.setDamageValue(itemStack.getDamageValue() - 1);

                            break;
                        }
                    }
                }
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
