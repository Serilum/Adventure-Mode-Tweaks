package com.natamus.adventuremodetweaks.features;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import com.natamus.adventuremodetweaks.mixin.MinecartItemAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class MinecartCheck {
    public static boolean targetIsMinecartAndShouldBeBlocked(Entity targetEntity) {
        if (!ConfigHandler.preventBreakingMinecarts) {
            return false;
        }

        return targetEntity instanceof Minecart;
    }

    public static boolean itemIsMinecartAndCanBePlaced(Item item, Level level, BlockState targetBlockState) {
        if (!ConfigHandler.allowPlacingMinecarts) {
            return false;
        }

        if (!(item instanceof MinecartItem)) {
            return false;
        }

        return targetBlockState.getBlock() instanceof RailBlock;
    }

    public static boolean placeMinecart(Level level, Player player, BlockPos targetBlockPos, ItemStack handStack) {
        BlockState blockState = level.getBlockState(targetBlockPos);

        RailShape railShape = blockState.getBlock() instanceof BaseRailBlock ? blockState.getValue(((BaseRailBlock)blockState.getBlock()).getShapeProperty()) : RailShape.NORTH_SOUTH;
        double offset = 0.0F;
        if (railShape.isAscending()) {
            offset = 0.5F;
        }

        Vec3 vec = new Vec3((double)targetBlockPos.getX() + (double)0.5F, (double)targetBlockPos.getY() + (double)0.0625F + offset, (double)targetBlockPos.getZ() + (double)0.5F);

        if (level instanceof ServerLevel serverLevel) {
            AbstractMinecart abstractMinecart = AbstractMinecart.createMinecart(serverLevel, vec.x, vec.y, vec.z, ((MinecartItemAccessor)handStack.getItem()).getType(), handStack, player);
            serverLevel.addFreshEntity(abstractMinecart);

            serverLevel.gameEvent(GameEvent.ENTITY_PLACE, targetBlockPos, GameEvent.Context.of(player, serverLevel.getBlockState(targetBlockPos.below())));
        }

        handStack.shrink(1);

        return true;
    }
}
