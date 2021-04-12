package me.toto.main.data;

import me.toto.main.GenWars;
import org.bukkit.ChatColor;

public class GenWarsMessages {
    
    GenWars plugin;
    public GenWarsMessages(GenWars plugin) {
        this.plugin = plugin;
    }

    public String noPermissionMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("No-Permission-Message"));
    }

    public String helpMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Help-Message"));
    }

    public String listMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("List-Message"));
    }


    public String addedMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Added-Message"));
    }

    public String removedMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Removed-Message"));
    }

    public String nameNotExistsMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Name-Not-Exists-Message"));
    }

    public String nameAlreadyExistsMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Name-Already-Exists-Message"));
    }

    public String materialNotExistsMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Material-Not-Exists-Message"));
    }

    public String reloadedMessage() {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Reloaded-Message"));
    }
}
