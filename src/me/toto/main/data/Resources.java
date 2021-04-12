package me.toto.main.data;

import me.toto.main.GenWars;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Resources {

    static GenWars plugin;
    public Resources(GenWars plugin) {
        this.plugin = plugin;
    }

    public static List<String> getResources() {
        if (plugin.getConfig().get("Resources") != null) {
            List<String> resources = new ArrayList<>(plugin.getConfig().getConfigurationSection("Resources").getKeys(false));
            return resources;
        } else {
            return null;
        }
    }

    public static boolean getResourceExists(String name) {
        return plugin.getConfig().get("Resources." + name) != null;
    }
    public static Material getMaterial(String name) {
        return Material.getMaterial(plugin.getConfig().getString("Resources." + name + ".Material").toUpperCase());
    }

    public static Location getLocation(String name) {
        return plugin.getConfig().getLocation("Resources." + name + ".Location");
    }

    public static int getSecond(String name) {
        return plugin.getConfig().getInt("Resources." + name + ".Second-to-be-summoned");
    }

    public static int getAmount(String name) {
        return plugin.getConfig().getInt("Resources." + name + ".Amount");
    }

}
