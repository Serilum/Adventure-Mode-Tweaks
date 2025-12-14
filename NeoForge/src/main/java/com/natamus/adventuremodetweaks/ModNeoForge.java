package com.natamus.adventuremodetweaks;

import com.natamus.adventuremodetweaks.neoforge.config.IntegrateNeoForgeConfig;
import com.natamus.adventuremodetweaks.neoforge.events.NeoForgeBlockEvents;
import com.natamus.adventuremodetweaks.neoforge.events.NeoForgeEntityEvents;
import com.natamus.adventuremodetweaks.util.Reference;
import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	
	public ModNeoForge(IEventBus modEventBus) {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		modEventBus.addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		IntegrateNeoForgeConfig.registerScreen(ModLoadingContext.get());

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(NeoForgeBlockEvents.class);
		NeoForge.EVENT_BUS.register(NeoForgeEntityEvents.class);
	}

	private static void setGlobalConstants() {

	}
}