package com.mod.classes;

import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class DarkIronSword extends SwordItem {

	public DarkIronSword(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
		super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
	}

	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {

		if (Screen.hasShiftDown()) {
			tooltip.add(
					new StringTextComponent(TextFormatting.DARK_AQUA + "Max Uses - " + TextFormatting.AQUA + "2000"));
			tooltip.add(new StringTextComponent(TextFormatting.DARK_AQUA + "Speed - " + TextFormatting.AQUA + "3"));
			tooltip.add(new StringTextComponent(TextFormatting.DARK_AQUA + "Damage - " + TextFormatting.AQUA + "400"));
			tooltip.add(
					new StringTextComponent(TextFormatting.DARK_AQUA + "EnchantLevel - " + TextFormatting.AQUA + "15"));
			tooltip.add(new StringTextComponent(
					TextFormatting.DARK_AQUA + "Repair Item - " + TextFormatting.AQUA + "Iron Ingot"));
		} else {
			tooltip.add(new StringTextComponent(
					"Press" + TextFormatting.GOLD + " SHIFT " + TextFormatting.RESET + "to see more information"));
		}

		super.appendHoverText(stack, world, tooltip, flag);
	}
	
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		entity.setSprinting(false);
		
		return super.onEntityItemUpdate(stack, entity);
	}
}
