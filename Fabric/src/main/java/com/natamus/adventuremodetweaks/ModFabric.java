package com.natamus.adventuremodetweaks;

import com.natamus.adventuremodetweaks.events.BlockEvents;
import com.natamus.adventuremodetweaks.events.EntityEvents;
import com.natamus.adventuremodetweaks.util.Reference;
import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		ServerEntityEvents.ENTITY_LOAD.register((entity, level) -> {
			EntityEvents.onEntityJoin(level, entity);
		});

		UseBlockCallback.EVENT.register((player, level, interactionHand, blockHitResult) -> {
			if (!BlockEvents.onRightClickBlock(level, player, interactionHand, blockHitResult.getBlockPos(), blockHitResult)) {
				return InteractionResult.FAIL;
			}
			return InteractionResult.PASS;
		});

		UseEntityCallback.EVENT.register((player, level, hand, entity, hitResult) -> {
			if (!EntityEvents.onEntityInteract(player, level, hand, entity, hitResult)) {
				return InteractionResult.FAIL;
			}
			return InteractionResult.PASS;
		});
	}

	private static void setGlobalConstants() {

	}
}
