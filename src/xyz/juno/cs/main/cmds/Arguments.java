package xyz.juno.cs.main.cmds;

public enum Arguments {
	HELP("(help|\\?)", "cs.help"),
	RELOAD("(reload|rl)", "cs.reload");
	
	private String regex;
	private String permission;
	
	private Arguments(String regex, String permission) {
		this.regex = regex;
		this.permission = permission;
	}
	
	public String getArgument() {
		return regex;
	}
	
	public String getPermission() {
		return permission;
	}
}