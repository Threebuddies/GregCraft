package com.gmail.gregrockss.gregcraft;

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

import com.gmail.gregrockss.gregcraft.commands.BasicBow;
import com.gmail.gregrockss.gregcraft.commands.CommandKit;

public class Main extends JavaPlugin implements Listener {

    static Server theServer;
    static World currentWorld;
    public static Plugin plugin;
    public static final Listener HitSoundsHeadShots = new HitSoundsHeadShots();
    public static final Listener GCBasic = new GCBasic();
    public static final Listener Healing = new Healing();
    public static final Listener Explosives = new Explosives();
    public PluginManager pluginManager;
    public static int multiplier = 2;
    public static String message = " - Headshot - ";

	public void onEnable() {
		
		Team.clearTeams();
		
		getLogger().info("onEnable has been invoked!");
		Bukkit.getPluginManager().registerEvents(this, this);
	    this.getCommand("kit").setExecutor(new CommandKit());
	    this.getCommand("basicBow").setExecutor(new BasicBow());

	    this.pluginManager = getServer().getPluginManager();
	    this.pluginManager.registerEvents(HitSoundsHeadShots, this);
	    this.pluginManager.registerEvents(GCBasic, this);
	    this.pluginManager.registerEvents(Healing, this);
	    this.pluginManager.registerEvents(Explosives, this);
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
		getLogger().info("onDisable has been invoked!");
		Team.clearTeams();
	}
}