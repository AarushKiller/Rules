package me.vrom.serverrules;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class ServerRules extends JavaPlugin implements CommandExecutor{
    private static String prefix = "§8§l[§4§lRULES§8l]§r";

    private String Rules1 = getConfig().getString("Rules.Rules1");

    private String Rules2 = getConfig().getString("Rules.Rules2");

    private String Rules3 = getConfig().getString("Rules.Rules3");

    private String Rules4 = getConfig().getString("Rules.Rules4");

    private String Rules5 = getConfig().getString("Rules.Rules5");

    private String Rules6 = getConfig().getString("Rules.Rules6");

    private String Rules7 = getConfig().getString("Rules.Rules7");

    private String Rules8 = getConfig().getString("Rules.Rules8");

    private String Rules9 = getConfig().getString("Rules.Rules9");

    private String Rules10 = getConfig().getString("Rules.Rules10");

    private String Reload = getConfig().getString("Rules.Reload");

    private String noPerms = getConfig().getString("Rules.noPerms");

    public void onDisable() {
        saveConfig();
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "---------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(prefix) + "Plugin §4disabled");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(prefix) + "Plugin by Vrom");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(prefix) + "Plugin version " + getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "---------------------------------------------------------------");
    }

    public void onEnable() {
        reloadConfig();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "---------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(prefix) + "Plugin §aenabled");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(prefix) + "Plugin by Vrom");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(prefix) + "Plugin version " + getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "---------------------------------------------------------------");
        getCommand("rules").setExecutor(this);
    }

    public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (cmd.getName().equalsIgnoreCase("rules")) {
                sender.sendMessage("§4§m-----------------------------------------------");
                sender.sendMessage("                          §4§lRules");
                sender.sendMessage("");
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules1));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules2));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules3));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules4));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules5));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules6));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules7));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules8));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules9));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Rules10));
                sender.sendMessage("§4§m-----------------------------------------------");
            }
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("developer")) {
                sender.sendMessage("§4§m-----------------------------------------------");
                sender.sendMessage("                          §4§lRules");
                sender.sendMessage("");
                sender.sendMessage(String.valueOf(prefix) + "Plugin by Vrom");
                sender.sendMessage(String.valueOf(prefix) + "Plugin version " + getDescription().getVersion());
                sender.sendMessage((new StringBuilder(String.valueOf(prefix))).toString());
                sender.sendMessage(String.valueOf(prefix) + "§bDownload:");
                sender.sendMessage("§4§m-----------------------------------------------");

            } else if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("Rules.reload")) {
                    sender.sendMessage(String.valueOf(prefix) + ChatColor.translateAlternateColorCodes('&', this.Reload));
                    reloadConfig();
                } else {
                    sender.sendMessage(String.valueOf(prefix) + ChatColor.translateAlternateColorCodes('&', this.noPerms));
                }
            }
        }
        return true;
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}