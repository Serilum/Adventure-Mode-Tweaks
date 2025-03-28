package com.natamus.adventuremodetweaks;

import com.natamus.adventuremodetweaks.util.Reference;
import com.natamus.collective.check.ShouldLoadCheck;
import net.fabricmc.api.ClientModInitializer;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		registerEvents();
	}
	
	private void registerEvents() {

	}
}
