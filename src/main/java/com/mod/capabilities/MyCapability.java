package com.mod.capabilities;

public class MyCapability implements MyCapabilityImplementation{

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
