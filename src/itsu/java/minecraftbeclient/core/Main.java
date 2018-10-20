package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.level.Level;
import itsu.java.minecraftbeclient.utils.Version;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Main extends Application {

    static double initX;
    static double initY;
    final double strength = 0.1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("MinecraftBEClient.fxml"));
        TextureManager.init();

        Level level = new Level("Test");

        Stop[] stops = new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(0.5, Color.web("71afec")),
                new Stop(1, Color.web("2454a0"))
        };

        LinearGradient sky = new LinearGradient(0, 400, 0, 0, false, CycleMethod.NO_CYCLE, stops);

        Scene scene = new Scene(level, 320, 320, true, SceneAntialiasing.BALANCED);
        scene.setFill(sky);

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-100);
        camera.setTranslateX(500);
        camera.setFarClip(1000);
        scene.setCamera(camera);

        Rotate rotateY = new Rotate(0.0, Rotate.Y_AXIS);
        Rotate rotateX = new Rotate(0.0, Rotate.X_AXIS);
        level.getTransforms().addAll(rotateX, rotateY);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                camera.setTranslateZ(camera.getTranslateZ() + 1);
                camera.setTranslateZ(camera.getTranslateZ() + 1);

            } else if (e.getCode() == KeyCode.S) {
                camera.setTranslateZ(camera.getTranslateZ() - 1);
                camera.setTranslateZ(camera.getTranslateZ() - 1);

            } else if (e.getCode() == KeyCode.D) {
                camera.setTranslateX(camera.getTranslateX() + 1);
                camera.setTranslateX(camera.getTranslateX() + 1);

            } else if (e.getCode() == KeyCode.A) {
                camera.setTranslateX(camera.getTranslateX() - 1);
                camera.setTranslateX(camera.getTranslateX() - 1);

            } else if (e.getCode() == KeyCode.SHIFT) {
                camera.setTranslateY(camera.getTranslateY() + 1);
                camera.setTranslateY(camera.getTranslateY() + 1);

            } else if (e.getCode() == KeyCode.SPACE) {
                camera.setTranslateY(camera.getTranslateY() - 1);
                camera.setTranslateY(camera.getTranslateY() - 1);

            }
        });

        scene.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        initX = event.getSceneX();
                        initY = event.getSceneY();
                    }
                }
        );

        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        double x = event.getSceneX();
                        double y = event.getSceneY();
                        rotateX.setAngle(rotateX.getAngle() + (y - initY) * strength);
                        rotateY.setAngle(rotateY.getAngle() + (initX - x) * strength);

                        initX = x;
                        initY = y;
                    }
                }

        );

        primaryStage.setTitle("MinecraftBE Client v" + Version.VERSION + " - " + level.getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
