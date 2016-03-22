package com.gmail.gregrockss.gregcraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponStore implements Listener {
	
	public void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Server Selector");
		ItemStack survival = new ItemStack (Material.DIAMOND_CHESTPLATE);
		ItemMeta survivalMeta = survival.getItemMeta();
		ItemStack creative = new ItemStack (Material.DIAMOND_BOOTS);
		ItemMeta creativeMeta = creative.getItemMeta();
		ItemStack spectator = new ItemStack (Material.DIAMOND_LEGGINGS);
		ItemMeta spectatorMeta = spectator.getItemMeta();
		ItemStack adventure = new ItemStack (Material.DIAMOND_HELMET);
		ItemMeta adventureMeta = adventure.getItemMeta();
		
		survivalMeta.setDisplayName(ChatColor.DARK_RED + "Survival");
		survival.setItemMeta(survivalMeta);
		
		creativeMeta.setDisplayName(ChatColor.GREEN + "Creative");
		creative.setItemMeta(creativeMeta);
		
		spectatorMeta.setDisplayName(ChatColor.BLUE + "Spectator");
		spectator.setItemMeta(spectatorMeta);
		
		adventureMeta.setDisplayName(ChatColor.YELLOW + "Adventure");
		adventure.setItemMeta(adventureMeta);
		
		inv.setItem(1, survival);
		inv.setItem(3, creative);
		inv.setItem(5, spectator);
		inv.setItem(7, adventure);
		
		player.openInventory(inv);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Server Selector"))
			return;
		Player player = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		
		switch (e.getCurrentItem().getType()) {
		case DIAMOND_CHESTPLATE:
			//this is where the player should get the items/take money away
			player.sendMessage(ChatColor.GREEN + "Survival Selected");
			break;
		case DIAMOND_BOOTS:
			//this is where the player should get the items/take money away
			player.sendMessage(ChatColor.GREEN + "Creative Selected");
			break; 
		case DIAMOND_LEGGINGS:
			//this is where the player should get the items/take money away
			player.sendMessage(ChatColor.GREEN + "Spectator Selected");
			break;
		case DIAMOND_HELMET:
			//this is where the player should get the items/take money away
			player.sendMessage(ChatColor.GREEN + "Adventure Selected");
			break;
		default:
			player.closeInventory();
			break;
		}
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Action a = e.getAction();
		ItemStack is = e.getItem();
		
		if(a == Action.PHYSICAL || is == null || is.getType() == Material.AIR)
			return;
		
		if(is.getType()==Material.COMPASS)
			openGUI(e.getPlayer());
			
	}
}
