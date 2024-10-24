package net.chaosgames.ringchaos;

import com.mojang.logging.LogUtils;
import net.chaosgames.ringchaos.setup.Commands;
import net.chaosgames.ringchaos.setup.Config;
import net.chaosgames.ringchaos.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(RingChaos.MOD_ID)
public class RingChaos {
    public static final String MOD_ID = "ringchaos";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RingChaos() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.init(modEventBus);
        Config.register();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(Registration::addCreative);

        if(FMLEnvironment.production) {
            MinecraftForge.EVENT_BUS.addListener(Commands::onRegisterCommands);
        }

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
