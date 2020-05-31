package pw.amel.botprison;

import pw.amel.botprison.command.Add;
import pw.amel.botprison.command.Reload;
import pw.amel.botprison.command.Remove;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        ConfigManager.loadConfig(getConfig(), getLogger(), this);

        getCommand("bpreload").setExecutor(new Reload(getConfig(), getLogger(), this));

        getCommand("bpadd").setExecutor(new Add(getConfig(), this, false));
        getCommand("bpadduuid").setExecutor(new Add(getConfig(), this, true));

        getCommand("bpremove").setExecutor(new Remove(getConfig(), this, false));
        getCommand("bpremoveuuid").setExecutor(new Remove(getConfig(), this, true));

        WorldCreator worldCreator = new WorldCreator("world_bot_prison");
        worldCreator.generator(new BotWorldGenerator());
        getServer().createWorld(worldCreator);

        getServer().getPluginManager().registerEvents(new BotRestrictionListener(), this);
        getServer().getPluginManager().registerEvents(new BotWorldTeleporterListener(this), this);
    }
}
