package itsu.java.minecraftbeclient.block;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

import java.io.InputStream;

public class Texture extends PhongMaterial {

    public Texture(String textureName) {
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(textureName));
        this.setDiffuseColor(Color.BEIGE);
        this.setDiffuseMap(image);
    }

}
