package itsu.java.minecraftbeclient.level;

import itsu.java.minecraftbeclient.block.Block;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Level extends Group {

    private String name;

    public Level(String name) {
        this.name = name;

        new FlatLevelGenerator().generateLevel(this);
    }

    public void setBlock(Block block) {
        this.getChildren().add(block);
    }

    public void removeBlock(Block block) {
        this.getChildren().remove(block);
    }

    public Block getBlock(double x, double y, double z) {
        return null;//this.get
    }

    public String getName() {
        return name;
    }

}
