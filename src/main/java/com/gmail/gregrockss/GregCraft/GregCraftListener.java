package com.gmail.gregrockss.GregCraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GregCraftListener implements Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    // Uses equalsIgnoreCase() over equals() to accept "ignite" and "IgNiTe."
	    if (cmd.getName().equalsIgnoreCase("GregCraft")) {
	        // Make sure that the player specified exactly one argument (the name of the player to ignite).
	        if (args.length != 1) {
	            // When onCommand() returns false, the help message associated with that command is displayed.
	            return false;
	        }

	        // Make sure the sender is a player.
	        if (!(sender instanceof Player)) {
	            sender.sendMessage("Only players can set other players on fire.");
	            sender.sendMessage("This is an arbitrary requirement for demonstration purposes only.");
	            return true;
	        }

	        // Get the player who should be set on fire. Remember that indecies start with 0, not 1.
			@SuppressWarnings("deprecation")
			Player target = Bukkit.getServer().getPlayer(args[0]);

	        // Make sure the player is online.
	        if (target == null) {
	            sender.sendMessage(args[0] + " is not currently online.");
	            return true;
	        }

	        // Sets the player on fire for 1,000 ticks (there are ~20 ticks in second, so 50 seconds total).
	        target.setFireTicks(1000);
	        return true;
	    }
	    return false;
	}
}
