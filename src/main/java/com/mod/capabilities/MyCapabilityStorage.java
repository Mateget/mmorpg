package com.mod.capabilities;

import javax.annotation.Nonnull;

import com.google.common.base.Supplier;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.Lazy;

public class MyCapabilityStorage<S extends INBT, C extends INBTSerializable<S>> implements Capability.IStorage<C> {
	private final Lazy<Capability<C>> capability;
	private final int expectedTagType;

	public MyCapabilityStorage(final int expectedTagType, @Nonnull final Lazy<Capability<C>> capability) {
		this.expectedTagType = expectedTagType;
		this.capability = capability;
	}

	public MyCapabilityStorage() {
		this.capability = null;
		this.expectedTagType = 0;
	}

	@Nonnull
	public static <S extends INBT, C extends INBTSerializable<S>> MyCapabilityStorage<S, C> create(@Nonnull final Supplier<Capability<C>> capability) {
		return create(capability, -1);
	}

	@Nonnull
	public static <S extends INBT, C extends INBTSerializable<S>> MyCapabilityStorage<S, C> create(
			final Supplier<Capability<C>> capability, final int expectedTagType) {
		return new MyCapabilityStorage<>(expectedTagType, Lazy.of(capability));
	}

	@Override
	public INBT writeNBT(Capability<C> capability, C instance, Direction side) {
		if (capability != this.capability.get())
			return null;
		return instance.serializeNBT();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void readNBT(Capability<C> capability, C instance, Direction side, INBT nbt) {
		if (capability != this.capability.get())
			return;
		if (this.expectedTagType != -1 && nbt.getId() != this.expectedTagType) {
			throw new IllegalStateException("The NBT type " + nbt.getClass().getSimpleName()
					+ " is not suitable for the capability " + capability);
		}
		instance.deserializeNBT((S) nbt);

	}
}