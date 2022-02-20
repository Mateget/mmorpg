package com.mod.creativeTabs;

import com.mod.items.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup{
	
	public static final ModItemGroup MMORPGItems = new ModItemGroup(ItemGroup.TABS.length, "mmorpg_item");

	public ModItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.WoodWand.get());
	}

}
