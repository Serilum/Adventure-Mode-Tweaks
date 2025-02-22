package com.natamus.adventuremodetweaks.mixin;

import com.natamus.adventuremodetweaks.features.CreeperCheck;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import javax.annotation.Nullable;

@Mixin(value = Level.class, priority = 1001)
public class LevelMixin {
    @ModifyVariable(method = "explode(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/level/ExplosionDamageCalculator;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;Z)Lnet/minecraft/world/level/Explosion;", at = @At(value = "STORE"), ordinal = 0)
    public Explosion.BlockInteraction explode_blockInteraction(Explosion.BlockInteraction blockInteraction, @Nullable Entity entity, @Nullable DamageSource damageSource, @Nullable ExplosionDamageCalculator explosionDamageCalculator, double d, double e, double f, float g, boolean bl, Level.ExplosionInteraction explosionInteraction, boolean bl2) {
        if (!explosionInteraction.equals(Level.ExplosionInteraction.MOB)) {
            return blockInteraction;
        }

        if (CreeperCheck.entityIsCreeperAndExplosionShouldBeBlocked(entity)) {
            return Explosion.BlockInteraction.KEEP;
        }

        return blockInteraction;
    }
}
