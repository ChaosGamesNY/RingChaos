package net.chaosgames.ringchaos.misc;

import net.chaosgames.ringchaos.init.ConfigInit;
import net.chaosgames.ringchaos.items.RingRepairSlowItem;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class CurioCapabilityProvider implements ICapabilityProvider {

    private final ItemStack stack;
    private final ICurio curio;
    private final LazyOptional<ICurio> lazyOptional;

    public CurioCapabilityProvider(ItemStack stack) {
        this.stack = stack;
        this.curio = new ICurio() {
            public ItemStack getStack() {
                return stack;
            }

            @Override
            public void curioTick(SlotContext slotContext) {
                if (ConfigInit.RING_REPAIR_SLOW_SLOT.get().equals(2) || ConfigInit.RING_REPAIR_SLOW_SLOT.get().equals(1)) {
                    Player player = (Player) slotContext.entity();
                    if (Math.floorMod(player.level().getGameTime(), 100) == 0) {
                        Inventory inventory = player.getInventory();
                        boolean inventoryComplete = false;
                        RingRepairSlowItem.stopLoop = false;
                        for (int i = 0; i < inventory.getContainerSize(); i++) {
                            if (i == inventory.getContainerSize() - 1) {
                                inventoryComplete = true;
                            }
                            if (RingRepairSlowItem.stopLoop) {
                                break;
                            }

                            ItemStack stack = inventory.getItem(i);

                            if (RingRepairSlowItem.slowDamageRepair(stack, player)) {
                                RingRepairSlowItem.stopLoop = true;
                            }
                        }
                        if (inventoryComplete) {
                            CuriosApi.getCuriosInventory(player).ifPresent(curiosInventory -> {
                                curiosInventory.getCurios().forEach((slotType, stacksCurio) -> {
                                    if (stacksCurio != null) {
                                        RingRepairSlowItem.stopLoop = false;
                                        for (int i = 0; i < stacksCurio.getSlots(); i++) {
                                            if (RingRepairSlowItem.stopLoop) {
                                                break;
                                            }
                                            ItemStack stackCurio = stacksCurio.getStacks().getStackInSlot(i);

                                            if (RingRepairSlowItem.slowDamageRepair(stackCurio, player)) {
                                                RingRepairSlowItem.stopLoop = true;
                                            }
                                        }
                                    }
                                });
                            });
                        }
                    }
                }
                ICurio.super.curioTick(slotContext);
            }
        };
        this.lazyOptional = LazyOptional.of(() -> curio);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == top.theillusivec4.curios.api.CuriosCapability.ITEM) {
            return lazyOptional.cast();
        }
        return LazyOptional.empty();
    }
}
