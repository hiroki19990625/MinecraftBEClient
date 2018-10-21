package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.block.BlockID;
import itsu.java.minecraftbeclient.utils.Texture;

import java.util.ArrayList;
import java.util.List;

public class TextureManager {

    public static List<Texture> textures;

    public static void init() {
        textures = new ArrayList<>();
        registerBlocks();
    }

    private static void registerBlocks() {
        textures.add(BlockID.AIR, new Texture("air.png"));
        textures.add(BlockID.STONE, new Texture("stone.png"));
        textures.add(BlockID.GRASS, new Texture("grass.png"));
        textures.add(BlockID.DIRT, new Texture("dirt.jpg"));
        textures.add(BlockID.SAND, new Texture("dirt.jpg"));
    }

    public static Texture getTexture(int blockId) {
        return textures.get(blockId);
    }
}
