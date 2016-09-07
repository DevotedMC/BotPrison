package org.ame.botprison;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class BotWorldTeleporterListener implements Listener {
    public BotWorldTeleporterListener(Main main) {
        this.main = main;
    }

    private Main main;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.getPlayer().teleport(main.getServer().getWorld("world_bot_prison").getSpawnLocation());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event) {
        World botWorld = main.getServer().getWorld("world_bot_prison");
        if (event.getTo().getWorld() != botWorld) {
            event.getPlayer().teleport(botWorld.getSpawnLocation());
        }
    }
}
