// ==========================================================================
// |FUNNY DEATH MESSAGES v1.1
// | by Kraken | https://www.spigotmc.org/resources/funnydeathmessages.35291/
// | code inspired by various Bukkit & Spigot devs -- thank you. 
// |
// | Always free & open-source! If this plugin is being sold or re-branded,
// | please let me know on the SpigotMC site, or wherever you can. Thanks!
// | Source code: https://github.com/randallarms/fdm
// ==========================================================================

package com.kraken.funnydeathmessages;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
    public void onEnable() {
    	
    	getLogger().info("FunnyDeathMessages has been enabled.");
		PluginManager pm = getServer().getPluginManager();
		FDMListener listener = new FDMListener(this);
		pm.registerEvents(listener, this);
		
    }
    
    @Override
    public void onDisable() {
    	
        getLogger().info("FunnyDeathMessages has been disabled.");
        
    }
    
  //FDM commands
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	String command = cmd.getName();
		Player player = (Player) sender;
        
      //Player commands
        if ( sender instanceof Player ) {
        	
        	switch (command) {
        	
			  //Command: fdm
        	    case "fdm":
        			  
        	        player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages | Laughter is the best medicine, so yuck it up (v1.1)");
			        return true;
			        
			    default:
			    	  
			        player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | " + "Command not recognized.");
			        return true;
			    
	        }
        
        }
        
        return true;
        
    }
    
}
