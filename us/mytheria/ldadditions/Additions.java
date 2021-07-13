package us.mytheria.ldadditions;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import us.mytheria.ldadditions.commands.UndisgAp;

public class Additions extends JavaPlugin implements Listener {

    UndisgAp undisguiseAllPlayers;
    public String noPermPath = "Messages.NoPermission";
    public String noPermMsg;
    public String uapPath = "Messages.UndisguisedAllPlayers";
    public String uapMsg;

    @Override
    public void onEnable() {
        loadConfiguration();
        undisguiseAllPlayers = new UndisgAp(this);
        getCommand("undisgap").setExecutor(undisguiseAllPlayers);
    }


    public void loadConfiguration() {
        getConfig().addDefault(noPermPath, "Unknown command. Type \"/help\" for help.");
        noPermMsg = getConfig().getString(noPermPath);
        getConfig().addDefault(uapPath, "§cNo player is longer disguised");
        uapMsg = getConfig().getString(uapPath);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}