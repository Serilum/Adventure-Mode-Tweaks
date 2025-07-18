package com.natamus.adventuremodetweaks.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.level.GameType;

public class UtilClient {
    public static boolean clientIsInAdventureMode() {
        if (Minecraft.getInstance().player != null) {
            MultiPlayerGameMode multiPlayerGameMode = Minecraft.getInstance().gameMode;
            if (multiPlayerGameMode != null) {
                return multiPlayerGameMode.getPlayerMode().equals(GameType.ADVENTURE);
            }
        }
        return false;
    }
}
