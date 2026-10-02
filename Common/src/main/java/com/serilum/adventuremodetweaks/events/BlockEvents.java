package com.serilum.adventuremodetweaks.events;

import com.serilum.adventuremodetweaks.features.BedCheck;
import com.serilum.adventuremodetweaks.features.BoatCheck;
import com.serilum.adventuremodetweaks.features.MinecartCheck;
import com.serilum.adventuremodetweaks.features.TNTCheck;
import com.serilum.adventuremodetweaks.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlockEvents {
	@SuppressWarnings("RedundantIfStatement")
	public static boolean onRightClickBlock(Level level, Player player, InteractionHand interactionHand, BlockPos targetBlockPos, BlockHitResult hitVec) {
		if (!Util.isInAdventureMode(player)) {
			return true;
		}

		BlockState targetBlockState = level.getBlockState(targetBlockPos);
		Block targetBlock = targetBlockState.getBlock();

		if (BedCheck.targetBlockIsBedAndShouldBeBlocked(targetBlock)) {
			return false;
		}

		if (TNTCheck.targetBlockIsTNTAndShouldBeBlocked(targetBlock)) {
			return false;
		}

		ItemStack handStack = player.getItemInHand(interactionHand);
		Item handItem = handStack.getItem();

		if (BoatCheck.itemIsBoatAndCannotBePlaced(handItem)) {
			return false;
		}

		if (MinecartCheck.itemIsMinecartAndCanBePlaced(handItem, level, targetBlockState)) {
			if (!MinecartCheck.placeMinecart(level, player, targetBlockPos, handStack)) {
				return false;
			}
		}

		return true;
	}
}
