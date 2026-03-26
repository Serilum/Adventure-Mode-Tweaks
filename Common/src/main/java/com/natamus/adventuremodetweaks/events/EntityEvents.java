package com.natamus.adventuremodetweaks.events;

import com.natamus.adventuremodetweaks.config.ConfigHandler;
import com.natamus.adventuremodetweaks.features.*;
import com.natamus.adventuremodetweaks.util.Util;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

@SuppressWarnings("RedundantIfStatement")
public class EntityEvents {
    public static void onEntityJoin(Level level, Entity entity) {
        if (!ConfigHandler.forceSurvivalToAdventureMode) {
            return;
        }

        if (level.isClientSide()) {
            return;
        }

        if (!(entity instanceof ServerPlayer serverPlayer)) {
            return;
        }

        GameType gameType = serverPlayer.gameMode.getGameModeForPlayer();
        if (gameType.equals(GameType.SURVIVAL)) {
            serverPlayer.setGameMode(GameType.ADVENTURE);
        }
    }

    public static boolean onEntityAttack(ServerPlayer serverPlayer, Level level, Entity targetEntity) {
        if (!Util.serverIsInAdventureMode(serverPlayer)) {
            return true;
        }

        if (GeneralAttackCheck.shouldBlockEntityDamage(targetEntity)) {
            return false;
        }

        if (BoatCheck.targetIsBoatAndShouldBeBlocked(targetEntity)) {
            return false;
        }

        if (MinecartCheck.targetIsMinecartAndShouldBeBlocked(targetEntity)) {
            return false;
        }

        if (PaintingCheck.targetIsPaintingAndShouldBeBlocked(targetEntity)) {
            return false;
        }

        if (ItemFrameCheck.targetIsItemFrameAndShouldBeBlocked(targetEntity)) {
            return false;
        }

        if (LeadCheck.entityIsLeashKnotAndShouldBeBlocked(targetEntity)) {
            return false;
        }

        return true;
    }

    public static boolean onEntityInteract(Player player, Level level, InteractionHand interactionHand, Entity targetEntity, EntityHitResult hitResult) {
        if (!Util.isInAdventureMode(player)) {
            return true;
        }

        if (ConfigHandler.preventEntityInteraction) {
            return false;
        }

        if (CowCheck.entityIsCowAndMilkingShouldBeBlocked(targetEntity)) {
            return false;
        }

        if (SheepCheck.entityIsSheepAndShearingShouldBeBlocked(targetEntity)) {
            return false;
        }

        if (LeadCheck.entityIsLeashKnotAndShouldBeBlocked(targetEntity)) {
            return false;
        }

        ItemStack handStack = player.getItemInHand(interactionHand);
        Item handItem = handStack.getItem();
        if (LeadCheck.itemUsedIsALeadAndShouldBeBlocked(handItem)) {
            return false;
        }

        return true;
    }
}
