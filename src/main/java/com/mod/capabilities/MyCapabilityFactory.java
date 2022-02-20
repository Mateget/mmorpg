package com.mod.capabilities;

public class MyCapabilityFactory implements IMyCapability{

	private int mana = 0;
	
	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public void setMana(int mana) {
		this.mana = mana;
	}

}
