package com.gmail.gregrockss.GregCraft;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
}
