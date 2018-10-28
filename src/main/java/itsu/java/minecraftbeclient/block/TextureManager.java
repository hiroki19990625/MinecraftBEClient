package itsu.java.minecraftbeclient.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextureManager {

    private static Map<String, List<Texture>> textures;

    public static void init() {
        textures = new HashMap<>();

        textures.put("Stone", new ArrayList<Texture>() {{add(new Texture("stone.png"));}});
        textures.put("Air", new ArrayList<Texture>() {{add(new Texture("air.png"));}});
        textures.put("Grass", new ArrayList<Texture>() {{add(new Texture("grass.png"));}});
        textures.put("Sand", new ArrayList<Texture>() {{add(new Texture("dirt.jpg"));}});
        textures.put("Dirt", new ArrayList<Texture>() {{add(new Texture("dirt.jpg"));}});

    }
}
