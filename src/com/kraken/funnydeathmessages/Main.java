// ========================================================================
// |FUNNY DEATH MESSAGES v1.0
// | by Kraken | https://www.spigotmc.org/resources
// | code inspired by various Bukkit & Spigot devs -- thank you. 
// |
// | Always free & open-source! If this plugin is being sold or re-branded,
// | please let me know on the SpigotMC site, or wherever you can. Thanks!
// | Source code: https://github.com/randallarms
// ========================================================================

package com.kraken.funnydeathmessages;

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
    
}
