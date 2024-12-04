package net.chaosgames.ringchaos.datagen;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.init.ItemInit;
import net.chaosgames.ringchaos.loot.AddItemModifier;
import net.chaosgames.ringchaos.loot.predicates.BlockTagsCondition;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, RingChaos.MOD_ID);
    }

    @Override
    protected void start() {
        add("shattered_glass_from_glass_block", new AddItemModifier(new LootItemCondition[]{
                BlockTagsCondition.blockHasTag(Tags.Blocks.GLASS).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemInit.RING_GLASS.get())).build()}, ItemInit.SHATTERED_GLASS.get(), 4));
        add("shattered_glass_from_glass_pane", new AddItemModifier(new LootItemCondition[]{
                BlockTagsCondition.blockHasTag(Tags.Blocks.GLASS_PANES).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemInit.RING_GLASS.get())).build()}, ItemInit.SHATTERED_GLASS.get(), 2));
    }
}
