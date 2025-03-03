package net.chaosgames.ringchaos.items;

import net.chaosgames.ringchaos.init.ConfigInit;
import net.chaosgames.ringchaos.misc.Utilities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.CuriosApi;

public class RingRepairInstantItem extends Item {
    public RingRepairInstantItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Inventory inventory = player.getInventory();
        boolean inventoryComplete = false;
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (i == inventory.getContainerSize() - 1) {
                inventoryComplete = true;
            }
            ItemStack stack = inventory.getItem(i);

            if (!stack.isDamageableItem() || !stack.isDamaged())
                continue;

            if(ConfigInit.RING_REPAIR_INSTANT_XP.get()) {
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
        if(inventoryComplete) {
            CuriosApi.getCuriosInventory(player).ifPresent(curiosInventory -> {
                curiosInventory.getCurios().forEach((slotType, stacksCurio) -> {
                    if (stacksCurio != null) {
                        for (int i = 0; i < stacksCurio.getSlots(); i++) {
                            ItemStack stackCurio = stacksCurio.getStacks().getStackInSlot(i);
                            if (!stackCurio.isDamageableItem() || !stackCurio.isDamaged())
                                continue;

                            if(ConfigInit.RING_REPAIR_INSTANT_XP.get()) {
                                int playerXp = Utilities.calcPlayerTotalXp(player.experienceProgress, player.experienceLevel);
                                int damage = stackCurio.getDamageValue();
                                if(damage <= playerXp) {
                                    player.giveExperiencePoints(-damage);
                                    stackCurio.setDamageValue(0);
                                } else if (playerXp > 0) {
                                    stackCurio.setDamageValue(damage - playerXp);
                                    player.giveExperiencePoints(-playerXp);
                                }
                            } else {
                                if (stackCurio.isDamaged()) {
                                    stackCurio.setDamageValue(0);
                                }
                            }
                        }
                    }
                });
            });
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
