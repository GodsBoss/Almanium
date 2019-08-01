package org.godsboss.minecraft.mods.almanium.items;

import org.godsboss.minecraft.mods.almanium.AlmaniumMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class Shovel extends ItemSpade {
	public Shovel() {
		super(Item.ToolMaterial.IRON);
		super.
			setRegistryName(AlmaniumMod.Items.AlmaniumShovelName).
			setUnlocalizedName(AlmaniumMod.Items.AlmaniumShovelName);
	}
}
