package com.gmail.gregrockss.GregCraft.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BasicBow implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only a player can get an items!");
			return true;
		}
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack basicBow = new ItemStack(Material.BOW, 1);
			ItemStack arrow = new ItemStack(Material.ARROW, 1);
			basicBow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			player.getInventory().addItem(basicBow, arrow);
		}
		return true;
	}
	
}
