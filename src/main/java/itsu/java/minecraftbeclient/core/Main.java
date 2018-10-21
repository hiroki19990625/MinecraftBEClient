package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.block.BlockManager;
import itsu.java.minecraftbeclient.level.Level;
import itsu.java.minecraftbeclient.utils.Version;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {

    private static Controller controller;
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MinecraftBEClient.fxml"));
        Parent parent = loader.load();

        controller = loader.getController();

        BlockManager.registerBlocks();

        controller.loadBlocks();

        Level level = new Level("Test");
        controller.setLevel(level);
        GameServer.setLevel(level);

        Group group = new Group();
        group.getChildren().add(level);

        scene = new Scene(group, 1024, 768, true, SceneAntialiasing.BALANCED);
        scene = WindowSetting.settingWindow(scene);

        controller.addChat("MinecraftBE Client v" + Version.VERSION + " - " + level.getName());

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

    public static Controller getController() {
        return controller;
    }
}
