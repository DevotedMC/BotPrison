package org.ame.botprison.command;


import org.ame.botprison.ConfigManager;
import org.ame.botprison.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;

import java.util.logging.Logger;

public class Reload implements CommandExecutor {
    public Reload(Configuration config, Logger logger, Main main) {
        this.config = config;
        this.logger = logger;
        this.main = main;
    }

    private Configuration config;
    private Logger logger;
    private Main main;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ConfigManager.loadConfig(config, logger, main);
        commandSender.sendMessage("Reloaded BotPrison config.");
        return true;
    }
}
