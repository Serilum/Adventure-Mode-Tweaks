package com.natamus.adventuremodetweaks.mixin;

import com.natamus.adventuremodetweaks.features.CreeperCheck;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ExplosionParticleInfo;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ServerLevel.class, priority = 1001)
public class ServerLevelMixin {
    @ModifyVariable(method = "explode", at = @At(value = "STORE"), ordinal = 0)
    public Explosion.BlockInteraction explode_blockInteraction(Explosion.BlockInteraction blockInteraction, @Nullable Entity entity, @Nullable DamageSource damageSource, @Nullable ExplosionDamageCalculator explosionDamageCalculator, double d, double e, double f, float g, boolean bl, Level.ExplosionInteraction explosionInteraction, ParticleOptions particleOptions, ParticleOptions particleOptions2, WeightedList<ExplosionParticleInfo> blockParticles, Holder<SoundEvent> holder) {
        if (!explosionInteraction.equals(Level.ExplosionInteraction.MOB)) {
            return blockInteraction;
        }

        if (CreeperCheck.entityIsCreeperAndExplosionShouldBeBlocked(entity)) {
            return Explosion.BlockInteraction.KEEP;
        }

        return blockInteraction;
    }
}