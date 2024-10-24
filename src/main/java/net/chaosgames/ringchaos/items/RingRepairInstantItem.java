package net.chaosgames.ringchaos.items;

import net.chaosgames.ringchaos.setup.Config;
import net.chaosgames.ringchaos.setup.Utilities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RingRepairInstantItem extends Item {
    public RingRepairInstantItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);

            if (!stack.isDamageableItem() || !stack.isDamaged())
                continue;

            if(Config.RING_REPAIR_INSTANT_XP.get()) {
                int playerXp = Utilities.calcPlayerTotalXp(player.experienceProgress, player.experienceLevel);
                int damage = stack.getDamageValue();
                if(damage <= playerXp) {
                    player.giveExperiencePoints(-damage);
                    stack.setDamageValue(0);
                } else if (playerXp > 0) {
                    stack.setDamageValue(damage - playerXp);
                    player.giveExperiencePoints(-playerXp);
                }
            } else {
                if (stack.isDamaged()) {
                    stack.setDamageValue(0);
                }
            }
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
