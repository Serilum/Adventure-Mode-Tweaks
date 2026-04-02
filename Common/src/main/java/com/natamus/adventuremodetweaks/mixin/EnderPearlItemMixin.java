package com.natamus.adventuremodetweaks.mixin;

import com.natamus.adventuremodetweaks.features.EnderPearlCheck;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnderpearlItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EnderpearlItem.class, priority = 1001)
public class EnderPearlItemMixin {
	@Inject(method = "use", at = @At(value = "HEAD"), cancellable = true)
	public void use(Level level, Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
		if (EnderPearlCheck.shouldBlockThrownEnderPearl(level, player)) {
			cir.setReturnValue(InteractionResult.FAIL);
		}
	}
}
