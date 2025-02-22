package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import com.natamus.adventuremodetweaks.util.Util;
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
