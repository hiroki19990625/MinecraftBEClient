package itsu.java.minecraftbeclient.block.blocks;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.block.BlockID;
import itsu.java.minecraftbeclient.core.GameServer;
import itsu.java.minecraftbeclient.level.Level;

public class Dirt extends Block {

    public Dirt() {
        this(0, 0, 0, GameServer.getLevel());
    }

    public Dirt(double x, double y, double z, Level level) {
        super(BlockID.DIRT, 0, x, y, z, "dirt", level);
    }

}
