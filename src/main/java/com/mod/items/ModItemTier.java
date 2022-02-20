package com.mod.items;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ModItemTier implements IItemTier {
	
	//Level - Uses - Speed - Damage - Enchant - Repair
	
	DARK_IRON(4, 2000, 0F, 400.0F, 15, () -> {
	      return Ingredient.of(Items.IRON_INGOT);
	   });
	  

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyValue<Ingredient> repairIngredient;

	private ModItemTier(int level, int uses, float speed, float damage, int enchant,
			Supplier<Ingredient> repairMaterial) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchant;
		this.repairIngredient = new LazyValue<>(repairMaterial);
	}


	public int getUses() {
		return this.uses;
	}

	public float getSpeed() {
		return this.speed;
	}

	public float getAttackDamageBonus() {
		return this.damage;
	}

	public int getLevel() {
		return this.level;
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
}