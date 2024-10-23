package net.chaosgames.ringchaos.items;

import net.chaosgames.ringchaos.setup.Config;
import net.chaosgames.ringchaos.setup.Utilities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RingRepairSlowItem extends Item {
    public RingRepairSlowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level level, Entity entity, int slotId, boolean isSelected) {
        Player player = (Player) entity;
        if(slotId == 0) {
            if(Math.floorMod(level.getGameTime(), 200) == 0) {
                Inventory inventory = player.getInventory();

                for (int i = 0; i < inventory.getContainerSize(); i++) {
                    ItemStack stack = inventory.getItem(i);

                    if (!stack.isDamageableItem() || !stack.isDamaged())
                        continue;

                    int damage = stack.getDamageValue();

                    if(Config.RING_REPAIR_XP.get()) {
                        int playerXp = Utilities.calcPlayerTotalXp(player.experienceProgress, player.experienceLevel);

                        if (playerXp > 0) {
                            stack.setDamageValue(damage - 1);
                            player.giveExperiencePoints(-1);

                            break;
                        }
                    } else {
                        stack.setDamageValue(damage - 1);

                        break;
                    }
                }
            }
        }
        super.inventoryTick(pStack, level, entity, slotId, isSelected);
    }
}
