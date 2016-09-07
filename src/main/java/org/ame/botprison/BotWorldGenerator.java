package org.ame.botprison;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;

public class BotWorldGenerator extends ChunkGenerator {
    @Override
    public boolean canSpawn(World world, int x, int z) {
        return true;
    }

    @Override
    public ChunkGenerator.ChunkData generateChunkData(World world, Random random, int x, int z, ChunkGenerator.BiomeGrid biomes) {
        ChunkGenerator.ChunkData chunkData = createChunkData(world);
        for (int x_pos = 0; x_pos < 16; x_pos++) {
            for (int z_pos = 0; z_pos < 16; z_pos++) {
                chunkData.setBlock(x_pos, 0, z_pos, Material.BEDROCK);
            }
        }
        return chunkData;
    }
}
