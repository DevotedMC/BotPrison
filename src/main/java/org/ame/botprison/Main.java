package org.ame.botprison;

import org.ame.botprison.command.Reload;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        ConfigManager.loadConfig(getConfig(), getLogger(), this);

        getCommand("bpreload").setExecutor(new Reload(getConfig(), getLogger(), this));
    }
}
