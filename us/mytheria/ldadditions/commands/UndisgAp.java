package us.mytheria.ldadditions.commands;

import me.libraryaddict.disguise.DisguiseAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.mytheria.ldadditions.Additions;

public class UndisgAp implements CommandExecutor {

    Additions main;

    public UndisgAp(Additions main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender.hasPermission("libsdisguises.undisguiseplayer.all")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                DisguiseAPI.undisguiseToAll(p);
            }
            sender.sendMessage(main.uapMsg);
        } else {
            sender.sendMessage(main.noPermMsg);
        }
        return false;
    }

}
