package itsu.java.minecraftbeclient.event;

import itsu.java.minecraftbeclient.core.Main;
import javafx.scene.input.KeyEvent;

public class KeyboardEvent {

    public static void keyPressed(KeyEvent event) {
        Main.getController().keyPressed(event);
    }
}
