package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.painting.Painting;

public class PaintingCheck {
    public static boolean targetIsPaintingAndShouldBeBlocked(Entity targetEntity) {
        if (!ConfigHandler.preventDestroyingPaintings) {
            return false;
        }

        return isPainting(targetEntity);
    }

    public static boolean isPainting(Entity targetEntity) {
        return targetEntity instanceof Painting;
    }
}
