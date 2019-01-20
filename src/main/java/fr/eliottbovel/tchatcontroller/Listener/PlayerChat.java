package fr.eliottbovel.tchatcontroller.Listener;

import fr.eliottbovel.tchatcontroller.Tchatcontroller;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        /** Get Event Variable*/
        Player player = event.getPlayer();
        String message = event.getMessage();

        /** Check if the player controls another chat. */
        if (Tchatcontroller.PlayerConrolleur.containsKey(player.getDisplayName())) {
            /** Get Player Controlled */
            Player playerControlled = Bukkit.getPlayer(Tchatcontroller.PlayerConrolleur.get(player.getDisplayName()));
            /** Check if the player wants to stop controlling another chat. */
            if (message.equals("**STOP")) {
                /** Remove Players Name in Maps */
                Tchatcontroller.PlayerConrolleur.remove(player.getDisplayName());
                Tchatcontroller.PlayerConrolled.remove(playerControlled.getDisplayName());
                /** Send message for player */
                player.sendMessage(ChatColor.GREEN + "You have been dissociated from " + ChatColor.ITALIC + playerControlled.getDisplayName() + ".");
            } else {
                /** Send message in Player Controlled's tchat. */
                playerControlled.chat(message);
                /** Send message for player */
                player.sendMessage(ChatColor.GREEN + "Send!");
            }
            /** Cancel Event */
            event.setCancelled(true);
        }
    }
}
