package net.chaosgames.ringchaos.misc;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegisterCommandsEvent;

import java.util.List;

public class Commands {
    public static void onRegisterCommands(RegisterCommandsEvent pEvent) {
        pEvent.getDispatcher().register(net.minecraft.commands.Commands.literal("ringchaos")
                .then(net.minecraft.commands.Commands.literal("playerXP")
                        .executes(Commands::DisplayPlayerXPCount))
                .then(net.minecraft.commands.Commands.literal("dealDamage")
                        .executes(Commands::DealDamagePlayerTool))
                .then(net.minecraft.commands.Commands.literal("itemDamage")
                        .executes(Commands::DisplayItemDamage)));
    }

    private static int DisplayItemDamage(CommandContext<CommandSourceStack> commandSourceStackCommandContext) {
        Player player = commandSourceStackCommandContext.getSource().getPlayer();
        ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!itemStack.isDamageableItem()) {
            player.sendSystemMessage(Component.literal("Item in Player hand is not damageable."));
            player.sendSystemMessage(Component.literal("Try with a different items."));
        } else if (!itemStack.isDamaged()) {
            player.sendSystemMessage(Component.literal("Item in Player hand is not damaged."));
            player.sendSystemMessage(Component.literal("Try with a different items."));
        } else {
            int damageTaken = itemStack.getDamageValue();
            int maxDamage = itemStack.getMaxDamage();
            int damageLeft = maxDamage - damageTaken;
            player.sendSystemMessage(Component.literal("Item in Player hand has been used " + damageTaken + " times."));
            player.sendSystemMessage(Component.literal("Item in Player hand has " + damageLeft + " left of " + itemStack.getMaxDamage() + " uses."));
        }
        return 1;
    }


    private static int DealDamagePlayerTool(CommandContext<CommandSourceStack> commandSourceStackCommandContext) {
        Player player = commandSourceStackCommandContext.getSource().getPlayer();
        ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (itemStack.isDamageableItem()) {
            itemStack.setDamageValue(itemStack.getMaxDamage() - 5);
        } else {
            player.sendSystemMessage(Component.literal("Item in Player hand is not damageable./n Try with a different items."));
        }
        return 1;
    }

    private static int DisplayPlayerXPCount(CommandContext<CommandSourceStack> commandSourceStackCommandContext) {
        Player player = commandSourceStackCommandContext.getSource().getPlayer();
        int totalXp = Utilities.calcPlayerTotalXp(player.experienceProgress, player.experienceLevel);
        player.sendSystemMessage(Component.literal("Player total XP: " + totalXp + "/nPlayer Level: " + player.experienceLevel + "/nPlayer XP: " + player.experienceProgress + "/nLevel Points: " + Utilities.calcTotalXpForLevel(player.experienceLevel)));

        return 1;
    }

}
