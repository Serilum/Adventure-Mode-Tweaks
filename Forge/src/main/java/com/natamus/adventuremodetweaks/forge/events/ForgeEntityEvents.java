package com.natamus.adventuremodetweaks.forge.events;

import com.natamus.adventuremodetweaks.events.EntityEvents;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeEntityEvents {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeEntityEvents.class);
	}

	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		EntityEvents.onEntityJoin(e.getLevel(), e.getEntity());
	}

	@SubscribeEvent
	public static boolean onEntityInteract(PlayerInteractEvent.EntityInteract e) {
		if (!EntityEvents.onEntityInteract(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null)) {
            return true;
        }
		return false;
	}
}
