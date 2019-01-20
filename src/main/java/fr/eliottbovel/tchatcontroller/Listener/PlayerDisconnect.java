package fr.eliottbovel.tchatcontroller.Listener;

import fr.eliottbovel.tchatcontroller.Tchatcontroller;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconnect implements Listener {
    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        /** Check if the player is checking someone. */
        if(Tchatcontroller.PlayerConrolleur.containsKey(player.getDisplayName())){
            /** Remove Players Name in Maps */
            Tchatcontroller.PlayerConrolled.remove(Tchatcontroller.PlayerConrolleur.get(player.getDisplayName()));
            Tchatcontroller.PlayerConrolleur.remove(player.getDisplayName());
         /** Check if the player is controlled by someone. */
        }else if(Tchatcontroller.PlayerConrolled.containsKey(player.getDisplayName())){
            /** Send message to Controlleur Player */
            Bukkit.getPlayer(Tchatcontroller.PlayerConrolled.get(player.getDisplayName())).sendMessage(ChatColor.DARK_RED + player.getDisplayName() + " has disconnected.");
            Bukkit.getPlayer(Tchatcontroller.PlayerConrolled.get(player.getDisplayName())).sendMessage(ChatColor.DARK_RED + "You have been dissociated from " + ChatColor.ITALIC + player.getDisplayName() + ".");
            /** Remove Players Name in Maps */
            Tchatcontroller.PlayerConrolleur.remove(Tchatcontroller.PlayerConrolled.get(player.getDisplayName()));
            Tchatcontroller.PlayerConrolled.remove(player.getDisplayName());
        }
    }
}
