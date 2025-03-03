package net.chaosgames.ringchaos.items;

import net.chaosgames.ringchaos.init.ConfigInit;
import net.chaosgames.ringchaos.misc.CurioCapabilityProvider;
import net.chaosgames.ringchaos.misc.Utilities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

public class RingRepairSlowItem extends Item {
    public RingRepairSlowItem(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        if(ModList.get().isLoaded("curios")) {
            return new CurioCapabilityProvider(stack);
        }
        return null;
    }

    public static boolean stopLoop = false;

    @Override
    public void inventoryTick(ItemStack pStack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(ConfigInit.RING_REPAIR_SLOW_SLOT.get().equals(0) || ConfigInit.RING_REPAIR_SLOW_SLOT.get().equals(2)) {
            Player player = (Player) entity;
            if (slotId == 0) {
                if (Math.floorMod(level.getGameTime(), 200) == 0) {
                    Inventory inventory = player.getInventory();
                    boolean inventoryComplete = false;
                    stopLoop = false;

                    for (int i = 0; i < inventory.getContainerSize(); i++) {
                        if (i == inventory.getContainerSize() - 1) {
                            inventoryComplete = true;
                        }
                        if (stopLoop) {
                            break;
                        }

                        ItemStack stack = inventory.getItem(i);

                        if (slowDamageRepair(stack, player)) {
                            stopLoop = true;
                        }

                    }

                    if (inventoryComplete) {
                        LazyOptional<ICuriosItemHandler> curiosInventory = CuriosApi.getCuriosInventory(player);
                        if (curiosInventory.isPresent()) {
                            ICuriosItemHandler curiosHandler = curiosInventory.orElseThrow(() -> new IllegalStateException("Curios handler not found"));
                            curiosHandler.getCurios().forEach((slotType, stacksCurio) -> {
                                if (stacksCurio != null) {
                                    stopLoop = false;
                                    for (int i = 0; i < stacksCurio.getSlots(); i++) {
                                        if (stopLoop) {
                                            break;
                                        }
                                        ItemStack stackCurio = stacksCurio.getStacks().getStackInSlot(i);

                                        if (slowDamageRepair(stackCurio, player)) {
                                            stopLoop = true;
                                        }
                                    }
                                }
                            });
                        }

                    }
                }
            }
        }
        super.inventoryTick(pStack, level, entity, slotId, isSelected);
    }

    public static boolean slowDamageRepair(ItemStack stack, Player player) {
        if (stack.isDamageableItem() && stack.isDamaged()) {

            int damage = stack.getDamageValue();

            if (ConfigInit.RING_REPAIR_SLOW_XP.get()) {
                int playerXp = Utilities.calcPlayerTotalXp(player.experienceProgress, player.experienceLevel);

                if (playerXp > 0) {
                    stack.setDamageValue(damage - 1);
                    player.giveExperiencePoints(-1);
                }
                return true;
            } else {
                stack.setDamageValue(damage - 1);

                return true;
            }
        }
        return false;
    }
}
