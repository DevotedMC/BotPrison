package org.ame.botprison.command;

import org.ame.botprison.ConfigManager;
import org.ame.botprison.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;

import java.util.List;
import java.util.UUID;

public class Remove implements CommandExecutor {
    public Remove(Configuration config, Main main, boolean useUUID) {
        this.config = config;
        this.main = main;
        this.useUUID = useUUID;
    }

    private Configuration config;
    private Main main;
    private boolean useUUID;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!commandSender.hasPermission("botprison.remove")) {
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

        ConfigManager.botPlayers.remove(player.getUniqueId());
        List<String> bots = config.getStringList("botsUUID");
        bots.remove(player.getUniqueId().toString());
        config.set("botsUUID", bots);
        main.saveConfig();

        main.getServer().getPlayer(player.getUniqueId()).teleport(main.getServer().getWorld("world").getSpawnLocation());

        commandSender.sendMessage(ChatColor.RED + "Removed " + playerNameOrUUID);

        return true;
    }
}
