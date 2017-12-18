package me.swoggle.galexrealmspunishment;

import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventsClass implements Listener {
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();
        if (inventory.getName().equals(InventoryPunishment.InventoryP.getName())) {
            Player player = (Player) event.getPlayer();
            if (!player.hasPermission("galexrealmspunishment.kick")) {
                InventoryPunishment.InventoryP.setItem(0, null);
            }

            if (!player.hasPermission("galexrealmspunishment.mute")) {
                for (int x = 0; x < 9; x++) {
                    if (InventoryPunishment.InventoryP.getItem(x + 9) == null) {
                        return;
                    } else {
                        InventoryPunishment.InventoryP.setItem(x + 9, null);
                    }
                }

            }

            if (!player.hasPermission("galexrealmspunishment.ban")) {
                for (int x = 0; x < 8; x++) {
                    if (InventoryPunishment.InventoryP.getItem(x + 18) == null) {
                        return;
                    } else {
                        InventoryPunishment.InventoryP.setItem(x + 18, null);
                    }
                }

            }

            if (!player.hasPermission("galexrealmspunishment.permaban")) {
                InventoryPunishment.InventoryP.setItem(26, null);
            }
        }

        for (int x = 0; x < 9; x++) {
            if (InventoryPunishment.InventoryP.getItem(x + 9) == null) {
                return;
            }

            if (InventoryPunishment.InventoryP.getItem(x + 9).getItemMeta().getDisplayName().contains("-1")) {
                InventoryPunishment.InventoryP.setItem(x + 9, null);
            }
        }
        for (int x = 0; x < 8; x++) {
            if (InventoryPunishment.InventoryP.getItem(x + 18) == null) {
                return;
            }
            if (InventoryPunishment.InventoryP.getItem(x + 18).getItemMeta().getDisplayName().contains("-1")) {
                InventoryPunishment.InventoryP.setItem(x + 18, null);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        Server server = Bukkit.getServer();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        try {

            if (inventory.getName().equals(InventoryPunishment.InventoryP.getName())) {
                event.setCancelled(true);
                if (clicked.getItemMeta().getDisplayName().contains("Kick")) {
                    server.dispatchCommand(player, "kick " + CommandPunish.target_player);
                    return;
                }
                if (clicked.getItemMeta().getDisplayName().contains("Mute")) {
                    int val = 0;
                    for (int i = 0; i < 9; i++) {
                        if (event.getSlot() == i + 9) {
                            val = i;
                        }
                    }
                    server.dispatchCommand(player, "mute " + CommandPunish.target_player + " " + Main.mutei[val] + Main.muteu[val]);
                    return;
                }
                if (clicked.getItemMeta().getDisplayName().contains("PermanentBan")) {
                    String reason = Main.pbanr;
                    if (reason.equals("None")) {
                        server.dispatchCommand(player, "ban " + CommandPunish.target_player);
                        return;
                    } else {
                        server.dispatchCommand(player, "ban " + CommandPunish.target_player + " " + reason);
                        return;
                    }
                }
                if (clicked.getItemMeta().getDisplayName().contains("Ban")) {
                    int val = 0;
                    for (int i = 0; i < 8; i++) {
                        if (event.getSlot() == i + 18) {
                            val = i;
                        }
                    }
                    String reason = Main.banr[val];
                    if (reason.equals("None")) {
                        server.dispatchCommand(player, "tempban " + CommandPunish.target_player + " " + Main.bani[val] + Main.banu[val]);
                    } else {
                        server.dispatchCommand(player, "tempban " + CommandPunish.target_player + " " + Main.bani[val] + Main.banu[val] + " " + reason);
                    }
                }
            }
        } catch (java.lang.NullPointerException ignored) {
        }
    }
}


