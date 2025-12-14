package com.natamus.adventuremodetweaks.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;

public class Util {
	public static boolean isInAdventureMode(Player player) {
		if (player.level().isClientSide()) {
			return UtilClient.clientIsInAdventureMode();
		}
		return serverIsInAdventureMode((ServerPlayer)player);
	}

	public static boolean serverIsInAdventureMode(ServerPlayer serverPlayer) {
		return serverPlayer.gameMode.getGameModeForPlayer().equals(GameType.ADVENTURE);
	}
}
