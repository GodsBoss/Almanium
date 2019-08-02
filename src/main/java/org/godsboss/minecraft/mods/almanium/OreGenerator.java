package org.godsboss.minecraft.mods.almanium;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {
	public final static int DimensionNether = -1;
	public final static int DimensionOverworld = 0;
	public final static int DimensionEnd = 1;

	public final static int chancesToSpawn = 6;
	public final static int blockAmount = 10;

	private final WorldGenMinable netherOreGenerator = new WorldGenMinable(
		AlmaniumMod.Blocks.AlmaniumNetherrackOreBlock.getDefaultState(),
		blockAmount,
		BlockMatcher.forBlock(Blocks.NETHERRACK)
	);
	private final WorldGenMinable overworldOreGenerator = new WorldGenMinable(
		AlmaniumMod.Blocks.AlmaniumOreBlock.getDefaultState(),
		blockAmount
	);

	public void generate(
		Random random,
		int chunkX,
		int chunkZ,
		World world,
		IChunkGenerator chunkGenerator,
		IChunkProvider chunkProvider
	) {
		switch (world.provider.getDimension()) {
		case DimensionNether:
			runGenerator(netherOreGenerator, 10, 118, world, random, chunkX, chunkZ);
			break;
		case DimensionOverworld:
			runGenerator(overworldOreGenerator, 10, 64, world, random, chunkX, chunkZ);
			break;
		default:
			break;
		}
	}

	private void runGenerator(
		WorldGenMinable generator,
		int minHeight,
		int maxHeight,
		World world,
		Random random,
		int chunkX,
		int chunkZ
	) {
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			generator.generate(
				world,
				random,
				new BlockPos(
					chunkX * 16 +random.nextInt(16),
					minHeight + random.nextInt(heightDiff),
					chunkZ * 16 + random.nextInt(16)
				)
			);
		}
	}
}
