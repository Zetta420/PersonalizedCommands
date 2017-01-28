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
			if(cmd.getName().equalsIgnoreCase("staff")){
				if(args.length == 0){
					String uuid = p.getUniqueId().toString();
			        String language = AdvancedMultiLanguageAPI.getLanguageOfUuid(uuid);
			        if(language.equalsIgnoreCase("FR")) {
					p.sendMessage(plugin.getConfig().getString("fr.staff.title"));
			        }else{
			        p.sendMessage(plugin.getConfig().getString("en.staff.title"));
			        }
					return true;
				}
			}
		}
		return false;
	}

}
