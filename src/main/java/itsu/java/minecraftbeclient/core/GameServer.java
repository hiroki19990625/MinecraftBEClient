package itsu.java.minecraftbeclient.core;

import itsu.java.minecraftbeclient.level.Level;

import java.util.*;

public class GameServer {

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

    public static Level getLevel() {
        return level;
    }

    public static void setLevel(Level level) {
        GameServer.level = level;
    }
}
