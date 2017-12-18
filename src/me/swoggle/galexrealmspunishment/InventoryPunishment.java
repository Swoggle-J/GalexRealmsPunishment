package me.swoggle.galexrealmspunishment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

public class InventoryPunishment {
    private static ItemStack setNameAndLore(Material material, int amount, String name, String... lore)
    {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        ArrayList<String> lorez = new ArrayList<>();
        for(String mylores : lore)
        {
            lorez.add(ChatColor.translateAlternateColorCodes('&', mylores));
        }
        meta.setLore(lorez);
        item.setItemMeta(meta);
        return item;
    }

    public static Inventory InventoryP = Bukkit.createInventory(null, 27, "Punishments");


    static {
        Material iconk = Material.matchMaterial(Main.kic);
        Material iconp = Material.matchMaterial(Main.pbanic);
        InventoryP.setItem(0, new ItemStack(setNameAndLore(iconk, 1, "&6Punishment: &1Kick")));
        InventoryP.setItem(26, new ItemStack(setNameAndLore(iconp, 1, "&6Punishment: &FPermanentBan","&6Reason: "+"&C"+Main.pbanr)));

        for(int x=0; x<9; x++){
            Material iconm = Material.matchMaterial(Main.muteic[x]);
            InventoryP.setItem(x+9, new ItemStack(setNameAndLore(iconm, 1, "&6Punishment: &1Mute " + String.valueOf(Main.mutei[x]) + " " + (Main.muteu[x]))));
        }
        for(int x=0; x<8; x++){
            Material iconb = Material.matchMaterial(Main.banic[x]);
            InventoryP.setItem(x+18, new ItemStack(setNameAndLore(iconb, 1, "&6Punishment: &1Ban " + String.valueOf(Main.bani[x]) + " " + (Main.banu[x]), "&6Reason: "+" &C"+Main.banr[x])));
        }
    }
}