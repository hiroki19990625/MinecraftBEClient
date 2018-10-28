package itsu.java.minecraftbeclient.event;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.math.BlockFace;
import itsu.java.minecraftbeclient.core.GameServer;
import itsu.java.minecraftbeclient.level.Level;

public class EventManager {

    public static void onBlockLeftClick(Block block, Level level, int face) {
        Block block1 = Block.get(GameServer.getBlockId(), GameServer.getBlockMeta());
        block1.setLevel(level);

        switch (face) {
            case BlockFace.FACE_TOP: {
                block1.setX(block.getX());
                block1.setY(block.getY() - 1);
                block1.setZ(block.getZ());
                break;
            }

            case BlockFace.FACE_BOTTOM: {
                block1.setX(block.getX());
                block1.setY(block.getY() + 1);
                block1.setZ(block.getZ());
                break;
            }

            case BlockFace.FACE_LEFT: {
                block1.setX(block.getX() - 1);
                block1.setY(block.getY());
                block1.setZ(block.getZ());
                break;
            }

            case BlockFace.FACE_RIGHT: {
                block1.setX(block.getX() + 1);
                block1.setY(block.getY());
                block1.setZ(block.getZ());
                break;
            }

            case BlockFace.FACE_FORWARD: {
                block1.setX(block.getX());
                block1.setY(block.getY());
                block1.setZ(block.getZ() - 1);
                break;
            }

            case BlockFace.FACE_BACK: {
                block1.setX(block.getX());
                block1.setY(block.getY());
                block1.setZ(block.getZ() + 1);
                break;
            }
        }

        level.setBlock(block1);
    }

    public static void onBlockRightClick(Block block, Level level) {
        level.removeBlock(block);
    }
}
