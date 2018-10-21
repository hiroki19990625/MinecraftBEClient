package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.level.Level;

import java.util.*;

public class GameServer {

    private static Map<String, String> registeredBlocks = new HashMap<>();

    private static int blockId;
    private static int blockMeta;

    private static Level level;

    public static int getBlockId() {
        return blockId;
    }

    public static void setBlockId(int blockId) {
        GameServer.blockId = blockId;
    }

    public static int getBlockMeta() {
        return blockMeta;
    }

    public static void setBlockMeta(int blockMeta) {
        GameServer.blockMeta = blockMeta;
    }

    public static void registerBlock(int id, int meta, String name) {
        registeredBlocks.put(id + ":" + meta, name);
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

    public static Level getLevel() {
        return level;
    }

    public static void setLevel(Level level) {
        GameServer.level = level;
    }
}
