package com.gmail.gregrockss.GregCraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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
		Inventory inv = Bukkit.createInventory(null, 54, "Store");
		
		// This code block is for all they types of bows
		//ItemStack bow = new ItemStack (Material.BOW);
		ItemStack basic = new ItemStack (Material.BOW);
		ItemMeta basicMeta = basic.getItemMeta();
		ItemStack powerOne = new ItemStack (Material.BOW);
		ItemMeta powerOneMeta = powerOne.getItemMeta();
		ItemStack flame = new ItemStack (Material.BOW);
		ItemMeta flameMeta = flame.getItemMeta();
		ItemStack powerTwo = new ItemStack (Material.BOW);
		ItemMeta powerTwoMeta = powerTwo.getItemMeta();
		basicMeta.setDisplayName("Basic Bow Kit");
		basic.setItemMeta(basicMeta);
		powerOneMeta.setDisplayName("Power I Bow Kit");
		powerOne.setItemMeta(powerOneMeta);
		flameMeta.setDisplayName("Flame Bow Kit");
		flame.setItemMeta(flameMeta);
		powerTwoMeta.setDisplayName("Power II Bow Kit");
		powerTwo.setItemMeta(powerTwoMeta);
		
		// This code block is for thrown explosives
		//ItemStack tnt = new ItemStack (Material.TNT);
		ItemStack grenade = new ItemStack (Material.ENDER_PEARL);
		ItemMeta grenadeMeta = grenade.getItemMeta();
		ItemStack flashbang = new ItemStack (Material.SNOW_BALL);
		ItemMeta flashbangMeta = flashbang.getItemMeta();
		grenadeMeta.setDisplayName("Grenade");
		grenade.setItemMeta(grenadeMeta);
		flashbangMeta.setDisplayName("Flashbang");
		flashbang.setItemMeta(flashbangMeta);
		
		// This code block is for traps
		//ItemStack webDisplay = new ItemStack (Material.WEB);
		ItemStack web = new ItemStack (Material.WEB);
		ItemMeta webMeta = web.getItemMeta();
		ItemStack tripwire = new ItemStack (Material.STONE_PLATE);
		ItemMeta tripwireMeta = tripwire.getItemMeta();
		webMeta.setDisplayName("Spider Web");
		web.setItemMeta(webMeta);
		tripwireMeta.setDisplayName("Land Mine");
		tripwire.setItemMeta(tripwireMeta);
		
		// This code block is for healing
		//ItemStack health = new ItemStack (Material.PAPER);
		ItemStack bandage = new ItemStack (Material.PAPER);
		ItemMeta bandageMeta = bandage.getItemMeta();
		ItemStack healthKit = new ItemStack (Material.YELLOW_FLOWER);
		ItemMeta healthKitMeta = healthKit.getItemMeta();
		bandageMeta.setDisplayName("Bandage");
		bandage.setItemMeta(bandageMeta);
		healthKitMeta.setDisplayName("Health Kit");
		healthKit.setItemMeta(healthKitMeta);
		
		// This code block is for armor
		//ItemStack diamondChest = new ItemStack (Material.DIAMOND_CHESTPLATE);
		ItemStack helmet = new ItemStack (Material.LEATHER_HELMET);
		ItemMeta helmetMeta = helmet.getItemMeta();
		ItemStack blastArmor = new ItemStack (Material.IRON_CHESTPLATE);
		ItemMeta blastArmorMeta = blastArmor.getItemMeta();
		ItemStack chainArmor = new ItemStack (Material.CHAINMAIL_CHESTPLATE);
		ItemMeta chainArmorMeta = chainArmor.getItemMeta();
		helmetMeta.setDisplayName("Helmet");
		helmet.setItemMeta(helmetMeta);
		blastArmorMeta.setDisplayName("Blast Protection Armor");
		blastArmor.setItemMeta(blastArmorMeta);
		chainArmorMeta.setDisplayName("Chainmail Chestplate");
		chainArmor.setItemMeta(chainArmorMeta);
		
		// Creates the interface in an inventory, then creates it
		//inv.setItem(0, bow);
		inv.setItem(0, basic);
		inv.setItem(9, powerOne);
		inv.setItem(18, flame);
		inv.setItem(27, powerTwo);
		//inv.setItem(2, tnt);
		inv.setItem(2, grenade);
		inv.setItem(11, flashbang);
		//inv.setItem(4, webDisplay);
		inv.setItem(4, web);
		inv.setItem(13, tripwire);
		//inv.setItem(6, health);
		inv.setItem(6, bandage);
		inv.setItem(15, healthKit);
		//inv.setItem(8, diamondChest);
		inv.setItem(8, helmet);
		inv.setItem(17, blastArmor);
		inv.setItem(26, chainArmor);
		
		player.openInventory(inv);
	}
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Store"))
			return;
		
		Player player = (Player) e.getWhoClicked();
		
		e.setCancelled(true);
		
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
			return;
		}
		
		Player p = (Player) e.getWhoClicked();
		ItemStack arrow = new ItemStack(Material.ARROW, 1);
		String display = e.getCurrentItem().getItemMeta().getDisplayName();
		
		// When a player clicks on an object, add the items to the players inventory
		if(display == "Basic Bow Kit") {
			ItemStack basic = new ItemStack (Material.BOW);
			basic.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			p.getInventory().addItem(basic, arrow);
			player.sendMessage(ChatColor.GREEN + "Basic bow added to your inventory!");
			return;
		}
		if(display == "Power I Bow Kit") {
			ItemStack powerOne = new ItemStack (Material.BOW);
			powerOne.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			powerOne.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
			p.getInventory().addItem(powerOne, arrow);
			player.sendMessage(ChatColor.GREEN + "Power I bow added to your inventory!");
			return;
		}
		if(display == "Flame Bow Kit") {
			ItemStack flame = new ItemStack (Material.BOW);
			flame.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			flame.addEnchantment(Enchantment.ARROW_FIRE, 1);
			p.getInventory().addItem(flame, arrow);
			p.sendMessage(ChatColor.GREEN + "Flame bow added to your inventory!");
			return;
		}
		if(display == "Power II Bow Kit") {
			ItemStack powerTwo = new ItemStack (Material.BOW);
			powerTwo.addEnchantment(Enchantment.ARROW_INFINITE, 1);
			powerTwo.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
			p.getInventory().addItem(powerTwo, arrow);
			p.sendMessage(ChatColor.GREEN + "Power II bow added to your inventory!");
			return;
		}
		if(display == "Grenade") {
			ItemStack grenade = new ItemStack (Material.ENDER_PEARL);
			p.getInventory().addItem(grenade);
			p.sendMessage(ChatColor.GREEN + "Grenade added to your inventory!");
			return;
		}
		if(display == "Flashbang") {
			ItemStack flashbang = new ItemStack (Material.SNOW_BALL);
			p.getInventory().addItem(flashbang);
			p.sendMessage(ChatColor.GREEN + "Flashbang added to your inventory!");
			return;
		}
		if(display == "Spider Web") {
			ItemStack playerWeb = new ItemStack (Material.WEB);
			p.getInventory().addItem(playerWeb);
			p.sendMessage(ChatColor.GREEN + "Spider Web added to your inventory!");
			return;
		}
		if(display == "Land Mine") {
			ItemStack string = new ItemStack (Material.STONE_PLATE);
			p.getInventory().addItem(string);
			p.sendMessage(ChatColor.GREEN + "Land Mine added to your inventory!");
			return;
		}
		if(display == "Bandage") {
			ItemStack paper = new ItemStack (Material.PAPER);
			p.getInventory().addItem(paper);
			p.sendMessage(ChatColor.GREEN + "Bandage added to your inventory!");
			return;
		}
		if(display == "Health Kit") {
			ItemStack flower = new ItemStack (Material.YELLOW_FLOWER);
			p.getInventory().addItem(flower);
			p.sendMessage(ChatColor.GREEN + "Health Kit added to your inventory!");
			return;
		}
		if(display == "Helmet") {
			ItemStack leatherHelmet = new ItemStack (Material.LEATHER_HELMET);
			p.getInventory().setHelmet(leatherHelmet);
			p.sendMessage(ChatColor.GREEN + "Helmet has been put on your head!");
			return;
		}
		if(display == "Blast Protection Armor") {
			ItemStack blastProtection = new ItemStack (Material.LEATHER_CHESTPLATE);
			blastProtection.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
			p.getInventory().setChestplate(blastProtection);
			p.sendMessage(ChatColor.GREEN + "Blast Protection Armor has been placed on your chest!");
			return;
		}
		if(display == "Chainmail Chestplate") {
			ItemStack chainChest = new ItemStack (Material.CHAINMAIL_CHESTPLATE);
			p.getInventory().setChestplate(chainChest);
			p.sendMessage(ChatColor.GREEN + "Chainmail Chestplate Armor has been placed on your chest!");
			return;
		}
	}
	
	// When a player joins the server, add the navigation menu item to the task bar
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Inventory joinInv = e.getPlayer().getInventory();
		joinInv.clear();
		joinInv.addItem(new ItemStack(Material.COMPASS));
		// Wooden sword is for combat use
		joinInv.addItem(new ItemStack(Material.WOOD_SWORD));
	}
	
	// Opens the store when a player clicks while holding a compass
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