package net.chaosgames.ringchaos.items;

import net.chaosgames.ringchaos.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class RingGlassItem extends Item {
    public RingGlassItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pMiningEntity) {
        if(isCorrectToolForDrops(pStack, pState)) {
            if(pStack.isDamageableItem()) {
                pStack.setDamageValue(pStack.getDamageValue() + 1);
            }
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pMiningEntity);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return stack.is(ItemInit.RING_GLASS.get()) && (state.is(Tags.Blocks.GLASS) || state.is(Tags.Blocks.GLASS_PANES));
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.COPPER_INGOT);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repairIngredient) {
        return getRepairIngredient().test(repairIngredient);
    }
}
