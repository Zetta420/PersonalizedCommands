package fr.jak12210.personalizedcommands;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public void loadConfig() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		}
	public void onEnable(){
		
		System.out.println("PersonalizedCommands (jak12210) > INITIALIZED");
		getCommand("staff").setExecutor(new Commands(null));
	}
	public void onDisable(){
		System.out.println("PersonalizedCommands (jak12210) > DESACTIVATED");
	}
	
	
}
