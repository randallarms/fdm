// ==========================================================================
// |FUNNY DEATH MESSAGES v1.6
// | by Kraken | https://www.spigotmc.org/resources/funnydeathmessages.35291/
// | code inspired by various Bukkit & Spigot devs -- thank you. 
// |
// | Always free & open-source! If this plugin is being sold or re-branded,
// | please let me know on the SpigotMC site, or wherever you can. Thanks!
// | Source code: https://github.com/randallarms/fdm
// ==========================================================================

package com.kraken.funnydeathmessages;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
    private File messagesFile = new File("plugins/FunnyDeathMessages", "messages.yml");
    private FileConfiguration messages = YamlConfiguration.loadConfiguration(messagesFile);
	
	boolean opRequired = true;
	boolean enabled = true;
	
	//default color code for messages
	String defColor = "&6";
	
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
        
        if ( getConfig().getString("defColor") == null ) {
        	getConfig().set("defColor", "&6");
        	saveConfig();
        }
        
        enabled = getConfig().getBoolean("enabled");
        opRequired = getConfig().getBoolean("opRequired");
        defColor = getConfig().getString("defColor");
        
  	  //Initialize the messages config
        if ( !messages.getBoolean("loaded") ) {
        	
        	File msgFile = new File(getDataFolder(), "messages.yml");
        	if ( !msgFile.exists() ) {
        	    saveResource("messages.yml", false);
        	}
        	YamlConfiguration msg = YamlConfiguration.loadConfiguration(msgFile);
        	
        	try {
            	msg.save(msgFile);
    		} catch (IOException ioe1) {
    			System.out.println("Could not properly initialize FunnyDeathMessages messages.yml file, expect possible errors.");
    		}
        	
        }
		
    }
    
    @Override
    public void onDisable() {
    	
        getLogger().info("FunnyDeathMessages has been disabled.");
        
    }
    
  //Check if messages are enabled
    public boolean enabled() {
    	return enabled;
    }
    
  //Get the default color for messages
    public String getDefColor() {
    	return defColor;
    }
    
  //Set the default color for messages 
    public void setDefColor(Player player, String[] args) {
    	getConfig().set("defColor", defColor);
    	saveConfig();
    }
    
  //FDM commands
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	String command = cmd.getName();
		Player player = (Player) sender;
        
      //Player commands
        if ( sender instanceof Player ) {
        	
        	if ( !opRequired || ( opRequired && player.isOp() ) ) {
        		
	        	switch (command) {
	        	
					  //Command: fdm
		        	    case "fdm":
		        			  
		        	    	switch (args.length) {
		        	    	
		        	    		case 1:
		        	    			switch ( args[0].toLowerCase() ) {
		        	    				case "on":
		        	    				case "enable":
		        	    				case "true":
		        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages " + ChatColor.GREEN 
		        	    											+ "enabled" + ChatColor.GRAY + "!");
		        	    					enabled = true;
		        	    					getConfig().set("enabled", true);
		        	    					saveConfig();
		        	    					return true;
		        	    				case "off":
		        	    				case "disable":
		        	    				case "false":
		        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages " + ChatColor.RED 
		        	    											+ "disabled" + ChatColor.GRAY + "!");
		        	    					enabled = false;
		        	    					getConfig().set("enabled", false);
		        	    					saveConfig();
		        	    					return true;
		        	    				default:
		        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages | Try entering \"/fdm <on/off>\"");
		        	    					return true;
		        	    			}
		        	    		
		        	    		case 2:
		        	    			switch ( args[0].toLowerCase() ) {
		        	    			
			        	    			case "opReq":
			        	    			case "opreq":
			        	    			case "opRequired":
			        	    			case "oprequired":
		        	    				
				        	    			switch ( args[1].toLowerCase() ) {
				        	    				case "on":
				        	    				case "enable":
				        	    				case "true":
				        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FDM's 'op' requirement " + ChatColor.GREEN 
				        	    										+ "enabled" + ChatColor.GRAY + "!");
				        	    					opRequired = true;
				        	    					getConfig().set("opRequired", true);
				        	    					saveConfig();
				        	    					return true;
				        	    				case "off":
				        	    				case "disable":
				        	    				case "false":
				        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FDM's 'op' requirement " + ChatColor.RED 
				        	    										+ "disabled" + ChatColor.GRAY + "!");
				        	    					opRequired = true;
				        	    					getConfig().set("opRequired", false);
				        	    					saveConfig();
				        	    					return true;
				        	    			}
			        	    			
			        	    			case "color":
			        	    				
			        	    				String oldColor = defColor;
			        	    				
			        	    				switch ( args[1].toLowerCase() ) {
				        	    				case "darkred":
				        	    					defColor = "&4";
				        	    				case "red":
				        	    					defColor = "&c";
				        	    				case "orange":
				        	    					defColor = "&6";
				        	    				case "yellow":
				        	    					defColor = "&e";
				        	    				case "green":
				        	    					defColor = "&2";
				        	    				case "lime":
				        	    					defColor = "&a";
				        	    				case "aqua":
				        	    					defColor = "&b";
				        	    				case "darkaqua":
				        	    					defColor = "&3";
				        	    				case "darkblue":
				        	    					defColor = "&1";
				        	    				case "blue":
				        	    					defColor = "&9";
				        	    				case "lightpurple":
				        	    					defColor = "&d";
				        	    				case "darkpurple":
				        	    					defColor = "&5";
				        	    				case "white":
				        	    					defColor = "&6";
				        	    				case "lightgray":
				        	    					defColor = "&7";
				        	    				case "darkgray":
				        	    					defColor = "&8";
				        	    				case "black":
				        	    					defColor = "&0";
				        	    				default:
				        	    					setDefColor(player, args);
				        	    					if ( !defColor.equals(oldColor) ) {
					        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FDM's default message color is now set to " 
					        	    										+ args[1] + ".");
				        	    					} else {
				        	    						player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | Color not recognized!");
				        	    					}
				        	    					return true;
			        	    				}
			        	    				
			        	    			
		        	    				default:
		        	    					player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | FunnyDeathMessages | Argument not recognized.\"");
		        	    					return true;
		        	    			}
		        	    			
		        	    		default:
		        	    			player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY 
		        	    								+ " | FunnyDeathMessages | Laughter is the best medicine, so yuck it up (v1.6)");
		        	    			return true;
		        	    	
		        	    	}
		        	    	
					    default:
					    	  
					        player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | " + "Command not recognized.");
					        return true;
					        
		        }
        	
        	} else {
        		
        		player.sendMessage(ChatColor.RED + "[FDM]" + ChatColor.GRAY + " | You have insufficient privileges to use this command.");
    			return true;
        		
        	}
        
        }
        
        return true;
        
    }
    
}
