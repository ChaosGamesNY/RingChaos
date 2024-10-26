package net.chaosgames.ringchaos;

import net.chaosgames.ringchaos.init.CreativeTabInit;
import net.chaosgames.ringchaos.init.ItemInit;
import net.chaosgames.ringchaos.init.ConfigInit;
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
        ConfigInit.register();

        //MinecraftForge.EVENT_BUS.addListener(Commands::onRegisterCommands);

    }

}
