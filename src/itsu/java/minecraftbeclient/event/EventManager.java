package itsu.java.minecraftbeclient.event;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.block.Stone;
import itsu.java.minecraftbeclient.level.Level;

public class EventManager {

    public static void onBlockLeftClick(Block block, Level level) {
        Stone stone = new Stone(block.getX(), block.getY() - 1, block.getZ(), level);
        level.setBlock(stone);
    }

    public static void onBlockRightClick(Block block, Level level) {
        level.removeBlock(block);
    }
}
