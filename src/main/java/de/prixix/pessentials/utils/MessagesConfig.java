package de.prixix.pessentials.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MessagesConfig {

    private static File file = new File("plugins/pEssentials", "messages.yml");
    private static FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    private static HashMap<String, String> cacheString = new HashMap<>();

    public void loadConfig() {
        configuration.options().copyDefaults(true);

        configuration.addDefault("Prefix", "&8[&epEssentials&] &7");


        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }

    public String getString(String string) {
        if (!cacheString.containsKey(string)) {
            cacheString.put(string, configuration.getString(string));
        }
        return cacheString.get(string)
                .replace("&", "§");
    }

}
