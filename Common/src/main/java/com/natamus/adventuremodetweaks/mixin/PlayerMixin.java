package com.natamus.adventuremodetweaks.mixin;

import com.natamus.adventuremodetweaks.events.EntityEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Player.class, priority = 1001)
public class PlayerMixin {
	@Inject(method = "attack", at = @At("HEAD"), cancellable = true)
	public void onPlayerInteractEntity(Entity targetEntity, CallbackInfo ci) {
		Player player = (Player)(Object)this;
		Level level = player.level();
		if (level.isClientSide()) {
			return;
		}

		if (!EntityEvents.onEntityAttack((ServerPlayer)player, (ServerLevel)level, targetEntity)) {
			ci.cancel();
		}
	}
}
