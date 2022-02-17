package com.mod.capabilities;

import net.minecraft.nbt.CompoundNBT;

public class MyCapabilityImplementation implements MyCapability {
	private int mana;

	public MyCapabilityImplementation() {
		this.mana(1);
	}
	
	private void mana(int i) {
		this.mana = i;
	}

	@Override
	public int getMana() {
		return this.mana;
	}

	@Override
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	
	@Override
	public CompoundNBT serializeNBT() {
		final CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("mana", this.getMana());
		return nbt;
	}
	
	@Override
	public void deserializeNBT(final CompoundNBT nbt) {
		this.setMana(nbt.getInt("mana"));
	}
}