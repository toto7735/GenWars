package me.toto.main.setup;

import me.toto.main.GenWars;
import org.bukkit.Location;

public class Setup {

    static GenWars plugin;

    public Setup(GenWars plugin) {
        this.plugin = plugin;
    }

    public static void add(String name, String material, Location location, int second, int amount) {
        plugin.getConfig().set("Resources." + name + ".Material", material);
        plugin.getConfig().set("Resources." + name + ".Location", location);
        plugin.getConfig().set("Resources." + name + ".Second-to-be-summoned", second);
        plugin.getConfig().set("Resources." + name + ".Amount", amount);
        plugin.saveConfig();
    }

    public static void remove(String name) {
        plugin.getConfig().set("Resources." + name, null);
        plugin.saveConfig();
    }

}
