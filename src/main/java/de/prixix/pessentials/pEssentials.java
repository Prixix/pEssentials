package de.prixix.pessentials;

import de.prixix.pessentials.utils.MessagesConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class pEssentials extends JavaPlugin {

    private static pEssentials instance;
    private MessagesConfig messagesConfig;
    private ConsoleCommandSender console = Bukkit.getConsoleSender();
    private String consolePrefix = "pEssentials -> ";

    @Override
    public void onEnable() {
        instance = this;
        console.sendMessage(consolePrefix + "Loading...");

        //TODO: ADD VERSION CHECK

        messagesConfig = new MessagesConfig();

        messagesConfig.loadConfig();
    }

    @Override
    public void onDisable() {

    }

    public static pEssentials getInstance() { return instance; }

    public MessagesConfig getMessagesConfig() { return messagesConfig; }
}
