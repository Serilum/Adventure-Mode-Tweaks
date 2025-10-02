package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
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
