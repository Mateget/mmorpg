package com.mod.mmorpgmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mod.capabilities.MyCapability;
import com.mod.capabilities.MyCapabilityImplementation;
import com.mod.capabilities.MyCapabilityStorage;
import com.mod.items.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mmorpg")
public class MMORPGZanckorMod {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "mmorpg";

	public MMORPGZanckorMod() {
    	IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	ItemInit.ITEMS.register(eventBus);
    	
        MinecraftForge.EVENT_BUS.register(this);
        
        
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void onCommonSetup(FMLCommonSetupEvent event) {
	    CapabilityManager.INSTANCE.register(MyCapability.class, new MyCapabilityStorage(), MyCapabilityImplementation::new);
	}
}
