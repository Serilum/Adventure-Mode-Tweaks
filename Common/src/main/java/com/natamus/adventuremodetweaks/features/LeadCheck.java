package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.LeadItem;

public class LeadCheck {
    public static boolean entityIsLeashedAndShouldBeBlocked(Entity entity) {
        if (!ConfigHandler.preventUseOfLeads) {
            return false;
        }

        if (!(entity instanceof Mob mob)) {
            return false;
        }

        return mob.isLeashed();
    }

    public static boolean entityIsLeashKnotAndShouldBeBlocked(Entity entity) {
        if (!ConfigHandler.preventUseOfLeads) {
            return false;
        }

        return entity instanceof LeashFenceKnotEntity;
    }

    public static boolean itemUsedIsALeadAndShouldBeBlocked(Item item) {
        if (!ConfigHandler.preventUseOfLeads) {
            return false;
        }

        return item instanceof LeadItem;
    }
}
