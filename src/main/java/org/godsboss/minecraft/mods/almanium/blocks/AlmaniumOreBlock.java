package org.godsboss.minecraft.mods.almanium.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class AlmaniumOreBlock extends BlockOre {
	public AlmaniumOreBlock(String name) {
		super();
		super.
			setSoundType(SoundType.STONE).
			setHardness(3.0F).
			setResistance(5.0F).
			setRegistryName(name).
			setUnlocalizedName(name).
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
