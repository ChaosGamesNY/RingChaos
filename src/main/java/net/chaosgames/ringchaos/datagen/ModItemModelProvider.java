package net.chaosgames.ringchaos.datagen;

import net.chaosgames.ringchaos.RingChaos;
import net.chaosgames.ringchaos.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RingChaos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemInit.RING_CHAOS_TAB_ICON);

        simpleItem(ItemInit.RING_DAMAGE);

        simpleItem(ItemInit.RING_REPAIR_INSTANT);
        simpleItem(ItemInit.RING_REPAIR_SLOW);

        simpleItem(ItemInit.RING_GLASS);
        simpleItem(ItemInit.SHATTERED_GLASS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RingChaos.MOD_ID, "item/" + item.getId().getPath()));
    }
}
