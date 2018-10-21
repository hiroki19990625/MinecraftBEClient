package itsu.java.minecraftbeclient.block.blocks;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.block.BlockID;
import itsu.java.minecraftbeclient.core.GameServer;
import itsu.java.minecraftbeclient.level.Level;

public class Stone extends Block {

    public Stone() {
        this(0, 0, 0, GameServer.getLevel());
    }

    public Stone(double x, double y, double z, Level level) {
        super(BlockID.STONE, 0, x, y, z, "stone", level);
    }

}
