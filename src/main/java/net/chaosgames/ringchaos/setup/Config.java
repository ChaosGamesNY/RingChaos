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
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
    }

    private static void registerServerConfigs() {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        registerServerConfig(SERVER_BUILDER);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_BUILDER.build());
    }
    public static ForgeConfigSpec.BooleanValue RING_REPAIR_XP;
    public static void registerServerConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Settings for Ring Chaos Mod").push("ringchaos");
        RING_REPAIR_XP = builder
                .comment("Do the rings of repair take XP?")
                .define("ring_repair_xp", false);
        builder.pop();
    }
}
