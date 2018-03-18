package com.gmail.gregrockss.GregCraft;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Healing implements Listener {
	
	@EventHandler
	public void onBandageUseEvent(PlayerInteractEvent e) {
		if (e.getPlayer().getInventory().getItemInMainHand().getType() == (Material.PAPER)) {
			Player p = e.getPlayer();
			if (p.getHealth() != 20) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 3));
				p.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
			}
		}
	}

	@EventHandler
	public void onBandageUseOtherEvent(PlayerInteractEntityEvent e) {
		if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.YELLOW_FLOWER) {
			Player p = e.getPlayer();
			Entity entity = e.getRightClicked();
			Player t = (Player)entity;
			if (t.getHealth() != 20) {
				t.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 3));
				p.getInventory().removeItem(new ItemStack(Material.YELLOW_FLOWER, 1));
			}
		}
	}
}