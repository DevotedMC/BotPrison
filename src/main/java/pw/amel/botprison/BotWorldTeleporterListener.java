package pw.amel.botprison;

import org.bukkit.Location;
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
            Location spawn = main.getServer().getWorld("world_bot_prison").getSpawnLocation();
            spawn.setY(1);
            event.getPlayer().teleport(spawn);
        }
    }

    public void onPlayerMove(PlayerMoveEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            World botWorld = main.getServer().getWorld("world_bot_prison");
            if (event.getTo().getWorld() != botWorld) {
                Location spawn = botWorld.getSpawnLocation();
                spawn.setY(1);
                event.getPlayer().teleport(spawn);
            }
        }
    }
}
