package com.gmail.gregrockss.GregCraft;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable(){
		getLogger().info("onEnable has been invoked!");
	}

	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
}