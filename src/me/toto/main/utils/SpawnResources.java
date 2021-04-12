package me.toto.main.utils;

import me.toto.main.GenWars;
import me.toto.main.data.Resources;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnResources {

    GenWars plugin;

    public SpawnResources(GenWars plugin) {
        this.plugin = plugin;
        spawnResources();
    }

    public static void spawnResources() {
        if (Resources.getResources() == null) return;
        for (String name : Resources.getResources()) {
            try {
                new BukkitRunnable() {
                    public void run() {
                        Resources.getLocation(name).getWorld().dropItem(Resources.getLocation(name), new ItemStack(Resources.getMaterial(name), Resources.getAmount(name)));
                    }
                }.runTaskTimer(GenWars.getInstance(), 0, Resources.getSecond(name) * 20);
            } catch (Exception exception) {
                Bukkit.broadcastMessage(exception.toString());
            }
        }
    }
    
}
