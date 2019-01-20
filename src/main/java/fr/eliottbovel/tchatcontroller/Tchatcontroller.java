package fr.eliottbovel.tchatcontroller;

import fr.eliottbovel.tchatcontroller.Command.TCCommand;
import fr.eliottbovel.tchatcontroller.Listener.PlayerChat;
import fr.eliottbovel.tchatcontroller.Listener.PlayerCommand;
import fr.eliottbovel.tchatcontroller.Listener.PlayerDisconnect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public final class Tchatcontroller extends JavaPlugin {

    public static Map<String, String> PlayerConrolleur = new HashMap<>();
    public static Map<String, String> PlayerConrolled = new HashMap<>();
    public String prefix = "" + ChatColor.GRAY + "[" + ChatColor.GOLD + "" + this.getName() + "" + ChatColor.GRAY + "] " + ChatColor.WHITE;

    @Override
    public void onEnable() {

        /** Write Load Message */
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                  _____ _      _    _      ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 |  __ (_)    | |  | |     ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 | |__) |  ___| | _| | ___ ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 |  ___/ |/ __| |/ / |/ _ \\");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 | |   | | (__|   <| |  __/");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 |_|   |_|\\___|_|\\_\\_|\\___|");
        Bukkit.getConsoleSender().sendMessage(this.prefix + "");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.GREEN + "Execution of the jar successfully, No fatal error found everything is fine");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.GREEN + "Execution time : " + ChatColor.BLUE + this.getLocalDate());
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "------------------------------------------------------------------");

        /** Load Listeners */
        getServer().getPluginManager().registerEvents(new PlayerChat(), this);
        getServer().getPluginManager().registerEvents(new PlayerCommand(), this);
        getServer().getPluginManager().registerEvents(new PlayerDisconnect(), this);


        /** Load Commands */
        this.getCommand("tchatcontroller").setExecutor(new TCCommand());

    }

    @Override
    public void onDisable() {

        /** Write Stop Message */
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                  _____ _      _    _       ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 |  __ (_)    | |  | |      ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 | |__) |  ___| | _| | ___  ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 |  ___/ |/ __| |/ / |/ _ \\ ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 | |   | | (__|   <| |  __/ ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "                 |_|   |_|\\___|_|\\_\\_|\\___| ");
        Bukkit.getConsoleSender().sendMessage(this.prefix + "");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_AQUA + "Shutdown of the jar successfully, No fatal error found everything is fine");
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_AQUA + "Execution time : " + ChatColor.BLUE + this.getLocalDate());
        Bukkit.getConsoleSender().sendMessage(this.prefix + ChatColor.DARK_RED + "------------------------------------------------------------------");
    }

    /**
     * @return Date format D/M/Y H:m:s
     * Tanks to Dylan Malandain.
     */
    private String getLocalDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().toString();
    }
}
