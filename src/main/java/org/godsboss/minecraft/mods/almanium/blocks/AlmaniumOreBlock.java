package org.godsboss.minecraft.mods.almanium.blocks;

import org.godsboss.minecraft.mods.almanium.AlmaniumMod;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class AlmaniumOreBlock extends BlockOre {
	public AlmaniumOreBlock() {
		super();
		super.
			setSoundType(SoundType.STONE).
			setHardness(3.0F).
			setResistance(5.0F).
			setRegistryName(AlmaniumMod.Blocks.AlmaniumOreBlockName).
			setUnlocalizedName(AlmaniumMod.Blocks.AlmaniumOreBlockName).
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
