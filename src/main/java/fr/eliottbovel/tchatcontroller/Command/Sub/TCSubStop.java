package fr.eliottbovel.tchatcontroller.Command.Sub;

import fr.eliottbovel.tchatcontroller.Tchatcontroller;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TCSubStop {
    public TCSubStop(Player player) {
        if(Tchatcontroller.PlayerConrolleur.containsKey(player.getDisplayName())){
            String PlayerControlled = Tchatcontroller.PlayerConrolleur.get(player.getDisplayName());
            Tchatcontroller.PlayerConrolleur.remove(player.getDisplayName());
            Tchatcontroller.PlayerConrolled.remove(PlayerControlled);
            player.sendMessage(ChatColor.GRAY + "You have been dissociated from " + ChatColor.ITALIC + PlayerControlled + ".");
        }
    }
}
