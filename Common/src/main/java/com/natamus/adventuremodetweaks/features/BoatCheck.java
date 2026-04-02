package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;

public class BoatCheck {
    public static boolean targetIsBoatAndShouldBeBlocked(Entity targetEntity) {
        if (!ConfigHandler.preventBreakingBoats) {
            return false;
        }

        return targetEntity instanceof Boat;
    }

    public static boolean itemIsBoatAndCannotBePlaced(Item item) {
        if (ConfigHandler.allowPlacingBoats) {
            return false;
        }

        return item instanceof BoatItem;
    }
}
