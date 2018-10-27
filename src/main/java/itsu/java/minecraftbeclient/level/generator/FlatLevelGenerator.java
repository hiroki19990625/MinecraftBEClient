package itsu.java.minecraftbeclient.level.generator;

import itsu.java.minecraftbeclient.block.blocks.Dirt;
import itsu.java.minecraftbeclient.block.blocks.Grass;
import itsu.java.minecraftbeclient.block.blocks.Stone;
import itsu.java.minecraftbeclient.level.Level;
import itsu.java.minecraftbeclient.level.generator.LevelGenerator;

public class FlatLevelGenerator extends LevelGenerator {

    @Override
    public void generateLevel(Level level) {
        for (int x = 0; x < 64; x++) {
            for (int z = 0; z < 64; z++) {
                for (int y = 2; y < 5; y++) {
                    Stone stone = new Stone(x, y, z, level);
                    level.setBlock(stone);
                }
            }
        }

        for (int x = 0; x < 64; x++) {
            for (int z = 0; z < 64; z++) {
                Dirt dirt = new Dirt(x, 1, z, level);
                level.setBlock(dirt);
            }
        }

        for (int x = 0; x < 64; x++) {
            for (int z = 0; z < 64; z++) {
                Grass grass = new Grass(x, 0, z, level);
                level.setBlock(grass);
            }
        }
    }
}
