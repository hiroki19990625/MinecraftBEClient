package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.block.BlockManager;
import itsu.java.minecraftbeclient.block.TextureManager;
import itsu.java.minecraftbeclient.level.Level;
import itsu.java.minecraftbeclient.utils.Version;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        BlockManager.registerBlocks();
        TextureManager.init();

        Level level = new Level("Test");
        GameServer.setLevel(level);

        Group group = new Group();
        group.getChildren().add(level);

        scene = new Scene(group, 1024, 768, true, SceneAntialiasing.BALANCED);
        scene = WindowSetting.settingWindow(scene, level);

        primaryStage.setTitle("MinecraftBE Client v" + Version.VERSION + " - " + level.getName());
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
