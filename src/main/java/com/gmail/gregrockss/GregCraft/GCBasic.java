package com.gmail.gregrockss.GregCraft;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class GCBasic implements Listener{

	@EventHandler
    public void playerHungerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setFoodLevel(16);
    }
	
	@EventHandler
	public void playerHungerMaintain(FoodLevelChangeEvent e) {
		e.setFoodLevel(16);
	}
	
	@EventHandler
    public void disableBlockBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		p.setGameMode(GameMode.SPECTATOR);
	}	
}