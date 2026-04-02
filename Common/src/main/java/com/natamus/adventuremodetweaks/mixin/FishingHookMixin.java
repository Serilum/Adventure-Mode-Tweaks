package com.natamus.adventuremodetweaks.mixin;

import com.natamus.adventuremodetweaks.features.FishingCheck;
import com.natamus.collective.functions.TaskFunctions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FishingHook.class, priority = 1001)
public abstract class FishingHookMixin {
    @Shadow public abstract void remove(Entity.RemovalReason removalReason);

    @Inject(method = "<init>(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/Level;II)V", at = @At(value = "TAIL"))
    public void FishingHook(Player player, Level level, int i, int j, CallbackInfo ci) {
        if (level.isClientSide()) {
            return;
        }

        if (FishingCheck.shouldStopFishing(player)) {
            TaskFunctions.enqueueCollectiveServerTask(level.getServer(), () -> {
                this.remove(Entity.RemovalReason.DISCARDED);
            }, 1);
        }
    }

    @Inject(method = "setHookedEntity(Lnet/minecraft/world/entity/Entity;)V", at = @At(value = "HEAD"), cancellable = true)
    private void setHookedEntity(Entity hookedEntity, CallbackInfo ci) {
        if (FishingCheck.shouldBlockEntityHook((FishingHook)(Object)this)) {
            ci.cancel();
        }
    }
}
