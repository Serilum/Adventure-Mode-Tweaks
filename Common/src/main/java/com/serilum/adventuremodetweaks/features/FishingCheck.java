package com.serilum.adventuremodetweaks.features;

import com.serilum.adventuremodetweaks.config.ConfigHandler;
import com.serilum.adventuremodetweaks.util.Util;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;

import javax.annotation.Nullable;

public class FishingCheck {
	public static boolean shouldStopFishing(Player player) {
		if (!ConfigHandler.preventFishing) {
			return false;
		}

		return Util.isInAdventureMode(player);
	}

	public static boolean shouldBlockEntityHook(FishingHook fishingHook) {
		if (!ConfigHandler.preventFishingRodHookedEntities) {
			return false;
		}

		Player player = getPlayerOwner(fishingHook);
		if (player == null) {
			return false;
		}

		return Util.isInAdventureMode(player);
	}

	public static @Nullable Player getPlayerOwner(FishingHook fishingHook) {
		if (fishingHook.getOwner() instanceof Player player) {
			return player;
		}
		return null;
	}
}
