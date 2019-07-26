package xyz.juno.cs.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.juno.cs.main.cmds.Cmds;
import xyz.juno.cs.main.listener.AsyncPlayerChat;

public class ChatSound extends JavaPlugin implements Listener {
	private static ChatSound chatSound;
	
	@Override
	public void onEnable() {
		chatSound = this;
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new AsyncPlayerChat(), this);
		getCommand("cs").setExecutor(new Cmds());
	}
	
	@Override
	public void onDisable() {}
	
	public static ChatSound chatSound() {
		return chatSound;
	}
	
	public String Color(String textToTranslate) {
		return ChatColor.translateAlternateColorCodes('&', textToTranslate);
	}
}