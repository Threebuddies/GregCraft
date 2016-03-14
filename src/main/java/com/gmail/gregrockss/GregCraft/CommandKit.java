package com.gmail.gregrockss.GregCraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandKit implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    
		if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can get kits!");
            return true;
		}
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
            // (Material.DIAMOND, 3); The "3" does the same as diamond.setAmount(3);
			ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
			ItemStack bricks = new ItemStack(Material.BRICK);
        
    	    bricks.setAmount(20);
        
    	    player.getInventory().addItem(bricks, diamond);
		}
		return true;
	}
	

}