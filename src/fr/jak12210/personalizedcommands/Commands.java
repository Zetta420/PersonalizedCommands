package fr.jak12210.personalizedcommands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;


import me.smessie.MultiLanguage.api.AdvancedMultiLanguageAPI;

public class Commands implements CommandExecutor {

	private Plugin plugin;
	public Commands(Plugin plugin) {
		this.plugin = plugin;
	}
	public void SendMessageLang(CommandSender sender, String messagefr, String messageen) {
        Player p = (Player) sender;
        String uuid = p.getUniqueId().toString();
        String language = AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);

        
            language.equalsIgnoreCase("FR");
            for (String monMessage : plugin.getConfig().getStringList(messagefr)) {
                p.sendMessage(monMessage.replace("&", "§"));
            }
        
            for (String monMessage : plugin.getConfig().getStringList(messageen)) {
                p.sendMessage(monMessage.replace("&", "§"));
            }
        
    }
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		;
		for (String command : plugin.getConfig().getStringList("commandes")) {
			if(cmd.getName().equalsIgnoreCase(command)){
				String messagefr = "commandes." + command + ".fr";
				String messageen = "commandes." + command + ".en";
				SendMessageLang(sender, messagefr, messageen);
				return true;
			}
		}
		return false;
	}
	public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().getWorld().strikeLightningEffect(event.getPlayer().getLocation());
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage((ChatColor.DARK_RED + p.getName() + ChatColor.GOLD + " has joined the Game with Holy Powers!"));
        }
    }
	
	
		
	}

	
