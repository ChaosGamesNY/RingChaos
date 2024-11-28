package net.chaosgames.ringchaos.init;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.items.RingDamageItem;
import net.chaosgames.ringchaos.items.RingRepairInstantItem;
import net.chaosgames.ringchaos.items.RingRepairSlowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.chaosgames.ringchaos.init.CreativeTabInit.addToTab;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RingChaos.MOD_ID);

}
