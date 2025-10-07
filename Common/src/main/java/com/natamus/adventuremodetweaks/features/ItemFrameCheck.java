package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ItemFrame;

public class ItemFrameCheck {
    public static boolean targetIsItemFrameAndShouldBeBlocked(Entity targetEntity) {
        if (!isItemFrame(targetEntity)) {
            return false;
        }

        if (!ConfigHandler.preventDestroyingItemFrames) {
            return false;
        }

        if (ConfigHandler.preventLootingItemFrames) {
            return false;
        }

        return ((ItemFrame)targetEntity).getItem().isEmpty();
    }

    public static boolean isItemFrame(Entity targetEntity) {
        return targetEntity instanceof ItemFrame;
    }
}
