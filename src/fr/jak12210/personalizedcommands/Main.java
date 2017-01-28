package fr.jak12210.personalizedcommands;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public void loadConfig() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		}
	public void onEnable(){
		
		System.out.println("PersonalizedCommands (jak12210) > INITIALIZED");
		Bukkit.getPluginManager().RegisterEnents(PlayerCommandPreprocessEventListener(),this);
		getCommand("staff").setExecutor(new Commands(this));
		getCommand("english").setExecutor(new Commands(this));
		getCommand("francais").setExecutor(new Commands(this));
		getCommand("help").setExecutor(new Commands(this));
		getCommand("aide").setExecutor(new Commands(this));
		getCommand("plugins").setExecutor(new Commands(this));
		getCommand("pl").setExecutor(new Commands(this));
		getCommand("rules").setExecutor(new Commands(this));
		getCommand("regles").setExecutor(new Commands(this));
		getCommand("lang").setExecutor(new Commands(this));
	}
	public void onDisable(){
		System.out.println("PersonalizedCommands (jak12210) > DESACTIVATED");
	}
	
	
}
