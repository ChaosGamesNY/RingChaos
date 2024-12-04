package net.chaosgames.ringchaos.loot;

import com.google.common.base.Suppliers;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.itemStack.getItem()))
                    .and(Codec.INT.fieldOf("count").forGetter(m -> m.itemStack.getCount()))
                    .apply(inst, AddItemModifier::new)));
    private final ItemStack itemStack;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item, int numDropped) {
        super(conditionsIn);
        this.itemStack = new ItemStack(item, numDropped);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for(LootItemCondition condition : this.conditions) {
            if(!condition.test(context)) {
                return generatedLoot;
            }
        }

        generatedLoot.add(new ItemStack(this.itemStack.getItem(), this.itemStack.getCount()));

        return generatedLoot;
    }

    public class Serializer implements net.minecraft.world.level.storage.loot.Serializer<AddItemModifier> {

        @Override
        public void serialize(JsonObject pJson, AddItemModifier pValue, JsonSerializationContext pSerializationContext) {
            pJson.addProperty("item", pValue.itemStack.getItem().toString());
            pJson.addProperty("count", pValue.itemStack.getCount());
        }

        @Override
        public AddItemModifier deserialize(JsonObject pJson, JsonDeserializationContext pSerializationContext) {
            ItemStack itemStack = new ItemStack(GsonHelper.getAsItem(pJson, "item"), GsonHelper.getAsInt(pJson, "count"));
            return new AddItemModifier(AddItemModifier.this.conditions, itemStack.getItem(), itemStack.getCount());
        }
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
