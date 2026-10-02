package com.serilum.adventuremodetweaks.features;

import com.serilum.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Cow;

public class CowCheck {
	public static boolean entityIsCowAndMilkingShouldBeBlocked(Entity targetEntity) {
		if (!ConfigHandler.preventCowMilking) {
			return false;
		}

		return targetEntity instanceof Cow;
	}
}
