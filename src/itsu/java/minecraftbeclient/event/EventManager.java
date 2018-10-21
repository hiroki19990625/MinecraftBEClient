package itsu.java.minecraftbeclient.event;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.core.GameServer;
import itsu.java.minecraftbeclient.level.Level;

public class EventManager {

    public static void onBlockLeftClick(Block block, Level level) {
        Block block1 = Block.get(GameServer.getBlockId(), GameServer.getBlockMeta());
        block1.setX(block.getX());
        block1.setY(block.getY() - 1);
        block1.setZ(block.getZ());
        block1.setLevel(level);

        level.setBlock(block1);
    }

    public static void onBlockRightClick(Block block, Level level) {
        level.removeBlock(block);
    }
}
