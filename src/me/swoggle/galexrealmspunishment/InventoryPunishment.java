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
        ArrayList<String> lorez = new ArrayList<String>();
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
        InventoryP.setItem(0, new ItemStack(setNameAndLore(Material.LEATHER_BOOTS, 1, "&6Punishment: &1Kick", "&6Reason: &1Custom...")));
    }
}