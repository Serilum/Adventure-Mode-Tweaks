package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;

public class GeneralAttackCheck {
    public static boolean shouldBlockEntityDamage(Entity entity) {
        if (!ConfigHandler.preventAttackingCreatureMobs && !ConfigHandler.preventAttackingMonsterMobs) {
            return false;
        }

        MobCategory mobCategory = entity.getType().getCategory();
        if (mobCategory.equals(MobCategory.CREATURE) || mobCategory.equals(MobCategory.WATER_CREATURE) || mobCategory.equals(MobCategory.UNDERGROUND_WATER_CREATURE)) {
            return ConfigHandler.preventAttackingCreatureMobs;
        }

        if (mobCategory.equals(MobCategory.MONSTER)) {
            return ConfigHandler.preventAttackingMonsterMobs;
        }

        return false;
    }
}
