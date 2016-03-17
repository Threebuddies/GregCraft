package com.gmail.gregrockss.GregCraft;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Healing implements Listener {
	
	@EventHandler
	public void paperHealing(PlayerInteractEvent e) {
		if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.PAPER) {
			Player p = e.getPlayer();
			if (p.getHealth() < 14 ) {
				final double pHealth = e.getPlayer().getHealth();
				p.setHealth(pHealth + 6);
				p.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
			}else if (p.getHealth() >= 14 && p.getHealth() < 20) {
				final double health = e.getPlayer().getHealth();
				final double pHealthF = 20 - e.getPlayer().getHealth();
				p.setHealth(health + pHealthF);
				p.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
			}
		}
	}	
	
    @EventHandler
	public void roseHealing(PlayerInteractEntityEvent e) {
		Player playerHealed = (Player) e.getRightClicked();
		if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK) {
			if(playerHealed instanceof Player){
				if (playerHealed.getHealth() < 14 ) {
					final double pHealth = playerHealed.getHealth();
					playerHealed.setHealth(pHealth + 6);
					e.getPlayer().getInventory().removeItem(new ItemStack(Material.STICK, 1));
				} else if (playerHealed.getHealth() >= 14 && playerHealed.getHealth() < 20) {
					final double health = playerHealed.getHealth();
					final double pHealthF = 20 - playerHealed.getHealth();
					playerHealed.setHealth(health + pHealthF);
					e.getPlayer().getInventory().removeItem(new ItemStack(Material.STICK, 1));	
				}
			}
		}
	}
}