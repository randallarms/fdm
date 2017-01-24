package com.kraken.funnydeathmessages;

import java.util.WeakHashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
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
	
	public FDMListener(Main plugin) {
		
		this.plugin = plugin;
		
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		
		if ( e.getEntity() instanceof Player ) {
			
			Player player = (Player) e.getEntity();
			Entity damager = e.getDamager();
				
			damages.put( player, damager.getType().toString() );
			
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
		
		e.setDeathMessage( format( deathMsgGen(player) ) );
		
	}
	
	public static String format(String format){
		
	    return ChatColor.translateAlternateColorCodes('&', format);
	    
    }
	
	public String deathMsgGen(Player player) {
		
		String damager = damages.get(player);
		DeathMessages dm = new DeathMessages();
		
		return dm.getMessage(player, damager);
		
	}
      
}
