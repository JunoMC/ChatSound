package xyz.juno.cs.main.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import xyz.juno.cs.main.ChatSound;

public class AsyncPlayerChat implements Listener {

	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (ChatSound.chatSound().getConfig().getConfigurationSection("Sounds") != null) {
			for (String key : ChatSound.chatSound().getConfig().getConfigurationSection("Sounds").getKeys(false)) {
				if (p.hasPermission(ChatSound.chatSound().getConfig().getString("Sounds." + key + ".Permission"))) {
					p.getLocation().getWorld().playSound(p.getLocation(),
							Sound.valueOf(ChatSound.chatSound().getConfig().getString("Sounds." + key + ".Sound")),
							(float) ChatSound.chatSound().getConfig().getDouble("Sounds." + key + ".Volumn"),
							(float) ChatSound.chatSound().getConfig().getDouble("Sounds." + key + ".Pitch"));
				}
			}
		}
	}
}