package itsu.java.minecraftbeclient.controller;

import itsu.java.minecraftbeclient.block.BlockManager;
import itsu.java.minecraftbeclient.core.GameServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    private ListView inventoryList;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        inventoryList.setOnMouseClicked((MouseEvent)->{
            Object obj = inventoryList.getSelectionModel().getSelectedItem();
            String text = String.valueOf(obj);
            String[] data = text.split(" - ")[0].split(":");
            System.out.println(obj);

            GameServer.setBlockId(Integer.parseInt(data[0]));
            GameServer.setBlockMeta(Integer.parseInt(data[1]));

            stage.close();
        });

        loadBlocks();
    }

    public void loadBlocks() {
        ObservableList<String> items = FXCollections.observableArrayList(BlockManager.getBlocks());
        inventoryList.setItems(items);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
