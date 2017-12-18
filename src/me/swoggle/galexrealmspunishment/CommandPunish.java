package me.swoggle.galexrealmspunishment;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPunish implements CommandExecutor {
    public static String target_player;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("punish")) {
            if (args.length != 1){
                player.sendMessage("Incorrect command usage: /punish [Player]");
            } else {
                target_player = args[0];
                player.openInventory(InventoryPunishment.InventoryP);
            }
        }
        return true;

    }
}
