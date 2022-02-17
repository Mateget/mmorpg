package com.mod.items;

import com.mod.classes.DarkIronSword;
import com.mod.creativeTabs.ModItemGroup;
import com.mod.mmorpgmod.MMORPGZanckorMod;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MMORPGZanckorMod.MOD_ID);
	
	
	
	public static final RegistryObject<Item> WoodWand = ITEMS.register("woodwand", () -> new WoodWandItem(new Item.Properties()
			.setNoRepair()
			.tab(ModItemGroup.MMORPGItems)));
	
	
	public static final RegistryObject<Item> DARK_IRON_SWORD = ITEMS.register("dark_iron_sword",
			() -> new DarkIronSword(ModItemTier.DARK_IRON, 1, -2f, new Item.Properties()
			.tab(ModItemGroup.MMORPGItems)));
	

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
