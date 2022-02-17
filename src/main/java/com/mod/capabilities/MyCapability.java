package com.mod.capabilities;

import net.minecraft.nbt.CompoundNBT;

public interface MyCapability {
	
	int getMana();

	void setMana(int value);

	CompoundNBT serializeNBT();

	void deserializeNBT(CompoundNBT nbt);
}
