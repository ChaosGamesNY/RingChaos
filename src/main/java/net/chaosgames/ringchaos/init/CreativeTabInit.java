package net.chaosgames.ringchaos.init;

import net.chaosgames.ringchaos.RingChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = RingChaos.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RingChaos.MOD_ID);

    public static final List<Supplier<? extends ItemLike>> RING_CHAOS_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> RING_CHAOS_TAB = CREATIVE_MODE_TABS.register("ring_chaos_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("constants.ringchaos.mod_name"))
                    .icon(ItemInit.RING_CHAOS_TAB_ICON.get()::getDefaultInstance)
                    .displayItems(((itemDisplayParameters, output) ->
                            RING_CHAOS_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()))))
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        RING_CHAOS_TAB_ITEMS.add(itemLike);
        return itemLike;
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            RING_CHAOS_TAB_ITEMS.forEach(itemLike -> event.accept(itemLike.get()));
        }
    }
}
