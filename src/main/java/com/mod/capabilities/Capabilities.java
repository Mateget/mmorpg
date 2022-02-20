package com.mod.capabilities;

import com.mod.mmorpgmod.MMORPGZanckorMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Capabilities {
	@CapabilityInject(MyCapabilityImplementation.class)
	public static final Capability<MyCapabilityImplementation> PLAYER_CAPABILITIES = null;
	
	public static MyCapabilityImplementation getPlayer(PlayerEntity player) {
		LazyOptional<MyCapabilityImplementation> playerData = player.getCapability(Capabilities.PLAYER_CAPABILITIES, null);
		return playerData.orElse(null);
	}
	
	public static void register() {
		CapabilityManager.INSTANCE.register(MyCapabilityImplementation.class, new MyCapabilityStorage(), MyCapability::new);
	}
	
	@SubscribeEvent
	public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof PlayerEntity)
				event.addCapability(new ResourceLocation(MMORPGZanckorMod.MOD_ID, "capabilities"), new MyCapabilityProvider());
		}
}
