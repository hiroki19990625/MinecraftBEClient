package itsu.java.minecraftbeclient.level;

import itsu.java.minecraftbeclient.block.Stone;
import javafx.geometry.Point3D;
import javafx.scene.shape.Box;

public class FlatLevelGenerator extends LevelGenerator {

    @Override
    public void generateLevel(Level level) {
        for (int x = 0; x < 100; x++) {
            for (int z = 0; z < 100; z++) {
                Stone stone = new Stone(x, 0, z, level);
                level.setBlock(stone);
            }
        }
    }
}
