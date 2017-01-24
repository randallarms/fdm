package com.kraken.funnydeathmessages;

import org.bukkit.entity.Player;

public class DeathMessages {
	
	public DeathMessages() {
		
	}
	
	public String getMessage(Player player, String damager){
		
		String message = ( player.getName() + " has died of something or other!" );
		
		switch ( damager ) {
		
			case "ARROW":
				message = ( player.getName() + " has taken an arrow to the knee!" );
				break;
				
			case "BLAZE":
				message = ( player.getName() + " got blazed." );
				break;
		
			case "BLOCK_EXPLOSION":
				message = ( player.getName() + " has been blown up into a million teeny-tiny pieces!" );
				break;
				
			case "CAVE_SPIDER":
				message = ( player.getName() + " is currently being dragged into some dank cave-spider lair! Weeeee!" );
				break;
				
			case "CONTACT":
				message = ( player.getName() + " has been given a total cactus-needle probing!" );
				break;
				
			case "CRAMMING":
				message = ( player.getName() + " was annihilated from the fabric of space-time in a mass-collision event!" );
				break;
				
			case "CREEPER":
				message = ( player.getName() + " met a creeper and was turned into a fine mist!" );
				break;
				
			case "CUSTOM":
				message = ( "I'm not even really sure what killed " + player.getName() + " that time!" );
				break;
				
			case "DRAGON_BREATH":
				message = ( player.getName() + " was cooked well-done by a dragon. Dinner time!" );
				break;
				
			case "DRAGON_FIREBALL":
				message = ( player.getName() + " was cooked well-done by a dragon. Dinner time!" );
				break;
				
			case "DROWNING":
				message = ( player.getName() + " is now sleepin' with da fishes." );
				break;
				
			case "ELDER_GUARDIAN":
				message = ( player.getName() + " tried sleepin' with da fishes, but was eaten instead!" );
				break;
				
			case "ENDER_DRAGON":
				message = ( player.getName() + " was cooked well-done by a dragon. Dinner time!" );
				break;
				
			case "ENDERMAN":
				message = ( player.getName() + " looked the wrong way at some tall, creepy dude!" );
				break;
				
			case "ENDERMITE":
				message = ( player.getName() + " was killed by smallest hostile mob in the entire game, congratulations!" );
				break;
				
			case "ENTITY_EXPLOSION":
				message = ( player.getName() + " met a creeper and was turned into a fine mist!" );
				break;
				
			case "FALL":
				message = ( player.getName() + " is now ready to be mopped up off the floor!" );
				break;
				
			case "FALLING_BLOCK":
				message = ( player.getName() + " got beaned in the noggin from above!" );
				break;
				
			case "FIRE":
				message = ( player.getName() + " tried to play with fire!" );
				break;
				
			case "FIRE_TICK":
				message = ( player.getName() + " was set ablaze and immolated!" );
				break;
				
			case "FIRE_BALL":
				message = ( player.getName() + " discovered how many licks it takes to get to the center of a fireball!" );
				break;
				
			case "FLY_INTO_WALL":
				message = ( player.getName() + " has been turned into a pancake by velocity... EXTREEEEME!" );
				break;
				
			case "GHAST":
				message = ( player.getName() + " has just been left a-GHAST by his plight! Get it? Ghast?! Aha.. ha.. ugh.." );
				break;
				
			case "GUARDIAN":
				message = ( player.getName() + " tried sleepin' with da fishes, but was eaten instead!" );
				break;
				
			case "HOT_FLOOR":
				message = ( player.getName() + " decided to take a stroll out on a bed of magma!" );
				break;
				
			case "IRON_GOLEM":
				message = ( player.getName() + " picked a fight with a golem twice their size and made of metal. Well done!" );
				break;
				
			case "LAVA":
				message = ( player.getName() + " has discovered that, literally, the floor is now lava!" );
				break;
				
			case "LIGHTNING":
				message = ( player.getName() + " has been struck by lightning and turned into a superhero!" );
				break;
				
			case "LLAMA":
			case "LLAMA_SPIT":
				message = ( "The llamas have turned on " + player.getName() + "!" );
				break;
				
			case "MAGIC":
				message = ( "Yer a wizzerd, " + player.getName() + "!" );
				break;
				
			case "MAGMA_CUBE":
				message = ( player.getName() + " was assimilated into a magma cube!" );
				break;
				
			case "MELTING":
				message = ( player.getName() + " is apparently a snowman and has melted, who knew?" );
				break;
				
			case "PIG_ZOMBIE":
				message = ( player.getName() + " is about to have a really hard time in the Nether!" );
				break;
				
			case "PLAYER":
				message = ( player.getName() + " just got a straight-up slap-down whack-a-mole bee-bop doo-wop boppin' on the noodle-noggin', yo!" );
				break;
				
			case "POISON":
				message = ( player.getName() + " has suffered a slow and terrible death by poisoning -- the death of choice by historic emperors!" );
				break;
				
			case "POLAR_BEAR":
				message = ( player.getName() + " lost a round of fisticuffs with a polar bear!" );
				break;
				
			case "PROJECTILE":
				message = ( player.getName() + " just learned a hard lesson about standing in a projectile's trajectory!" );
				break;
				
			case "SHULKER":
			case "SHULKER_BULLET":
				message = ( player.getName() + " ate lead! ...or whatever it is that shulkers shoot!" );
				break;
				
			case "SILVERFISH":
				message = ( player.getName() + " is now raging at Monster Eggs!" );
				break;
				
			case "SKELETON":
			case "SKELETON_HORSE":
				message = ( player.getName() + " got 2spooped by mr. skeltal! doot doot!" );
				break;
				
			case "SLIME":
				message = ( player.getName() + " was assimilated into the Blob!" );
				break;
				
			case "SPIDER":
				message = ( player.getName() + " was eaten by their friendly neighborhood spider, man!" );
				break;
				
			case "STARVATION":
				message = ( player.getName() + " needs to eat a Snickers!" );
				break;
				
			case "SUFFOCATION":
				message = ( "Don't forget to breath, " + player.getName() + "!" );
				break;
				
			case "SUICIDE":
				message = ( "Screw you guys; " + player.getName() + " is going home." );
				break;
				
			case "THORNS":
				message = ( player.getName() + " was turned into swiss cheese by the thorns of their enemies!" );
				break;
				
			case "VEX":
				message = ( player.getName() + " got their butt kicked by a little flying fairy thing-a-majig! HA!" );
				break;
				
			case "VINDICATOR":
				message = ( player.getName() + " got vindicated!" );
				break;
				
			case "VOID":
				message = ( player.getName() + " tried to explore the vast unknown, with little success!" );
				break;
				
			case "WITCH":
				message = ( player.getName() + " stood on the wrong side of someone's Avada Kedavra!" );
				break;
				
			case "WITHER":
			case "WITHER_SKELETON":
				message = ( player.getName() + " has been withered away to a husk by some horrible curse! Yaaay!" );
				break;
				
			case "WOLF":
				message = ( player.getName() + " is now dogmeat!" );
				break;
				
			case "ZOMBIE":
			case "ZOMBIE_HORSE":
			case "ZOMBIE_VILLAGER":
				message = ( player.getName() + " is now experiencing a strong craving.. for.. for braaains.. BRAAAAAAAAINNNSSS!!" );
				break;
				
			default:
				message = ( player.getName() + " has died mysteriously and without a trace!" );
				break;
				
		}
		
		return message;
		
	}
      
}
