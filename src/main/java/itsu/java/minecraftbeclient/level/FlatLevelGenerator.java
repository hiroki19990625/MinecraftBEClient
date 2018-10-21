package itsu.java.minecraftbeclient.level;

import itsu.java.minecraftbeclient.block.blocks.Grass;

public class FlatLevelGenerator extends LevelGenerator {

    @Override
    public void generateLevel(Level level) {
        for (int x = 0; x < 128; x++) {
            for (int z = 0; z < 128; z++) {
                Grass grass = new Grass(x, 0, z, level);
                level.setBlock(grass);
            }
        }
    }
}
