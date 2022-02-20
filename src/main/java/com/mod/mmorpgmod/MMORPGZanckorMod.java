package com.mod.mmorpgmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mod.capabilities.Capabilities;
import com.mod.items.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mmorpg")
public class MMORPGZanckorMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "mmorpg";

	private void setup(final FMLCommonSetupEvent event) {
        Capabilities.register();
	}
	
	public MMORPGZanckorMod() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(eventBus);

		MinecraftForge.EVENT_BUS.register(this);

		MinecraftForge.EVENT_BUS.register(new Capabilities());

	}
}
