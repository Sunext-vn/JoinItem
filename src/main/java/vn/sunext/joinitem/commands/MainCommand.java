package vn.sunext.joinitem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import vn.sunext.joinitem.JoinItem;

import java.util.Objects;

public class MainCommand implements CommandExecutor {

    private final JoinItem plugin = JoinItem.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
            return false;

        if (args.length == 2) {
            String playerName = args[0];
            String serverName = args[1];

            plugin.getConnectSystem().sendPlayer(Objects.requireNonNull(Bukkit.getPlayer(playerName)), serverName);
        }

        return false;
    }

}
