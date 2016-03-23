package com.gmail.gregrockss.gregcraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Team implements Listener {

	private static List<String> redTeam = new ArrayList<String>();
	private static List<String> blueTeam = new ArrayList<String>();
	
	public static void addToTeam(TeamType type, Player player) {
		if(isInTeam(player)) {
			player.sendMessage("You are already in a team!");
			return;
		}
		switch (type) {
		case RED:
			redTeam.add(player.getName());
			break;
		case BLUE:
			blueTeam.add(player.getName());
			break;
		}
		player.sendMessage("Added to " + type.name() + " team!");
	}
	
	public static boolean isInTeam(Player player) {
		return redTeam.contains(player.getName()) || blueTeam.contains(player.getName());
	}
	
	public static void clearTeams() {
		redTeam.clear();
		blueTeam.clear();
	}
	
	public static List<String> getRedTeam() {
		return redTeam;
	}
	
	public static List<String> getBlueTeam() {
		return blueTeam;
	}
	
	public static List<String> getAllPlayersInTeams() {
		List<String> combinedTeams = new ArrayList<String>();
		combinedTeams.addAll(redTeam);
		combinedTeams.addAll(blueTeam);
		return combinedTeams;
	}
	
	@EventHandler
	public void onEntityDamageByentity(EntityDamageByEntityEvent e) {

		Player player = (Player) e.getEntity();
		Player damager = (Player) e.getDamager();
		
		if(Team.getTeamType(player) == Team.getTeamType(damager))
			e.setCancelled(true);
	}
	
	public static TeamType getTeamType(Player player) {
		if(!isInTeam(player))
			return null;
		return (redTeam.contains(player.getName()) ? TeamType.RED : TeamType.BLUE);
	}
}