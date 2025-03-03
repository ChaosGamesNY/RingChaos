package net.chaosgames.ringchaos.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.CuriosApi;

public class TagInit {
    public static final TagKey<Item> CURIO_RING = ItemTags.create(new ResourceLocation(CuriosApi.MODID, "ring"));
}
