package net.chaosgames.ringchaos.misc;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.init.ItemInit;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RingChaos.MOD_ID)
public class EventHandler {
    @SubscribeEvent
    public static void nukeUnwantedItems(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (stack.is(ItemInit.RING_CHAOS_TAB_ICON.get())) {
                inventory.removeItem(stack);
            }
        }
    }
}
