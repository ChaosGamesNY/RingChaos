package net.chaosgames.ringchaos.setup;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;

public class Commands {
    public static void onRegisterCommands(RegisterCommandsEvent pEvent) {
        pEvent.getDispatcher().register(net.minecraft.commands.Commands.literal("ringchaos")
                .then(net.minecraft.commands.Commands.literal("playerXP")
                        .executes(Commands::DisplayPlayerXPCount))
                .then(net.minecraft.commands.Commands.literal("dealDamage")
                        .executes(Commands::DealDamagePlayerTool)));
    }

    private static int DealDamagePlayerTool(CommandContext<CommandSourceStack> pcommandSourceStackCommandContext) {
        Player player = pcommandSourceStackCommandContext.getSource().getPlayer();
        ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (itemStack.isDamageableItem()) {
            itemStack.setDamageValue(5);
        } else {
            player.sendSystemMessage(Component.literal("Item in Player hand is not damageable./n Try with a different items."));
        }
        return 1;
    }

    public static int DisplayPlayerXPCount(CommandContext<CommandSourceStack> pcommandSourceStackCommandContext) {
        Player player = pcommandSourceStackCommandContext.getSource().getPlayer();
        player.sendSystemMessage(Component.literal("Player XP: " + player.totalExperience));

        return 1;
    }

}
