package com.natamus.adventuremodetweaks.mixin;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WorldCreationUiState.SelectedGameMode.class, priority = 1001)
public class WorldCreationUiStateMixin {
    @Shadow public @Final @Mutable Component displayName;
    @Shadow private @Final @Mutable Component info;

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void SelectedGameMode(String s, int i, String stringGameMode, GameType gameType, CallbackInfo ci) {
        if (!ConfigHandler.forceSurvivalToAdventureMode) {
            return;
        }

        if (gameType.equals(GameType.SURVIVAL)) {
            // Display Name Component
            MutableComponent displayNameComponent = Component.translatable("selectWorld.gameMode.adventure");
            if (stringGameMode.equals("hardcore")) {
                displayNameComponent = Component.translatable("selectWorld.gameMode.hardcore").append(Component.literal(" ")).append(displayNameComponent);
            }

            this.displayName = displayNameComponent;

            // Info Component
            MutableComponent infoComponent = Component.translatable("selectWorld.gameMode.adventure.info");

            if (stringGameMode.equals("hardcore")) {
                infoComponent = infoComponent.append(Component.literal("\n\n")).append(Component.translatable("selectWorld.gameMode.hardcore.info"));
            }

            infoComponent = infoComponent.append(Component.literal("\n\n")).append(Component.translatable("selectWorld.gameMode.survival.info"));

            this.info = infoComponent;
        }
    }
}
