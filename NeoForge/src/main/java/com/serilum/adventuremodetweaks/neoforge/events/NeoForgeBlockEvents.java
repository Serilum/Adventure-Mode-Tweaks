package com.serilum.adventuremodetweaks.neoforge.events;

import com.serilum.adventuremodetweaks.events.BlockEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class NeoForgeBlockEvents {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock e) {
		BlockEvents.onRightClickBlock(e.getLevel(), e.getEntity(), e.getHand(), e.getPos(), e.getHitVec());
	}
}
