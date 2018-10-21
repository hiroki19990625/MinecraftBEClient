package itsu.java.minecraftbeclient.block;

import itsu.java.minecraftbeclient.core.GameServer;

public class BlockManager {

    public static void registerBlocks() {
        GameServer.registerBlock(BlockID.AIR, 0, "air");
        GameServer.registerBlock(BlockID.STONE, 0, "stone");
        GameServer.registerBlock(BlockID.GRASS, 0, "grass");
        GameServer.registerBlock(BlockID.DIRT, 0, "dirt");
        GameServer.registerBlock(BlockID.SAND, 0, "sand");
    }
}
