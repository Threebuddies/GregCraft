package com.gmail.gregrockss.GregCraft;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class GCBasic implements Listener{

	@EventHandler
	public void setHungerGame(PlayerMoveEvent e) {
		e.getPlayer().setFoodLevel(16);
	}
	
	@EventHandler
	public void playerHungerMaintain(FoodLevelChangeEvent e) {
		e.setFoodLevel(16);
	}
	
	@EventHandler
    public void blockBreak(BlockBreakEvent e) {
		if(e.getBlock().getType() == (Material.TNT)) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
    }
	
	@EventHandler
	public void blockPlacing(BlockPlaceEvent e) {
		e.setCancelled(true);
		if(e.getBlockPlaced().getType() == (Material.TNT)) {
			e.setCancelled(false);
		}
		if(e.getBlockPlaced().getType() == (Material.STONE_PLATE)) {
			e.setCancelled(false);
			e.getBlockPlaced().setType(Material.TRIPWIRE);
		}
		if(e.getBlockPlaced().getType() == (Material.WEB));
			e.setCancelled(false);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		p.setGameMode(GameMode.SPECTATOR);
	}	
}