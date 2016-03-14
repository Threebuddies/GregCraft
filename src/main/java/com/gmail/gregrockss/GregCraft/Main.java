package com.gmail.gregrockss.GregCraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable(){
		getLogger().info("onEnable has been invoked!");
	    // Register our command "kit" (set an instance of your command class as executor)
		Bukkit.getPluginManager().registerEvents(this, this);
	    this.getCommand("kit").setExecutor(new CommandKit());
	}
	
	@EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent evt) {
        evt.setCancelled(true);
    }
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				Player p = e.getPlayer();
				Snowball snowball = p.launchProjectile(Snowball.class);
				p.getInventory().remove(new ItemStack(Material.SNOW_BALL, 1));
				snowball.setVelocity(p.getLocation().getDirection().normalize().multiply(2));
				return;	
			} 
		}
	}
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		if (e.getEntity() instanceof Snowball && e.getEntity().getShooter() instanceof Player) {
			e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 2.0f, false);
			return;
		}
	}

	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
}