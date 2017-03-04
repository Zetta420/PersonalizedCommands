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
	public boolean myTextCommand1(CommandSender sender, Command cmd, String msg, String[] args, String configfr, String configen, String commande){
		if(sender instanceof Player){
			Player p = (Player)sender;
			String uuid = p.getUniqueId().toString();
			String language = AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);
			if(cmd.getName().equalsIgnoreCase(commande)){
				if(args.length == 0){
					if(language.equalsIgnoreCase("FR")) {
							while(configfr.length() >= 1){
						p.sendMessage(plugin.getConfig().getStringList(configfr));
							}
						
					}else{
						while(configen.length() <= 1){
						p.sendMessage(plugin.getConfig().getStringList(configen));
						}
					}
					return true;
					
				}
			}
		}
		return false;
		
	}
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		String configfr = "fr.staff.title";
		String configen = "en.staff.title";
		String commande = "staff";
		myTextCommand1(sender, cmd, msg, args, configfr, configen, commande);
		if(sender instanceof Player){
			Player p = (Player)sender;
			String uuid = p.getUniqueId().toString();
			String language = AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);
			
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
			if(cmd.getName().equalsIgnoreCase("plugins") || cmd.getName().equalsIgnoreCase("pl") || cmd.getName().startsWith("bukkit:")){
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
					if(language.equalsIgnoreCase("fr")){
						AdvancedMultiLanguageAPI.setPlayerLanguage(uuid, "en");
						p.sendMessage(plugin.getConfig().getString("en.lang-change").replace("&", "§"));
					}else{
						AdvancedMultiLanguageAPI.setPlayerLanguage(uuid, "fr");
						p.sendMessage(plugin.getConfig().getString("fr.lang-change").replace("&", "§"));
					}
			        
					
					return true;
				}
			}
			if(cmd.getName().equalsIgnoreCase("announce") || cmd.getName().equalsIgnoreCase("annonce")){
				if(args.length <= 0){
				p.getServer().broadcastMessage(plugin.getConfig().getString("broadcast.prefix").replace("&", "§") + args);
				}
			}
		}
		return false;
	}
	private void myTextCommand(CommandSender sender, Command cmd, String msg, String[] args, String configfr,
			String configen, String commande) {
		// TODO Auto-generated method stub
		
	}
	public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().getWorld().strikeLightningEffect(event.getPlayer().getLocation());
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage((ChatColor.DARK_RED + p.getName() + ChatColor.GOLD + " has joined the Game with Holy Powers!"));
        }
    }
	
	
		
	}

	
