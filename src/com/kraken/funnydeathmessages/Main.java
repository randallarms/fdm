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
	
	boolean opRequired = true;
	boolean enabled = true;
	
	@Override
    public void onEnable() {
    	
    	getLogger().info("FunnyDeathMessages has been enabled.");
		PluginManager pm = getServer().getPluginManager();
		FDMListener listener = new FDMListener(this);
		pm.registerEvents(listener, this);
		
	  //Initialize the config with a dummy value
        if ( !getConfig().getBoolean("loaded") ) {
        	getConfig().set("loaded", true);
        	getConfig().set("enabled", true);
        	getConfig().set("opRequired", true);
        	saveConfig();
        }

        enabled = getConfig().getBoolean("enabled");
        opRequired = getConfig().getBoolean("opRequired");
		
    }
    
    @Override
    public void onDisable() {
    	
        getLogger().info("FunnyDeathMessages has been disabled.");
        
    }
    
  //Check if messages are enabled
    public boolean enabled() {
    	return enabled;
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
        			  
        	    	switch (args.length) {
        	    	
        	    		case 1:
        	    			switch ( args[0].toLowerCase() ) {
        	    				case "on":
        	    				case "enable":
        	    				case "true":
        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages " + ChatColor.GREEN + "enabled" + ChatColor.GRAY + "!");
        	    					enabled = true;
        	    					getConfig().set("enabled", true);
        	    					saveConfig();
        	    					return true;
        	    				case "off":
        	    				case "disable":
        	    				case "false":
        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages " + ChatColor.RED + "disabled" + ChatColor.GRAY + "!");
        	    					enabled = false;
        	    					getConfig().set("enabled", false);
        	    					saveConfig();
        	    					return true;
        	    				default:
        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages | Laughter is the best medicine, so yuck it up (v1.1)");
        	    					return true;
        	    			}
        	    		default:
        	    			player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages | Laughter is the best medicine, so yuck it up (v1.1)");
        	    			return true;
        	    	
        	    	}
        	        
			        
			    default:
			    	  
			        player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | " + "Command not recognized.");
			        return true;
			    
	        }
        
        }
        
        return true;
        
    }
    
}
