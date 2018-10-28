package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.block.blocks.Stone;
import itsu.java.minecraftbeclient.controller.InventoryController;
import itsu.java.minecraftbeclient.level.Level;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowSetting {

    private static double initX;
    private static double initY;

    private static double radiusX;
    private static double radiusY;

    private static Rotate rotateX;
    private static Rotate rotateY;
    private static Translate translate;

    private static final double strength = 0.1;
    private static final int speed = 7;

    public static Scene settingWindow(Scene scene, Level level) {
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(100);
        camera.setTranslateX(200);
        camera.setTranslateY(-20);
        camera.setFarClip(10000);
        camera.setNearClip(0.1);
        camera.setFieldOfView(50);

        camera.getTransforms().addAll(
                rotateX = new Rotate(0.0, Rotate.X_AXIS),
                rotateY = new Rotate(0.0, Rotate.Y_AXIS),
                translate = new Translate(5, -5, -15)
        );

        scene.setCamera(camera);

        scene.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        initX = event.getSceneX();
                        initY = event.getSceneY();

                        radiusX = rotateX.getAngle();
                        radiusY = rotateY.getAngle();
                    }
                }
        );

        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        double x = event.getSceneX();
                        double y = event.getSceneY();

                        rotateX.setAngle(radiusX -= (initY - y) * -strength);
                        rotateY.setAngle(radiusY -= (initX - x) * -strength);

                        initX = event.getSceneX();
                        initY = event.getSceneY();
                    }
                }

        );
        
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                level.setTranslateZ(level.getTranslateZ() - speed);

            } else if (e.getCode() == KeyCode.S) {
                level.setTranslateZ(level.getTranslateZ() + speed);

            } else if (e.getCode() == KeyCode.D) {
                level.setTranslateX(level.getTranslateX() - speed);

            } else if (e.getCode() == KeyCode.A) {
                level.setTranslateX(level.getTranslateX() + speed);

            } else if (e.getCode() == KeyCode.SHIFT) {
                level.setTranslateY(level.getTranslateY() - speed);

            } else if (e.getCode() == KeyCode.SPACE) {
                level.setTranslateY(level.getTranslateY() + speed);

            } else if (e.getCode() == KeyCode.E) {
                try {
                    FXMLLoader loader = new FXMLLoader(WindowSetting.class.getClassLoader().getResource("Inventory.fxml"));
                    Parent parent = loader.load();

                    Scene scene1 = new Scene(parent);
                    Stage stage = new Stage();

                    InventoryController controller = (InventoryController) loader.getController();
                    controller.setStage(stage);

                    stage.setScene(scene1);
                    stage.showAndWait();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Stop[] stops = new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(0.5, Color.web("71afec")),
                new Stop(1, Color.web("2454a0"))
        };

        LinearGradient sky = new LinearGradient(0, 400, 0, 0, false, CycleMethod.NO_CYCLE, stops);
        scene.setFill(Color.rgb(157, 204, 224));

        return scene;
    }
}
