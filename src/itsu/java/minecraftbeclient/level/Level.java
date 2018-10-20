package itsu.java.minecraftbeclient.level;

import itsu.java.minecraftbeclient.block.Block;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Level extends Group {

    private String name;

    public Level(String name) {
        this.name = name;

        AmbientLight ambientLight = new AmbientLight(Color.rgb(50,50,50));
        this.getChildren().add(ambientLight);

        new FlatLevelGenerator().generateLevel(this);
    }

    public void setBlock(Block block) {
        this.getChildren().add(block);
    }

    public void removeBlock(Block block) {
        this.getChildren().remove(block);
    }

    public String getName() {
        return name;
    }

}
