package org.ame.botprison;

import org.ame.botprison.command.Add;
import org.ame.botprison.command.Reload;
import org.ame.botprison.command.Remove;
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
    }
}
