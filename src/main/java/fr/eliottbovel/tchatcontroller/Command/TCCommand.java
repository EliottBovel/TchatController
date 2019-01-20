package fr.eliottbovel.tchatcontroller.Command;

import fr.eliottbovel.tchatcontroller.Tchatcontroller;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TCCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /** Get Sender Type. */
        if (sender instanceof Player) {
            /** Check if there is at least one argument. */
            if(args.length >= 1){
                /** Check if the controlled player is online. */
                if (Bukkit.getServer().getPlayer(args[0]) != null){
                    /** Check if the player tries to control himself. */
                    if(!((Player) sender).getDisplayName().equals(Bukkit.getServer().getPlayer(args[0]).getDisplayName())) {
                        /** Check if the controlled player is already controlled. */
                        if (!Tchatcontroller.PlayerConrolled.containsKey(Bukkit.getServer().getPlayer(args[0]).getDisplayName())) {
                            /** Add Players Name in Maps */
                            Tchatcontroller.PlayerConrolleur.put(((Player) sender).getDisplayName(), Bukkit.getServer().getPlayer(args[0]).getDisplayName());
                            Tchatcontroller.PlayerConrolled.put(Bukkit.getServer().getPlayer(args[0]).getDisplayName(), ((Player) sender).getDisplayName());
                            /** Send messages for player */
                            sender.sendMessage(ChatColor.GREEN + "You control the " + Bukkit.getServer().getPlayer(args[0]).getDisplayName() + "'s tchat.");
                            sender.sendMessage(ChatColor.GREEN + "Type whatever you want in the chat and " + Bukkit.getServer().getPlayer(args[0]).getDisplayName() + " will say it or execute it.");
                            sender.sendMessage(ChatColor.GREEN + "Type **STOP to resume control of your chat.");
                        } else {
                            /** Send message for player */
                            sender.sendMessage(ChatColor.DARK_RED + Bukkit.getServer().getPlayer(args[0]).getDisplayName() + "'s chat is already controlled by " + Tchatcontroller.PlayerConrolled.get(Bukkit.getServer().getPlayer(args[0]).getDisplayName()));
                        }
                    }else{
                        /** Send message for player */
                        sender.sendMessage(ChatColor.DARK_RED + "This plugin does not allow you to control yourself, it would be stupid.");
                    }
                }else{
                    /** Send message for player */
                    sender.sendMessage(ChatColor.DARK_RED + "The player " + args[0] + " is offline.");
                }
            }else{
                /** Set Syntax Error */
                return false;
            }
        }else{
            /** Send message for player */
            sender.sendMessage(ChatColor.DARK_RED + "The console can not control a player's chat.");
        }
        return true;
    }

}
