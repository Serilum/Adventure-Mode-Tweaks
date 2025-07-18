package com.natamus.adventuremodetweaks.forge.events;

import com.natamus.adventuremodetweaks.events.BlockEvents;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeBlockEvents {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeBlockEvents.class);

		PlayerInteractEvent.RightClickBlock.BUS.addListener(ForgeBlockEvents::onRightClickBlock);
	}

	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock e) {
		BlockEvents.onRightClickBlock(e.getLevel(), e.getEntity(), e.getHand(), e.getPos(), e.getHitVec());
	}
}
