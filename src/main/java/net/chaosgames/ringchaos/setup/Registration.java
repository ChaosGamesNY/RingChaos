package net.chaosgames.ringchaos.setup;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.items.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {
    // Define Deferred Registries
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RingChaos.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RingChaos.MOD_ID);

    // Define Items
    public static final RegistryObject<Item> RING_CHAOS_TAB_ICON = ITEMS.register("ring_chaos_tab_icon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RING_DAMAGE = ITEMS.register("ring_damage",
            () -> new RingDamageItem(new Item.Properties()));
    public static final RegistryObject<Item> RING_REPAIR_SLOW = ITEMS.register("ring_repair_slow",
            () -> new RingRepairSlowItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
    public static final RegistryObject<Item> RING_REPAIR_INSTANT = ITEMS.register("ring_repair_instant",
            () -> new RingRepairInstantItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));

    // Define and populate creative mode tabs
    public static final RegistryObject<CreativeModeTab> RING_CHAOS_TAB = CREATIVE_MODE_TABS.register("ring_chaos_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.ring_chaos_tab"))
                    .icon(() -> new ItemStack(RING_CHAOS_TAB_ICON.get()))
                    .displayItems((pParameters, pOutput) -> {
                        if(FMLEnvironment.production) pOutput.accept(RING_DAMAGE.get());
                        pOutput.accept(RING_REPAIR_SLOW.get());
                        pOutput.accept(RING_REPAIR_INSTANT.get());

                    })
                    .build());
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            if(FMLEnvironment.production) event.accept(RING_DAMAGE);
            event.accept(RING_REPAIR_SLOW);
            event.accept(RING_REPAIR_INSTANT);
        }

    }

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }

}
