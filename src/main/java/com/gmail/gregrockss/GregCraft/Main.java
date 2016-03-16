package com.gmail.gregrockss.GregCraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
    static Server theServer;
    static World currentWorld;
    public static Plugin plugin;
    public static final Listener HitSoundsHeadShots = new HitSoundsHeadShots();
    public static final Listener GCBasic = new GCBasic();
    public static final Listener Healing = new Healing();
    public PluginManager pluginManager;
    public static int multiplier = 2;
    public static String message = " - Headshot - ";
	    
	public void onEnable(){
		getLogger().info("onEnable has been invoked!");
		Bukkit.getPluginManager().registerEvents(this, this);
	    this.getCommand("kit").setExecutor(new CommandKit());
	    this.pluginManager = getServer().getPluginManager();
	    this.pluginManager.registerEvents(HitSoundsHeadShots, this);
	    this.pluginManager.registerEvents(GCBasic, this);
	    this.pluginManager.registerEvents(Healing, this);
	    plugin = this;
	    multiplier = getConfig().getInt("multiplier");
	    message = getConfig().getString("message");
	    saveDefaultConfig();
	}
	
	public static void hitSounds(Player player) {
	    if (player != null) {
	        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 0.5F);
	    }
	}

	@EventHandler
	public void snowballGrenades(PlayerInteractEvent e) {
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
			e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 3.0f, false);
			return;
		}
	}
	
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
}