package fr.eliottbovel.tchatcontroller.Listener;

import fr.eliottbovel.tchatcontroller.Tchatcontroller;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Command:
 * /tchatcontroller [player's name] ( /tc [player's name] )
 *
 * Controle a player's tchat.
 */

public class PlayerCommand implements Listener {
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        /** Get Event Variable*/
        Player player = event.getPlayer();
        String message = event.getMessage();

        /** Check if the player controls another chat. */
        if (Tchatcontroller.PlayerConrolleur.containsKey(player.getDisplayName())) {
            /** Get Player Controlled */
            Player playerControlled = Bukkit.getPlayer(Tchatcontroller.PlayerConrolleur.get(player.getDisplayName()));

            /** Send message in Player Controlled's tchat. */
            playerControlled.chat(message);
            /** Send message for player */
            player.sendMessage(ChatColor.GREEN + "Send!");
            /** Cancel Event */
            event.setCancelled(true);
        }
    }
}
