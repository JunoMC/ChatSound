package xyz.juno.cs.main.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import xyz.juno.cs.main.ChatSound;
import xyz.juno.cs.main.settings.SettingsInterface.Settings;

public class Cmds implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command c, String label, String[] a) {
		
		/*------------ARGUMENTS------------*/
		Arguments HELP = Arguments.HELP;
		Arguments RELOAD = Arguments.RELOAD;
		/*---------------------------------*/
		
		/*------------------------------------------------*/
		Settings NO_PERMISSION = Settings.NO_PERMISSION;
		Settings RELOAD_SUCCESS = Settings.RELOAD_SUCCESS;
		Settings RELOAD_ERROR = Settings.RELOAD_ERROR;
		Settings HELP_MSG = Settings.HELP;
		/*------------------------------------------------*/
		
		if (CmdsInterface.CmdsAPI.sender(sender).isLength(a, 0)) {
			if (CmdsInterface.CmdsAPI.sender(sender).isPlayer()) {
				if (CmdsInterface.CmdsAPI.sender(sender).isHas(HELP.getPermission())) {
					for (String msg : ChatSound.chatSound()
							.getConfig().getStringList(HELP_MSG.getPath())) {
						CmdsInterface.CmdsAPI.sender(sender).send(ChatSound.chatSound().Color(msg.replace("{lenh}", label)));
					}
				} else {
					CmdsInterface.CmdsAPI.sender(sender).sendPath(NO_PERMISSION.getPath());
				}
			} else {
				for (String msg : ChatSound.chatSound().getConfig().getStringList(HELP_MSG.getPath())) {
					CmdsInterface.CmdsAPI.sender(sender).send(ChatSound.chatSound().Color(msg.replace("{lenh}", label)));
				}
			}
		}
		
		if (CmdsInterface.CmdsAPI.sender(sender).isLength(a, 1)) {
			if (CmdsInterface.CmdsAPI.sender(sender).isArgumentSimilar(a[0], HELP.getArgument())) {
				if (CmdsInterface.CmdsAPI.sender(sender).isPlayer()) {
					if (CmdsInterface.CmdsAPI.sender(sender).isHas(HELP.getPermission())) {
						for (String msg : ChatSound.chatSound()
								.getConfig().getStringList(HELP_MSG.getPath())) {
							CmdsInterface.CmdsAPI.sender(sender).send(ChatSound.chatSound().Color(msg.replace("{lenh}", label)));
						}
					} else {
						CmdsInterface.CmdsAPI.sender(sender).sendPath(NO_PERMISSION.getPath());
					}
				} else {
					for (String msg : ChatSound.chatSound().getConfig().getStringList(HELP_MSG.getPath())) {
						CmdsInterface.CmdsAPI.sender(sender).send(ChatSound.chatSound().Color(msg.replace("{lenh}", label)));
					}
				}
			}
			
			if (CmdsInterface.CmdsAPI.sender(sender).isArgumentSimilar(a[0], RELOAD.getArgument())) {
				if (CmdsInterface.CmdsAPI.sender(sender).isPlayer()) {
					if (CmdsInterface.CmdsAPI.sender(sender).isHas(RELOAD.getPermission())) {
						try {
							ChatSound.chatSound().reloadConfig();
						} catch (Exception e) {
							CmdsInterface.CmdsAPI.sender(sender).sendPath(RELOAD_ERROR.getPath());
						} finally {
							CmdsInterface.CmdsAPI.sender(sender).sendPath(RELOAD_SUCCESS.getPath());
						}
					} else {
						CmdsInterface.CmdsAPI.sender(sender).sendPath(NO_PERMISSION.getPath());
					}
				} else {
					try {
						ChatSound.chatSound().reloadConfig();
					} catch (Exception e) {
						CmdsInterface.CmdsAPI.sender(sender).sendPath(RELOAD_ERROR.getPath());
					} finally {
						CmdsInterface.CmdsAPI.sender(sender).sendPath(RELOAD_SUCCESS.getPath());
					}
				}
			}
		}
		return false;
	}
}