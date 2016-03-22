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
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Server Selector");
		
		// Declare ItemStacks and ItemMeta
		ItemStack basic = new ItemStack (Material.BOW);
		ItemMeta basicMeta = basic.getItemMeta();
		
		ItemStack powerOne = new ItemStack (Material.BOW);
		ItemMeta powerOneMeta = powerOne.getItemMeta();
		
		ItemStack flame = new ItemStack (Material.DIAMOND_LEGGINGS);
		ItemMeta flameMeta = flame.getItemMeta();
		
		ItemStack powerTwo = new ItemStack (Material.DIAMOND_HELMET);
		ItemMeta powerTwoMeta = powerTwo.getItemMeta();
		
		// Set the display name and ItemData
		basicMeta.setDisplayName(ChatColor.DARK_RED + "Basic Bow");
		basic.setItemMeta(basicMeta);
		
		powerOneMeta.setDisplayName(ChatColor.GREEN + "Power I");
		powerOne.setItemMeta(powerOneMeta);
		
		flameMeta.setDisplayName(ChatColor.BLUE + "Flame");
		flame.setItemMeta(flameMeta);
		
		powerTwoMeta.setDisplayName(ChatColor.YELLOW + "Power II ");
		powerTwo.setItemMeta(powerTwoMeta);
		
		// Place items in the inventory
		inv.setItem(0, basic);
		inv.setItem(8, powerOne);
		inv.setItem(17, flame);
		inv.setItem(26, powerTwo);
		
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
		case BOW:
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
		Inventory joinInv = e.getPlayer().getInventory();
		joinInv.clear();
		joinInv.addItem(new ItemStack(Material.COMPASS));
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