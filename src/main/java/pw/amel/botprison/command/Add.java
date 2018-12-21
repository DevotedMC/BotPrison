package pw.amel.botprison.command;


import pw.amel.botprison.ConfigManager;
import pw.amel.botprison.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class Add implements CommandExecutor {
    public Add(Configuration config, Main main, boolean useUUID) {
        this.config = config;
        this.main = main;
        this.useUUID = useUUID;
    }

    private Configuration config;
    private Main main;
    private boolean useUUID;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!commandSender.hasPermission("botprison.add")) {
            return false;
        }

        if (args.length != 1) {
            return false;
        }

        String playerNameOrUUID = args[0];
        OfflinePlayer player;
        if (useUUID) {
            try {
                player = Bukkit.getOfflinePlayer(UUID.fromString(playerNameOrUUID));
            } catch (IllegalArgumentException e) {
                commandSender.sendMessage(ChatColor.RED + "That was not a valid UUID.");
                return false;
            }
        } else {
            //noinspection deprecation
            player = Bukkit.getOfflinePlayer(playerNameOrUUID);
        }

        if (player == null) {
            commandSender.sendMessage(ChatColor.RED + "That wasn't a valid player.");
            return false;
        }

        ConfigManager.botPlayers.add(player.getUniqueId());
        List<String> bots = config.getStringList("botsUUID");
        bots.add(player.getUniqueId().toString());
        config.set("botsUUID", bots);
        main.saveConfig();

        for (Player onlinePlayer : main.getServer().getOnlinePlayers()) {
            if (onlinePlayer.getUniqueId() == player.getUniqueId()) {
                onlinePlayer.teleport(main.getServer().getWorld("world_bot_prison").getSpawnLocation());
                break;  // Slight optimization, since it's basically gaurenteed the same player can't be on the same server
                        // twice.
            }
        }

        commandSender.sendMessage(ChatColor.RED + "Added " + playerNameOrUUID);

        return true;
    }
}
