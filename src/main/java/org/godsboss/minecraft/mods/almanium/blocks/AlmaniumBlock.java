package org.godsboss.minecraft.mods.almanium.blocks;

import org.godsboss.minecraft.mods.almanium.AlmaniumMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AlmaniumBlock extends Block {
	public AlmaniumBlock() {
		super(Material.IRON);
		super.
			setSoundType(SoundType.METAL).
			setHardness(5.0F).
			setResistance(10.0F).
			setRegistryName(AlmaniumMod.Blocks.AlmaniumBlockName).
			setUnlocalizedName(AlmaniumMod.Blocks.AlmaniumBlockName).
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
