package com.gmail.gregrockss.GregCraft;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class Explosives implements Listener {
	
	@EventHandler
	public void snowballGrenades(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				Player p = e.getPlayer();
				Snowball snowball = p.launchProjectile(Snowball.class);
				p.getInventory().remove(new ItemStack(Material.SNOW_BALL, 1));
				snowball.setVelocity(p.getLocation().getDirection().normalize().multiply(1));
				return;	
			} 
		}
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		if (e.getEntity() instanceof Snowball && e.getEntity().getShooter() instanceof Player) {
			double x = e.getEntity().getLocation().getX();
			double y = e.getEntity().getLocation().getY();
			double z = e.getEntity().getLocation().getZ();
			e.getEntity().getWorld().createExplosion(x, y, z, 3, false, false);
			return;
		}
	}
	
	@EventHandler
	public void onClaymoreStep(PlayerMoveEvent e) {
        Material to = e.getTo().getBlock().getType();
        double x = e.getTo().getBlock().getLocation().getX();
        double y = e.getTo().getBlock().getLocation().getY();
        double z = e.getTo().getBlock().getLocation().getZ();
        if(to.equals(Material.TRIPWIRE)) {
            Block to2 = e.getTo().getBlock();
            e.getTo().getBlock().setType(Material.AIR);
            to2.getWorld().createExplosion(x, y, z, 2, false, false);
        }
    }
}