package com.gmail.gregrockss.GregCraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    static Server theServer;
    static World currentWorld;
    public static Plugin plugin;
    public static final Listener HitSoundsHeadShots = new HitSoundsHeadShots();
    public static final Listener GCBasic = new GCBasic();
    public static final Listener Healing = new Healing();
    public static final Listener Explosives = new Explosives();
    //public static final Listener Team = new Team();
    public static final Listener WeaponStore= new WeaponStore();
    public PluginManager pluginManager;
    public static int multiplier = 2;
    public static String message = " - Headshot - ";

	public void onEnable() {
		
		Team.clearTeams();
		
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	for (World world : Main.this.getServer().getWorlds()) {
            		world.setTime(6000);
            	}	
            }
        }, 0L, 300L);

		Bukkit.getPluginManager().registerEvents(this, this);
	    //this.getCommand("kit").setExecutor(new com.gmail.gregrockss.gregcraft.commands.Team());

	    this.pluginManager = getServer().getPluginManager();
	    this.pluginManager.registerEvents(HitSoundsHeadShots, this);
	    this.pluginManager.registerEvents(GCBasic, this);
	    this.pluginManager.registerEvents(Healing, this);
	    this.pluginManager.registerEvents(Explosives, this);
	    //this.pluginManager.registerEvents(Team, this);
	    this.pluginManager.registerEvents(WeaponStore, this);
	    plugin = this;
	    multiplier = getConfig().getInt("multiplier");
	    message = getConfig().getString("message");
	    saveDefaultConfig();
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("assign")) {
			int i = 0;
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(i < Bukkit.getOnlinePlayers().size() / 2) {
					Team.addToTeam(TeamType.RED, player);
				} else {
					Team.addToTeam(TeamType.BLUE, player);
				}
				i++;
			}
		}
		if(label.equalsIgnoreCase("myteam"))
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "This command can only be run by a player.");
			} else {
				sender.sendMessage(Team.getTeamType(((Player)sender)).name());
			}
		return true;
	}
	
	public void onDisable() {
		Team.clearTeams();
	}
}