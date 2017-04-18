package me.acul21.test;

import org.bukkit.command.CommandSender;

public class Message {

	public static final String PREFIX = "§7[§eTest§7]§r";

	private Message() { }

	public static void sendMessage(CommandSender/*Damit man auch an die Console schreiben kann*/ sender,String msg){
		sender.sendMessage(PREFIX+msg);
	}
}
