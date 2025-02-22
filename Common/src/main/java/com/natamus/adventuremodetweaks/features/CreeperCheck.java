package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import com.natamus.adventuremodetweaks.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;

public class CreeperCheck {
    public static boolean entityIsCreeperAndExplosionShouldBeBlocked(Entity entity) {
        if (!ConfigHandler.preventCreeperBlockDamage) {
            return false;
        }

        if (!isCreeper(entity)) {
            return false;
        }

        Creeper creeper = (Creeper)entity;
        if (!(creeper.getTarget() instanceof Player player)) {
            return false;
        }

        return Util.isInAdventureMode(player);
    }

    public static boolean isCreeper(Entity targetEntity) {
        return targetEntity instanceof Creeper;
    }
}
