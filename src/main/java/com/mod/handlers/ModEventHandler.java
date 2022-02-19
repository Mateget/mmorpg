package com.mod.handlers;

import com.mod.capabilities.Capabilities;
import com.mod.classes.DarkIronSword;
import com.mod.items.WoodWandItem;
import com.mod.mmorpgmod.MMORPGZanckorMod;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MMORPGZanckorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventHandler {

	@SubscribeEvent
	public static void pickupItem(EntityItemPickupEvent e) {
		System.out.println("Pickup item");
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent e) {
		PlayerEntity player = e.player;
		Item mainItem = player.getMainHandItem().getItem();

		if (mainItem instanceof DarkIronSword || mainItem instanceof WoodWandItem) {
			player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.07D);
			
			System.out.println(Capabilities.getPlayer(player).getMana());
			
		} else {
			player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1D);
		}
	}

	@SubscribeEvent
	public static void renderHand(RenderHandEvent e) {
		if (e.getItemStack().getItem() instanceof DarkIronSword) {
			e.setCanceled(true);
		}
	}
}
