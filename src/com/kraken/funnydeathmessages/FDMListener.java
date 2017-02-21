package com.kraken.funnydeathmessages;

import java.util.WeakHashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

public class FDMListener implements Listener {
	
	Main plugin;
	
	WeakHashMap<Player, String> damages = new WeakHashMap<Player, String>();
	WeakHashMap<Player, Integer> deathCount = new WeakHashMap<Player, Integer>();
	
	public FDMListener(Main plugin) {
		
		this.plugin = plugin;
		
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		
		if ( e.getEntity() instanceof Player ) {
			
			Player player = (Player) e.getEntity();
			
			damages.put( player, e.getDamager().getType().toString() );
			
		}
		
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		
		if ( e.getEntity() instanceof Player ) {
			
			Player player = (Player) e.getEntity();
			DamageCause damager = e.getCause();
			
			switch ( damager.name() ) {
			
				case "ENTITY_ATTACK":
				case "ENTITY_SWEEP_ATTACK":
					break;
			
				default:
					damages.put( player, damager.name() );
					
			}
			
		}
		
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		
		Player player = (Player) e.getEntity();
		String damager = damages.get(player);
		
		if ( plugin.enabled() ) {
			
		  //Increment player's recent death count
			Integer deaths = deathCount.get(player);
			
			if ( deaths == null ) {
				deathCount.put(player, 1);
			} else {
				deathCount.put(player, deaths + 1);
			}
			
		  //Decrement player's recent death count after 5 minutes
			plugin.getServer().getScheduler().scheduleSyncDelayedTask( plugin, new Runnable() {

	            public void run() {

	            	Integer deaths = deathCount.get(player);
	            	deathCount.put(player, deaths - 1);
	                
	            }

	        }, 6000 );
			
		  //If killed by a player, get the killer's name
			String killer = "N/A";
			
			if ( damager.equals("PLAYER") ) {
				killer = player.getKiller().getName();
			}
			
		  //Set the player's death message
			e.setDeathMessage( format( plugin.getDefColor() + deathMsgGen(player, damager, killer) ) );
			
		}
		
	}
	
	public static String format(String format){
		
	    return ChatColor.translateAlternateColorCodes('&', format);
	    
    }
	
	public String deathMsgGen(Player player, String damager, String killer) {
		
		DeathMessages dm = new DeathMessages();
		Integer deaths = deathCount.get(player);
		
		if ( deaths == 3 ) {
			return dm.getSpreeMessage(player, damager, killer, deaths);
		} else {
			return dm.getMessage(player, damager, killer);
		}
		
	}
      
}
