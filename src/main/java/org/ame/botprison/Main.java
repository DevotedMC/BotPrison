package org.ame.botprison;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        ConfigManager.loadConfig(getConfig(), getLogger(), this);
    }
}
