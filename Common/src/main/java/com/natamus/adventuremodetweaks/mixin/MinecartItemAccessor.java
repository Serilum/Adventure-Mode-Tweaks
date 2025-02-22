package com.natamus.adventuremodetweaks.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.MinecartItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = MinecartItem.class, priority = 1001)
public interface MinecartItemAccessor {
	@Accessor EntityType<? extends AbstractMinecart> getType();
}
