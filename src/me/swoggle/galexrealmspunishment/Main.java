package me.swoggle.galexrealmspunishment;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    static String kic;
    static int[] mutei = new int[9];
    static String[] muteu = new String[9];
    static String[] muteic = new String[9];
    static int[] bani = new int[9];
    static String[] banu = new String[9];
    static String[] banr = new String[9];
    static String[] banic = new String[9];
    static String pbanr;
    static String pbanic;





    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventsClass(), this);
        this.getCommand("punish").setExecutor(new CommandPunish());
        CreateConfig.createconfig();
        loadconfig();



        kic = this.getConfig().getString("Punishments.Kick.Icon");
        pbanr = this.getConfig().getString("Punishments.PermaBan.Reason");
        pbanic = this.getConfig().getString("Punishments.PermaBan.Icon");

        for (int i = 0; i < 9; i++) {
            mutei[i] = this.getConfig().getInt("Punishments.Mute" + i + ".Length");
            muteu[i] = this.getConfig().getString("Punishments.Mute" + i + ".LengthUnit");
            muteic[i] = this.getConfig().getString("Punishments.Mute" + i + ".Icon");

            bani[i] = this.getConfig().getInt("Punishments.Ban" + i + ".Length");
            banu[i] = this.getConfig().getString("Punishments.Ban" + i + ".LengthUnit");
            banr[i] = this.getConfig().getString("Punishments.Ban" + i + ".Reason");
            banic[i] = this.getConfig().getString("Punishments.Ban" + i + ".Icon");

        }
        for (int i = 0; i < 8; i++) {
            bani[i] = this.getConfig().getInt("Punishments.Ban" + i + ".Length");
            banu[i] = this.getConfig().getString("Punishments.Ban" + i + ".LengthUnit");
            banr[i] = this.getConfig().getString("Punishments.Ban" + i + ".Reason");
            banic[i] = this.getConfig().getString("Punishments.Ban" + i + ".Icon");

        }
    }



    @Override
    public void onDisable() {

    }

    private void loadconfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
