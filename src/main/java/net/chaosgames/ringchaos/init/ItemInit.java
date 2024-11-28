package net.chaosgames.ringchaos.init;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.items.RingDamageItem;
import net.chaosgames.ringchaos.items.RingGlassItem;
import net.chaosgames.ringchaos.items.RingRepairInstantItem;
import net.chaosgames.ringchaos.items.RingRepairSlowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.chaosgames.ringchaos.init.CreativeTabInit.addToTab;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RingChaos.MOD_ID);

    public static final RegistryObject<Item> RING_CHAOS_TAB_ICON = ITEMS.register("ring_chaos_tab_icon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RING_DAMAGE = ITEMS.register("ring_damage",
            () -> new RingDamageItem(new Item.Properties()));
    public static final RegistryObject<Item> RING_REPAIR_SLOW = addToTab(ITEMS.register("ring_repair_slow",
            () -> new RingRepairSlowItem(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .stacksTo(1)
            )));
    public static final RegistryObject<Item> RING_REPAIR_INSTANT = addToTab(ITEMS.register("ring_repair_instant",
            () -> new RingRepairInstantItem(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .stacksTo(1)
            )));
    public static final RegistryObject<Item> RING_GLASS = addToTab(ITEMS.register("ring_glass",
            () -> new RingGlassItem(new Item.Properties()
                    .rarity(Rarity.COMMON)
                    .durability(100))));
    public static final RegistryObject<Item> SHATTERED_GLASS_BLOCK = addToTab(ITEMS.register("shattered_glass_block",
            () -> new Item(new Item.Properties())));
    public static final RegistryObject<Item> SHATTERED_GLASS_PANE = addToTab(ITEMS.register("shattered_glass_pane",
            () -> new Item(new Item.Properties())));
}
