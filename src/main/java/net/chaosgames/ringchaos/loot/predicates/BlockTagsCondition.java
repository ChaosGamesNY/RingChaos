package net.chaosgames.ringchaos.loot.predicates;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.chaosgames.ringchaos.init.LootConditionsInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Stream;

public class BlockTagsCondition implements LootItemCondition {

    private final TagKey<Block> blockTagKey;

    public BlockTagsCondition(TagKey<Block> blockTagKey) {
        this.blockTagKey = blockTagKey;
    }

    @Override
    public LootItemConditionType getType() {
        return LootConditionsInit.BLOCK_TAGS.get();
    }

    @Override
    public boolean test(LootContext context) {
        if(context.hasParam(LootContextParams.BLOCK_STATE)) {
            Stream<TagKey<Block>> blockTagKeys = context.getParam(LootContextParams.BLOCK_STATE).getTags();
            return blockTagKeys.anyMatch(tag -> tag.equals(blockTagKey));
        } else {
            return false;
        }
    }

    public static BlockTagsCondition.Builder blockHasTag(TagKey<Block> blockTagKey) {
        return new BlockTagsCondition.Builder(blockTagKey);
    }

    public static class Builder implements LootItemCondition.Builder {
        private final TagKey<Block> blockTagKey;

        public Builder(TagKey<Block> blockTagKey) {
            this.blockTagKey = blockTagKey;
        }

        @Override
        public LootItemCondition build() {
            return new BlockTagsCondition(blockTagKey);
        }
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<BlockTagsCondition> {

        @Override
        public void serialize(JsonObject pJson, BlockTagsCondition pValue, JsonSerializationContext pSerializationContext) {
            pJson.addProperty("block_tag", pValue.blockTagKey.location().toString());
        }

        @Override
        public BlockTagsCondition deserialize(JsonObject pJson, JsonDeserializationContext pSerializationContext) {
            ResourceLocation tagLocation = new ResourceLocation(GsonHelper.getAsString(pJson, "block_tag"));
            TagKey<Block> blockTagKey = TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), tagLocation);
            return new BlockTagsCondition(blockTagKey);
        }
    }
}
