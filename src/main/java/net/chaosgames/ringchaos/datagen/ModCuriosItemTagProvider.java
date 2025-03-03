package net.chaosgames.ringchaos.datagen;

import net.chaosgames.ringchaos.init.ItemInit;
import net.chaosgames.ringchaos.init.TagInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.concurrent.CompletableFuture;

public class ModCuriosItemTagProvider extends ItemTagsProvider {
    public ModCuriosItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, "curios", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(TagInit.CURIO_RING).add(ItemInit.RING_REPAIR_SLOW.get());
    }
}
