package itsu.java.minecraftbeclient.level;

import itsu.java.minecraftbeclient.block.Block;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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
        return null;//this.get
    }

    public String getName() {
        return name;
    }

}
