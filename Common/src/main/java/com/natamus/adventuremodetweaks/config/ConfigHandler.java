package com.natamus.adventuremodetweaks.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.adventuremodetweaks.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean forceSurvivalToAdventureMode = false;

	@Entry public static boolean preventAttackingCreatureMobs = false;
	@Entry public static boolean preventAttackingMonsterMobs = false;
	@Entry public static boolean preventEntityInteraction = false;

	@Entry public static boolean preventDestroyingPaintings = true;
	@Entry public static boolean preventDestroyingItemFrames = true;
	@Entry public static boolean preventLootingItemFrames = false;

	@Entry public static boolean preventBreakingMinecarts = false;
	@Entry public static boolean allowPlacingMinecarts = true;
	@Entry public static boolean preventBreakingBoats = false;
	@Entry public static boolean allowPlacingBoats = true;

	@Entry public static boolean preventCreeperBlockDamage = true;
	@Entry public static boolean preventUseOfEnderPearls = false;
	@Entry public static boolean preventBedSleeping = false;
	@Entry public static boolean preventLightningTNT = false;

	@Entry public static boolean preventFishing = false;
	@Entry public static boolean preventFishingRodHookedEntities = true;

	@Entry public static boolean preventUseOfLeads = false;
	@Entry public static boolean preventCowMilking = false;
	@Entry public static boolean preventSheepShearing = false;

	public static void initConfig() {
		configMetaData.put("forceSurvivalToAdventureMode", Arrays.asList(
			"Globally changes Survival Mode to Adventure Mode. This is done when a player joins a world. The Create World Screen UI is updated accordingly as well."
		));

		configMetaData.put("preventAttackingCreatureMobs", Arrays.asList(
			"Stops players in Adventure Mode from harming passive mobs."
		));
		configMetaData.put("preventAttackingMonsterMobs", Arrays.asList(
			"Prevents Adventure Mode players from attacking hostile mobs."
		));
		configMetaData.put("preventEntityInteraction", Arrays.asList(
			"Disables right-click interactions with entities while in Adventure Mode."
		));

		configMetaData.put("preventDestroyingPaintings", Arrays.asList(
			"Adventure Mode players can't break paintings. In vanilla Minecraft this is allowed."
		));
		configMetaData.put("preventDestroyingItemFrames", Arrays.asList(
			"Prevents breaking item frames when in Adventure Mode. In vanilla Minecraft this is allowed."
		));
		configMetaData.put("preventLootingItemFrames", Arrays.asList(
			"Stops Adventure Mode players from taking items from item frames."
		));

		configMetaData.put("preventBreakingMinecarts", Arrays.asList(
			"Prevents players in Adventure Mode from destroying minecarts."
		));
		configMetaData.put("allowPlacingMinecarts", Arrays.asList(
			"Allows minecarts to be placed even in Adventure Mode. Default Minecraft behaviour is no placement."
		));
		configMetaData.put("preventBreakingBoats", Arrays.asList(
			"Prevents players in Adventure Mode from destroying boats."
		));
		configMetaData.put("allowPlacingBoats", Arrays.asList(
			"Allows boat placement while in Adventure Mode. Default Minecraft behaviour is allowed placement."
		));

		configMetaData.put("preventCreeperBlockDamage", Arrays.asList(
			"Stops creepers from destroying blocks when exploded near an Adventure Mode player."
		));
		configMetaData.put("preventUseOfEnderPearls", Arrays.asList(
			"Blocks ender pearl from being used by Adventure Mode players."
		));
		configMetaData.put("preventBedSleeping", Arrays.asList(
			"Prevents sleeping in beds while in Adventure Mode."
		));
		configMetaData.put("preventLightningTNT", Arrays.asList(
			"Prevents Adventure Mode players from lighting TNT with a flint & steel."
		));

		configMetaData.put("preventFishing", Arrays.asList(
			"Adventure Mode players can't use fishing rods."
		));
		configMetaData.put("preventFishingRodHookedEntities", Arrays.asList(
			"Stops players with fishing rods from hooking entities in Adventure Mode."
		));

		configMetaData.put("preventUseOfLeads", Arrays.asList(
			"Prevent using and breaking leads in Adventure Mode."
		));
		configMetaData.put("preventCowMilking", Arrays.asList(
			"Prevents cows from being milked while in Adventure Mode. Redundant if 'preventEntityInteraction' is enabled."
		));
		configMetaData.put("preventSheepShearing", Arrays.asList(
			"Stops sheep from being sheared by Adventure Mode players. Redundant if 'preventEntityInteraction' is enabled."
		));


		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}