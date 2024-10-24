package net.chaosgames.ringchaos.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;


public class Config {
    public static void register() {
        registerServerConfigs();
        registerCommonConfigs();
        registerClientConfigs();
    }
    private static void registerClientConfigs() {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_BUILDER.build());
    }

    private static void registerCommonConfigs() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        //registerCommonConfig(COMMON_BUILDER);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
    }

    private static void registerServerConfigs() {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        registerServerConfig(SERVER_BUILDER);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_BUILDER.build());
    }
    public static ForgeConfigSpec.BooleanValue RING_REPAIR_INSTANT_XP;
    public static ForgeConfigSpec.BooleanValue RING_REPAIR_SLOW_XP;
    public static void registerServerConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Which rings will use XP?")
                .translation("config.ringchaos.server.ring_xp")
                .push("Ring XP Usage");

        RING_REPAIR_INSTANT_XP = builder
                .comment("Ring of Restoration")
                .translation("item.ringchaos.ring_repair_instant")
                .define("ring_repair_instant_xp", false);
        RING_REPAIR_SLOW_XP = builder
                .comment("Ring of Reconstruction")
                .translation("item.ringchaos.ring_repair_slow")
                .define("ring_repair_slow_XP", false);
        builder.pop();
    }
}
