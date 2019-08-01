package org.godsboss.minecraft.mods.almanium.items;

import org.godsboss.minecraft.mods.almanium.AlmaniumMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class Axe extends ItemAxe {
	public Axe() {
		super(Item.ToolMaterial.IRON);
		super.
			setRegistryName(AlmaniumMod.Items.AlmaniumAxeName).
			setUnlocalizedName(AlmaniumMod.Items.AlmaniumAxeName);
	}
}
