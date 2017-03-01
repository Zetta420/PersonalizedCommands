package fr.jak12210.personalizedcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


import me.smessie.MultiLanguage.api.AdvancedMultiLanguageAPI;

public class Commands implements CommandExecutor {

	private Plugin plugin;
	public Commands(Plugin plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			String uuid = p.getUniqueId().toString();
			String language = AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);
			if(cmd.getName().equalsIgnoreCase("staff")){
				if(args.length == 0){
			        if(language.equalsIgnoreCase("FR")) {
					p.sendMessage(plugin.getConfig().getString("fr.staff.title").replace("&", "§"));
					p.sendMessage(plugin.getConfig().getString("fr.staff.content").replace("&", "§"));
			        }else{
			        p.sendMessage(plugin.getConfig().getString("en.staff.title").replace("&", "§"));
			        p.sendMessage(plugin.getConfig().getString("en.staff.content").replace("&", "§"));
			        }
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("english")){
				if(args.length == 0){
			        AdvancedMultiLanguageAPI.setPlayerLanguage(uuid, "en");
					p.sendMessage(plugin.getConfig().getString("en.lang-change").replace("&", "§"));
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("francais")){
				if(args.length == 0){
			        AdvancedMultiLanguageAPI.setPlayerLanguage(uuid, "fr");
					p.sendMessage(plugin.getConfig().getString("fr.lang-change").replace("&", "§"));
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("help") || cmd.getName().equalsIgnoreCase("aide")){
				if(args.length == 0){
					if(language.equalsIgnoreCase("FR")) {
					p.sendMessage(plugin.getConfig().getString("fr.help.title").replace("&", "§"));
					p.sendMessage(plugin.getConfig().getString("fr.help.page1").replace("&", "§"));
					}else{
					p.sendMessage(plugin.getConfig().getString("en.help.title").replace("&", "§"));
					p.sendMessage(plugin.getConfig().getString("en.help.page1").replace("&", "§"));
					}
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("plugins") || cmd.getName().equalsIgnoreCase("pl") || cmd.getName().equalsIgnoreCase("bukkit:pl")){
				if(args.length == 0){
					if(language.equalsIgnoreCase("FR")) {
					p.sendMessage(plugin.getConfig().getString("fr.plugins.title").replace("&", "§"));
					p.sendMessage(plugin.getConfig().getString("fr.plugins.content").replace("&", "§"));
					}else{
					p.sendMessage(plugin.getConfig().getString("en.plugins.title").replace("&", "§"));
					p.sendMessage(plugin.getConfig().getString("en.plugins.content").replace("&", "§"));
					}
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("rules") || cmd.getName().equalsIgnoreCase("regles")){
				if(args.length == 0){
					if(language.equalsIgnoreCase("FR")) {
					p.sendMessage(plugin.getConfig().getString("fr.rules.title").replace("&", "§"));
					p.sendMessage(plugin.getConfig().getString("fr.rules.content").replace("&", "§"));
					}else{
					p.sendMessage(plugin.getConfig().getString("en.rules.title").replace("&", "§"));
					p.sendMessage(plugin.getConfig().getString("en.rules.content").replace("&", "§"));
					}
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("lang")){
				if(args.length == 0){
					String lang = AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);
					if(lang.equalsIgnoreCase("fr")){
						AdvancedMultiLanguageAPI.setPlayerLanguage(uuid, "en");
						p.sendMessage(plugin.getConfig().getString("en.lang-change").replace("&", "§"));
					}else{
						AdvancedMultiLanguageAPI.setPlayerLanguage(uuid, "fr");
						p.sendMessage(plugin.getConfig().getString("fr.lang-change").replace("&", "§"));
					}
			        
					
					return true;
				}
			}
		}
		return false;
	}
	
	
		
	}

	
