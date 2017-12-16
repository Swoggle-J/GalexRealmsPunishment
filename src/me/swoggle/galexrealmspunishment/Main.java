package me.swoggle.galexrealmspunishment;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("punish").setExecutor(new CommandPunish());

    }

    @Override
    public void onDisable() {

    }
}
