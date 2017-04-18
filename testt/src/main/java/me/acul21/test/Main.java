package me.acul21.test;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("jump").setExecutor(this);
		Message.sendMessage(Bukkit.getConsoleSender(), "§aPlugin aktiviert!");
	}
	
	@Override
	public void onDisable() {
		Message.sendMessage(Bukkit.getConsoleSender(), "§cPlugin deaktiviert!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
			Message.sendMessage(sender, "§4Only for Players!");
			return true;
		}
		Player p=(Player) sender;
		if(Permission.hasPermission(p, "test.jump")){
			Message.sendMessage(p, "§cActung!");
			Message.sendMessage(p, "§aDu machst jetzt einen §6SuperJump§a!");
			
			p.setVelocity(p.getLocation().getDirection().multiply(5D));
		}
		return true;
	}
	
}
