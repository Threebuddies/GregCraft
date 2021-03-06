package com.gmail.gregrockss.GregCraft;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

// This code is most likely from murderscene
public class HitSoundsHeadShots implements Listener {
	
	public static void hitSounds(Player player) {
	    if (player != null) {
	        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 0.5F);
	    }
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
	    Player damager = null;
	    Arrow arrow = null;
	    Boolean isArrow = Boolean.valueOf(false);
	    
	    if ((event.getDamager() instanceof Arrow)) {
	        arrow = (Arrow)event.getDamager();
	        damager = (Player)arrow.getShooter();
	        isArrow = Boolean.valueOf(true);
	    }
	    
	    else if ((event.getDamager() instanceof Player)) {
	        damager = (Player)event.getDamager();
	    }
	    
	    if ((isArrow.booleanValue()) && (arrow != null)) {
	        if (damager != null) {
	             HitSoundsHeadShots.hitSounds(damager);
	        }
	        Location arrowLocation = arrow.getLocation();
	        if (arrowLocation.getY() > event.getEntity().getLocation().getY() + 1.62D) {
	              event.setDamage(event.getDamage() * Main.multiplier);
	              damager.sendMessage(ChatColor.YELLOW + Main.message);
	        }
	    }
	}
}