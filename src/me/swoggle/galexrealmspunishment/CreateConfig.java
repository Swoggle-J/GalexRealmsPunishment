package me.swoggle.galexrealmspunishment;

import org.bukkit.plugin.Plugin;

public class CreateConfig {
    private static Plugin plugin = Main.getPlugin(Main.class);
    public static void createconfig(){
        plugin.getConfig().addDefault("Punishments.Kick.Icon","leatherboots");
        for(int x=0; x<9; x++){
            plugin.getConfig().addDefault("Punishments.Mute"+String.valueOf(x)+".Length",-1);
            plugin.getConfig().addDefault("Punishments.Mute"+String.valueOf(x)+".LengthUnit","");
            plugin.getConfig().addDefault("Punishments.Mute"+String.valueOf(x)+".Icon","skull item");

        }
        for(int x=0;x<8; x++){
            plugin.getConfig().addDefault("Punishments.Ban"+String.valueOf(x)+".Length",-1);
            plugin.getConfig().addDefault("Punishments.Ban"+String.valueOf(x)+".LengthUnit","");
            plugin.getConfig().addDefault("Punishments.Ban"+String.valueOf(x)+".Reason","None");
            plugin.getConfig().addDefault("Punishments.Ban"+String.valueOf(x)+".Icon","obsidian");
        }
        plugin.getConfig().addDefault("Punishments.PermaBan.Reason","None");
        plugin.getConfig().addDefault("Punishments.PermaBan.Icon","bedrock");


    }

}
