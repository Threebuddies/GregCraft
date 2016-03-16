package com.gmail.gregrockss.GregCraft;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Healing implements Listener {
	
	@EventHandler
	public void paperHealing(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem().getType() == Material.PAPER) {
				Player p = e.getPlayer();
				if (p.getHealth() < 14 ) {
					final double pHealth = e.getPlayer().getHealth();
					// This is for debugging final double fHealth = (pHealth + 6);
					p.setHealth(pHealth + 6);
					p.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
					// This is also for debugging System.out.println(("pHealth: ") + (pHealth) + (" fHealth") + (fHealth));
				}else if (p.getHealth() > 14 && p.getHealth() < 20) {
					final double health = e.getPlayer().getHealth();
					final double pHealthF = 20 - e.getPlayer().getHealth();
					// What do you know, also for debugging System.out.println(("health: ") + (health) + (" pHealthF: ") + (pHealthF) );
					p.setHealth(health + pHealthF);
					p.getInventory().removeItem(new ItemStack(Material.PAPER, 1));
				}
			}
		}
	}
}