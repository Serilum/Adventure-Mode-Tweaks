package com.serilum.adventuremodetweaks.features;

import com.serilum.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;

public class BedCheck {
	public static boolean targetBlockIsBedAndShouldBeBlocked(Block block) {
		if (!ConfigHandler.preventBedSleeping) {
			return false;
		}

		return block instanceof BedBlock;
	}
}
