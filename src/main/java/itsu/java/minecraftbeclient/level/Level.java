package itsu.java.minecraftbeclient.level;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.level.generator.FlatLevelGenerator;
import itsu.java.minecraftbeclient.math.MinecraftBEMath;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Level extends Group {

    private String name;

    public Level(String name) {
        this.name = name;

        AmbientLight ambientLight = new AmbientLight(Color.rgb(100,100,100));
        this.getChildren().add(ambientLight);

        PointLight pointLight = new PointLight(Color.WHITE);
        pointLight.setTranslateX(240);
        pointLight.setTranslateY(0);
        pointLight.setTranslateZ(-250);
        this.getChildren().add(pointLight);

        new FlatLevelGenerator().generateLevel(this);
    }

    public void setBlock(Block block) {
        this.getChildren().add(block);
    }

    public void removeBlock(Block block) {
        this.getChildren().remove(block);
    }

    public Block getBlock(double x, double y, double z) {

        return null;
    }

    public String getName() {
        return name;
    }

    public Block[] getCollisionBlocks(Block block) {
        int minX = MinecraftBEMath.floorDouble(this.getBoundsInParent().getMinX());
        int minY = MinecraftBEMath.floorDouble(this.getBoundsInParent().getMinY());
        int minZ = MinecraftBEMath.floorDouble(this.getBoundsInParent().getMinZ());
        int maxX = MinecraftBEMath.ceilDouble(this.getBoundsInParent().getMaxX());
        int maxY = MinecraftBEMath.ceilDouble(this.getBoundsInParent().getMaxY());
        int maxZ = MinecraftBEMath.ceilDouble(this.getBoundsInParent().getMaxZ());

        List<Block> collides = new ArrayList<>();

        /*
        for (int z = minZ; z <= maxZ; ++z) {
            for (int x = minX; x <= maxX; ++x) {
                for (int y = minY; y <= maxY; ++y) {
                    Block block = this.getBlock(this.temporalVector.setComponents(x, y, z));
                    if (block.getBlockId() != 0 && block.collidesWithBB(bb)) {
                        collides.add(block);
                    }
                }
            }
        }*/
        return null;
    }

}
