package com.kraken.funnydeathmessages;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class DeathMessages {
	
	public DeathMessages() {
		
	}
	
	public static String fdmFormat(String msg, Player player){
		
	    return String.format( msg, player.getName() );
	    
    }
	
	public String getMessage(Player player, String damager){
		
	    File messagesFile = new File("plugins/FunnyDeathMessages", "messages.yml");
	    FileConfiguration messages = YamlConfiguration.loadConfiguration(messagesFile);
		
		String message = ( player.getName() + " has died of something or other!" );
		
		switch ( damager ) {
		
			case "AREA_EFFECT_CLOUD":
			case "ARROW":
			case "BLAZE":
			case "BLOCK_EXPLOSION":
			case "CAVE_SPIDER":
			case "CONTACT":
			case "CRAMMING":
			case "CREEPER":
			case "CUSTOM":
			case "DRAGON_BREATH":
			case "DRAGON_FIREBALL":
			case "DROWNING":
			case "ELDER_GUARDIAN":
			case "ENDER_DRAGON":
			case "ENDERMAN":
			case "ENDERMITE":
			case "ENTITY_EXPLOSION":
			case "FALL":
			case "FALLING_BLOCK":
			case "FIRE":
			case "FIRE_TICK":
			case "FIRE_BALL":
			case "FLY_INTO_WALL":
			case "GHAST":
			case "GUARDIAN":
			case "HOT_FLOOR":
			case "IRON_GOLEM":
			case "LAVA":
			case "LIGHTNING":
			case "LLAMA":
			case "LLAMA_SPIT":
			case "MAGIC":
			case "MAGMA_CUBE":
			case "MELTING":
			case "PIG_ZOMBIE":
			case "PLAYER":
			case "POISON":
			case "POLAR_BEAR":
			case "PROJECTILE":
			case "SHULKER":
			case "SHULKER_BULLET":
			case "SILVERFISH":
			case "SKELETON":
			case "SKELETON_HORSE":
			case "SLIME":
			case "SPIDER":
			case "STARVATION":
			case "SUFFOCATION":
			case "SUICIDE":
			case "THORNS":
			case "VEX":
			case "VINDICATOR":
			case "VOID":
			case "WITCH":
			case "WITHER":
			case "WITHER_SKELETON":
			case "WOLF":
			case "ZOMBIE":
			case "ZOMBIE_HORSE":
			case "ZOMBIE_VILLAGER":
				
				message = ( fdmFormat(messages.getString(damager + ".message"), player) );
				break;
				
			default:
				
				message = ( fdmFormat(messages.getString("DEFAULT.message"), player) );
				break;
				
		}
		
		return message;
		
	}
      
}
