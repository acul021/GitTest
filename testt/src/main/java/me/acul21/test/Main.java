package me.acul21.test;

import java.util.ArrayList;
import java.util.logging.LoggingMXBean;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	private ArrayList<Player> players=new ArrayList<Player>();
	@Override
	public void onEnable() {
		this.getCommand("jump").setExecutor(this);
		Bukkit.getPluginManager().registerEvents(this, this);
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
			
			p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1D));
			
			//Wenn der Spieler den CMD ausführt wird er in die Liste hinzugefügt damit er kein Fallschaden
			players.add(p);
		}
		return true;
	}
	
	//Wenn der Spieler in der Liste ist bekommt er kein Fallschaden
	@EventHandler
	public void fallDamage(EntityDamageEvent e){
		if(e.getCause()==DamageCause.FALL&&e.getEntity() instanceof Player&&players.contains(e.getEntity())){
			e.setCancelled(true);
			players.remove(e.getEntity());
		}
	}
	
}
