package com.mod.items;

import com.mod.mmorpgMod.MMORPGZanckorMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MMORPGZanckorMod.MOD_ID);
	
	
	public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", 
			() -> new Item(new Item.Properties()
					.tab(ItemGroup.TAB_COMBAT)
					.fireResistant()
					.setNoRepair()));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
