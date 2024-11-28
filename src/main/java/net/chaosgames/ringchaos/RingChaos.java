package net.chaosgames.ringchaos;

import net.chaosgames.ringchaos.init.*;
import net.chaosgames.ringchaos.loot.ModLootModifiers;
import net.chaosgames.ringchaos.misc.Commands;
import net.minecraft.SharedConstants;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RingChaos.MOD_ID)
public class RingChaos {
    public static final String MOD_ID = "ringchaos";

    public RingChaos() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeTabInit.CREATIVE_MODE_TABS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        LootConditionsInit.LOOT_CONDITION_TYPES.register(modEventBus);
        ConfigInit.register();

        ModLootModifiers.register(modEventBus);

        if(!SharedConstants.IS_RUNNING_IN_IDE) {
            MinecraftForge.EVENT_BUS.addListener(Commands::onRegisterCommands);
        }

    }

}
