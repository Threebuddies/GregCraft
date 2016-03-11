package com.gmail.gregrockss.GregCraft;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandKit implements CommandExecutor {

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
        Player player = (Player) sender;
        
        // Create a new ItemStack and sets the number of items 
        ItemStack diamond = new ItemStack(Material.DIAMOND, 3);
        // Create a new ItemStack
        ItemStack bricks = new ItemStack(Material.BRICK);
        
        // Set the amount of the ItemStack
        bricks.setAmount(20);
        
        // Give the player our items (comma-seperated list of all ItemStack)
        player.getInventory().addItem(bricks, diamond);
    }

    return true;
	}
}