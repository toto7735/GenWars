package me.toto.main.commands;

import me.toto.main.GenWars;
import me.toto.main.data.GenWarsMessages;
import me.toto.main.data.Resources;
import me.toto.main.setup.Setup;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandExecutor {

    GenWars plugin;

    public Commands(GenWars plugin) {
        this.plugin = plugin;
        plugin.getCommand("genwars").setExecutor(this);
    }

    GenWarsMessages messages = new GenWarsMessages(GenWars.getInstance());

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§b§lGenWars §e0.1 §6by toto7735 §emade with §c❤");
            player.sendMessage("§b§lGenWars §fDo you need help? §e[ §f/genwars help §e]");
            return false;
        } else if (args[0].equalsIgnoreCase("help")) {
            if (!player.hasPermission("genwars.help")) {
                player.sendMessage(messages.noPermissionMessage().replace("%permission%", "genwars.help"));
                return false;
            }
            player.sendMessage(messages.helpMessage());
            return false;
        } else if (args[0].equalsIgnoreCase("setup")) {
            if (args.length == 1) {
                player.sendMessage(messages.helpMessage());
                return false;
            }
            if (args[1].equalsIgnoreCase("add")) {
                if (!player.hasPermission("genwars.setup.add")) {
                    player.sendMessage(messages.noPermissionMessage().replace("%permission%", "genwars.setup.add"));
                    return false;
                }
                if (args.length != 6) {
                    player.sendMessage(messages.helpMessage());
                    return false;
                }
                try {
                    String name = args[2];
                    if (Resources.getResourceExists(name)) {
                        player.sendMessage(messages.nameAlreadyExistsMessage().replace("%name%", name));
                        return false;
                    }
                    String material = args[3];
                    if (Material.getMaterial(material.toUpperCase()) == null) {
                        player.sendMessage(messages.materialNotExistsMessage().replace("%material%", material));
                        return false;
                    }
                    Location location = player.getLocation();
                    int second = Integer.parseInt(args[4]);
                    int amount = Integer.parseInt(args[5]);
                    Setup.add(name, material, location, second, amount);
                    player.sendMessage(messages.addedMessage().replace("%name%", name));
                } catch (Exception exception) {
                    player.sendMessage(messages.helpMessage());
                }
            } else if (args[1].equalsIgnoreCase("remove")) {
                if (!player.hasPermission("genwars.setup.remove")) {
                    player.sendMessage(messages.noPermissionMessage().replace("%permission%", "genwars.setup.remove"));
                    return false;
                }
                if (args.length != 3) {
                    player.sendMessage(messages.helpMessage());
                    return false;
                }
                try {
                    String name = args[2];
                    if (!Resources.getResourceExists(name)) {
                        player.sendMessage(messages.nameNotExistsMessage().replace("%name%", name));
                        return false;
                    }
                    Setup.remove(name);
                    player.sendMessage(messages.removedMessage().replace("%name%", name));
                } catch (Exception exception) {
                    player.sendMessage(messages.helpMessage());
                }
            } else {
                player.sendMessage(messages.helpMessage());
                return false;
            }
        } else if (args[0].equalsIgnoreCase("list")) {
            if (!player.hasPermission("genwars.list")) {
                player.sendMessage(messages.noPermissionMessage().replace("%permission%", "genwars.list"));
                return false;
            }
            if (plugin.getConfig().get("Resources") == null) {
                player.sendMessage(messages.listMessage().replace("%list%", "Nothing :("));
                return false;
            }
            List<String> gens = new ArrayList<>(plugin.getConfig().getConfigurationSection("Resources").getKeys(false));
            player.sendMessage(messages.listMessage().replace("%list%", gens.toString()));
        } else if (args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("genwars.reload")) {
                player.sendMessage(messages.noPermissionMessage().replace("%permission%", "genwars.reload"));
                return false;
            }
            plugin.reloadConfig();
            player.sendMessage(messages.reloadedMessage());
        } else {
            player.sendMessage(messages.helpMessage());
        }
        return false;
    }
}
