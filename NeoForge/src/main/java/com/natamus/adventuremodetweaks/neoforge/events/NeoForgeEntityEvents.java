package com.natamus.adventuremodetweaks.neoforge.events;

import com.natamus.adventuremodetweaks.events.EntityEvents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class NeoForgeEntityEvents {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		EntityEvents.onEntityJoin(e.getLevel(), e.getEntity());
	}

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific e) {
		if (!EntityEvents.onEntityInteract(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null)) {
            e.setCanceled(true);
        }
	}
}