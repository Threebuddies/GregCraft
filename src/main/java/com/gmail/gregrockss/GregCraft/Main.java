package com.gmail.gregrockss.GregCraft;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable(){
		getLogger().info("onEnable has been invoked!");
	    // Register our command "kit" (set an instance of your command class as executor)
	    this.getCommand("kit").setExecutor(new CommandKit());
	}

	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
}