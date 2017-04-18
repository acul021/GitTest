package me.acul21.test;

import org.bukkit.entity.Player;

public class Permission {

	private Permission() { }
	
	public static boolean hasPermission(Player player,String perm){
		if(!player.hasPermission(perm))Message.sendMessage(player, "§cKeine Permission §7|§c "+perm);
		return player.hasPermission(perm);
	}

}
