package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.level.Level;
import itsu.java.minecraftbeclient.utils.Version;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Main extends Application {

    private static double initX;
    private static double initY;

    private static double radiusX;
    private static double radiusY;

    private Rotate rotateX;
    private Rotate rotateY;
    private Translate translate;

    private final double strength = 0.2;
    private final int speed = 7;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("MinecraftBEClient.fxml"));
        TextureManager.init();

        Level level = new Level("Test");

        Scene scene = new Scene(level, 1024, 768, true, SceneAntialiasing.BALANCED);

        Stop[] stops = new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(0.5, Color.web("71afec")),
                new Stop(1, Color.web("2454a0"))
        };

        LinearGradient sky = new LinearGradient(0, 400, 0, 0, false, CycleMethod.NO_CYCLE, stops);

        scene.setFill(sky);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-100);
        camera.setTranslateX(500);
        camera.setFarClip(10000);

        camera.getTransforms().addAll(
                rotateX = new Rotate(0.0, Rotate.X_AXIS),
                rotateY = new Rotate(0.0, Rotate.Y_AXIS),
                translate = new Translate(5, -5, -15)
        );

        scene.setCamera(camera);

        level.getTransforms().addAll(rotateX, rotateY);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                translate.setZ(translate.getZ() + speed);

            } else if (e.getCode() == KeyCode.S) {
                translate.setZ(translate.getZ() - speed);

            } else if (e.getCode() == KeyCode.D) {
                translate.setX(translate.getX() + speed);

            } else if (e.getCode() == KeyCode.A) {
                translate.setX(translate.getX() - speed);

            } else if (e.getCode() == KeyCode.SHIFT) {
                translate.setY(translate.getY() + speed);

            } else if (e.getCode() == KeyCode.SPACE) {
                translate.setY(translate.getY() - speed);

            }
        });

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

                        rotateX.setAngle(radiusX -= (initY - y) * strength);
                        rotateY.setAngle(radiusY -= (initX - x) * strength);

                        initX = event.getSceneX();
                        initY = event.getSceneY();
                    }
                }

        );



        primaryStage.setTitle("MinecraftBE Client v" + Version.VERSION + " - " + level.getName());
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    protected double getRadian(double x, double y, double x2, double y2) {
        double radian = Math.atan2(y2 - y,x2 - x);
        return radian;
    }
}
