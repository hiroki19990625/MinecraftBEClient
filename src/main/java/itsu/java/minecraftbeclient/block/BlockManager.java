package itsu.java.minecraftbeclient.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockManager {

    private static Map<String, String> registeredBlocks = new HashMap<>();
    private static List<Texture> textures = new ArrayList<>();

    public static void registerBlocks() {
        registerBlock(BlockID.AIR, 0, "air", new Texture("air.png"));
        registerBlock(BlockID.STONE, 0, "stone", new Texture("stone.png"));
        registerBlock(BlockID.GRASS, 0, "grass", new Texture("grass.png"));
        registerBlock(BlockID.DIRT, 0, "dirt", new Texture("dirt.jpg"));
        registerBlock(BlockID.SAND, 0, "sand", new Texture("dirt.jpg"));
    }

    public static void registerBlock(int id, int meta, String name, Texture texture) {
        registeredBlocks.put(id + ":" + meta, name);
        textures.add(id, texture);
    }

    public static String getBlockNameFromIdAndMeta(int id, int meta) {
        return registeredBlocks.get(id + ":" + meta);
    }

    public static List<String> getBlocks() {
        List<String> result = new ArrayList<>();
        registeredBlocks.entrySet().forEach(entry -> {
            result.add(entry.getKey() + " - " + entry.getValue());
        });
        return result;
    }

    public static Texture getTexture(int blockId) {
        return textures.get(blockId);
    }
}
