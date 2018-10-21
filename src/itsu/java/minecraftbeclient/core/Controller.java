package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.block.BlockManager;
import itsu.java.minecraftbeclient.level.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    private static double initX;
    private static double initY;

    private static double radiusX;
    private static double radiusY;

    private Rotate rotateX;
    private Rotate rotateY;
    private Translate translate;

    private final double strength = 0.2;
    private final int speed = 7;

    @FXML private TextArea chatArea;

    @FXML private ListView inventoryList;

    @FXML private StackPane levelStack;

    private SubScene levelScene;

    public void addChat(String text) {
        chatArea.appendText(text + "\n");
    }

    public void setLevel(Level level) {
        Stop[] stops = new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(0.5, Color.web("71afec")),
                new Stop(1, Color.web("2454a0"))
        };

        LinearGradient sky = new LinearGradient(0, 400, 0, 0, false, CycleMethod.NO_CYCLE, stops);

        levelScene = new SubScene(level, 1000, 500, false, SceneAntialiasing.BALANCED);

        //levelStack.setBackground(new Background(new BackgroundFill(sky, CornerRadii.EMPTY, Insets.EMPTY)));

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-100);
        camera.setTranslateX(500);
        camera.setFarClip(10000);

        camera.getTransforms().addAll(
                rotateX = new Rotate(0.0, Rotate.X_AXIS),
                rotateY = new Rotate(0.0, Rotate.Y_AXIS),
                translate = new Translate(5, -5, -15)
        );

        levelScene.setCamera(camera);
        levelScene.setRoot(level);

        levelStack.addEventHandler(MouseEvent.MOUSE_PRESSED,
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

        levelStack.addEventHandler(MouseEvent.MOUSE_DRAGGED,
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

        inventoryList.setOnMouseClicked((MouseEvent)->{
            Object obj = inventoryList.getSelectionModel().getSelectedItem();
            String text = String.valueOf(obj);
            String[] data = text.split(" - ")[0].split(":");
            System.out.println(obj);

            GameServer.setBlockId(Integer.parseInt(data[0]));
            GameServer.setBlockMeta(Integer.parseInt(data[1]));
        });

        level.getTransforms().addAll(rotateX, rotateY);

        levelStack.getChildren().add(levelScene);
        levelScene.heightProperty().bind(levelStack.heightProperty());
        levelScene.widthProperty().bind(levelStack.widthProperty());
    }

    public void loadBlocks() {
        ObservableList<String> items = FXCollections.observableArrayList(BlockManager.getBlocks());
        inventoryList.setItems(items);
    }

    public void keyPressed(KeyEvent e) {
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

        } else if (e.getCode() == KeyCode.E) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
                Parent parent = loader.load();

                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
