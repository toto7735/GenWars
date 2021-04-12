package me.toto.main;

import me.toto.main.commands.Commands;
import me.toto.main.data.GenWarsMessages;
import me.toto.main.data.Resources;
import me.toto.main.setup.Setup;
import me.toto.main.utils.SpawnResources;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class GenWars extends JavaPlugin {

    public static GenWars instance;
    public static GenWars getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        this.saveResource("config.yml", false);
        Bukkit.getLogger().info("§c§l-----------------------");
        Bukkit.getLogger().info("§b§lGenWars §e0.1 §6by toto7735");
        Bukkit.getLogger().info("§eBeen §aEnabled!");
        Bukkit.getLogger().info("§c§l-----------------------");
        new GenWarsMessages(this);
        new Setup(this);
        new Resources(this);
        new Commands(this);
        new SpawnResources(this);
    }

    public void onDisable() {
        Bukkit.getLogger().info("§c§l-----------------------");
        Bukkit.getLogger().info("§b§lGenWars §e0.1 §6by toto7735");
        Bukkit.getLogger().info("§eBeen §cDisabled!");
        Bukkit.getLogger().info("§c§l-----------------------");
    }

}
