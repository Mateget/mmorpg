package com.mod.capabilities;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class MyCapabilityStorage implements Capability.IStorage<IMyCapability>{

	@Override
	public INBT writeNBT(Capability<IMyCapability> capability, IMyCapability instance,
			Direction side) {
		CompoundNBT nbt = new CompoundNBT();
		
		nbt.putInt("mana", instance.getMana());
		
		return nbt;
	}

	@Override
	public void readNBT(Capability<IMyCapability> capability, IMyCapability instance,
			Direction side, INBT nbt) {
		CompoundNBT nbt2 = (CompoundNBT) nbt;
		
		instance.setMana(nbt2.getInt("mana"));
	}

}
