package org.ame.botprison;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigManager {
    public static Set<UUID> botPlayers = new HashSet<>();

    public static void loadConfig(Configuration config, Logger logger, Main main) {
        config.addDefault("botsUUID", new ArrayList<String>());
        config.addDefault("botsUsername", new ArrayList<String>());

        config.options().copyDefaults(true);
        main.saveConfig();

        for (String username : config.getStringList("botsUsername")) {
            @SuppressWarnings("deprecation") OfflinePlayer player = Bukkit.getOfflinePlayer(username);
            if (player == null) {
                logger.log(Level.CONFIG, "There wasn't a UUID accocated with " + username + ". Maybe they" +
                        "haven't logged in in 30 days?");
                continue;
            }
            UUID uuid = player.getUniqueId();
            @SuppressWarnings("unchecked")
            List<String> botsUUID = (List<String>) config.get("botsUUID");
            @SuppressWarnings("unchecked")
            List<String> botsUsername = config.getStringList("botsUsername");
            botsUsername.remove(username);
            botsUUID.add(uuid.toString());

            config.set("botsUUID", botsUUID);
            config.set("botsUsername", botsUsername);
        }

        main.saveConfig();

        for (String uuidString : config.getStringList("botsUUID")) {
            UUID playerUUID = UUID.fromString(uuidString);
            botPlayers.add(playerUUID);
        }
    }
}
