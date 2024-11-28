package net.chaosgames.ringchaos.init;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.loot.predicates.BlockTagsCondition;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class LootConditionsInit {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITION_TYPES =
            DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, RingChaos.MOD_ID);

    public static final RegistryObject<LootItemConditionType> BLOCK_TAGS = LOOT_CONDITION_TYPES.register("block_tags",
            () -> new LootItemConditionType(new BlockTagsCondition.Serializer()));
}
