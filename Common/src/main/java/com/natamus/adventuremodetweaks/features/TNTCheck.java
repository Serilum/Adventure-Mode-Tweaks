package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TntBlock;

public class TNTCheck {
    public static boolean targetBlockIsTNTAndShouldBeBlocked(Block block) {
        if (!ConfigHandler.preventLightningTNT) {
            return false;
        }

        return block instanceof TntBlock;
    }
}
