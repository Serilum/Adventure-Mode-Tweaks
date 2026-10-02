package com.serilum.adventuremodetweaks.features;

import com.serilum.adventuremodetweaks.config.ConfigHandler;
import com.serilum.adventuremodetweaks.util.Util;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EnderPearlCheck {
	public static boolean shouldBlockThrownEnderPearl(Level level, Player throwingPlayer) {
		if (!ConfigHandler.preventUseOfEnderPearls) {
			return false;
		}

		return Util.isInAdventureMode(throwingPlayer);
	}

}
