package itsu.java.minecraftbeclient.block;

import itsu.java.minecraftbeclient.core.TextureManager;
import itsu.java.minecraftbeclient.event.EventManager;
import itsu.java.minecraftbeclient.level.Level;
import itsu.java.minecraftbeclient.utils.Texture;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Box;
import javafx.util.Duration;

public abstract class Block extends Box {

    private int id;
    private double x;
    private double y;
    private double z;

    private String name;

    private Texture texture;
    private Level level;

    public abstract boolean isFallable();

    public Block(int id, double x, double y, double z, String name, Level level) {
        super(10, 10, 10);

        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
        this.level = level;
        this.texture = TextureManager.getTexture(id);

        this.setRotationAxis(new Point3D(0, 1, 0));
        this.setMaterial(texture);

        this.setTranslateX(x * 10);
        this.setTranslateY(y * 10);
        this.setTranslateZ(z * 10);

        startTick();

        this.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) EventManager.onBlockLeftClick(this, level);
            else if (event.getButton() == MouseButton.SECONDARY) EventManager.onBlockRightClick(this, level);
        });
    }

    private void startTick() {
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if (isFallable()) {
                    level.removeBlock(Block.this);

                    setY(Block.this.getY() + 1);
                    level.setBlock(Block.this);

                    if (getY() > 50) {
                        level.removeBlock(Block.this);
                    }
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
        this.setTranslateX(x * 10);
    }

    public void setY(double y) {
        this.y = y;
        this.setTranslateY(y * 10);
    }

    public void setZ(double z) {
        this.z = z;
        this.setTranslateZ(z * 10);
    }

    public int getBlockId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
