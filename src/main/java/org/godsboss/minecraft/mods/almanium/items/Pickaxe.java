package org.godsboss.minecraft.mods.almanium.items;

import org.godsboss.minecraft.mods.almanium.AlmaniumMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class Pickaxe extends ItemPickaxe {
	public Pickaxe() {
		super(Item.ToolMaterial.IRON);
		super.
			setRegistryName(AlmaniumMod.Items.AlmaniumPickaxeName).
			setUnlocalizedName(AlmaniumMod.Items.AlmaniumPickaxeName);
	}
}
