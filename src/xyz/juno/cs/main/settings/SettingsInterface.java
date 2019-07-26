package xyz.juno.cs.main.settings;

import xyz.juno.cs.main.ChatSound;

public interface SettingsInterface {
	String destroy(boolean prefix);
	
	public static enum Settings {
		NO_PERMISSION("messages.no-permission", true),
		HELP("messages.help", false),
		RELOAD_SUCCESS("messages.reload-success", true),
		RELOAD_ERROR("messages.reload-error", true);
		
		private String path;
		private boolean prefix;
		
		private Settings(String path, boolean prefix) {
			this.path = path;
			this.prefix = prefix;
		}
		
		public String getPath() {
			return path;
		}
		
		public boolean isPrefix() {
			return prefix;
		}
		
	}
	
	class SettingsUtils implements SettingsInterface {
		public String str;
		
		public SettingsUtils(String str) {
			this.str = str;
		}
		
		private static ChatSound ChatSound() {
			return ChatSound.chatSound();
		}
		
		@Override
		public String destroy(boolean prefix) {
			String var = "";
			String pf = ChatSound().getConfig().getString("Prefix");
			
			if (prefix) {
				var = ChatSound().Color(pf + ChatSound().getConfig().getString(str));
			} else {
				var = ChatSound().Color(ChatSound().getConfig().getString(str));
			}
			
			return var;
		}
		
	}

	class SettingAPI {
		private static SettingsUtils st;
		
		public static SettingsUtils getPath(String str) {
			st = new SettingsUtils(str);
			return st;
		}
	}
}