package com.serilum.adventuremodetweaks.features;

import com.serilum.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.sheep.Sheep;

public class SheepCheck {
	public static boolean entityIsSheepAndShearingShouldBeBlocked(Entity targetEntity) {
		if (!ConfigHandler.preventSheepShearing) {
			return false;
		}

		return targetEntity instanceof Sheep;
	}
}
