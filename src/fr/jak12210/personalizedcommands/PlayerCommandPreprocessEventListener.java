package fr.jak12210.personalizedcommands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import me.smessie.MultiLanguage.api.AdvancedMultiLanguageAPI;

public class PlayerCommandPreprocessEventListener implements Listener {
	private Plugin plugin;
	public PlayerCommandPreprocessEventListener(Plugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler(priority = EventPriority.LOWEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent event){
		Player p = event.getPlayer();
		String uuid = p.getUniqueId().toString();
		String language = AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);
	if(event.getMessage().toLowerCase().startsWith("/bukkit:pl") || event.getMessage().toLowerCase().startsWith("/bukkit:plugins")){
	if(language.equalsIgnoreCase("FR")) {
	p.sendMessage(plugin.getConfig().getString("fr.plugins.title").replace("&", "§"));
	p.sendMessage(plugin.getConfig().getString("fr.plugins.content").replace("&", "§"));
	}else{
	p.sendMessage(plugin.getConfig().getString("en.plugins.title").replace("&", "§"));
	p.sendMessage(plugin.getConfig().getString("en.plugins.content").replace("&", "§"));
	}
	event.setCancelled(true);
	}
	}
	}
