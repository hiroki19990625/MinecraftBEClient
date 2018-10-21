package itsu.java.minecraftbeclient.block.blocks;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.block.BlockID;
import itsu.java.minecraftbeclient.core.GameServer;
import itsu.java.minecraftbeclient.level.Level;

public class Grass extends Block {

    public Grass() {
        this(0, 0, 0, GameServer.getLevel());
    }

    public Grass(double x, double y, double z, Level level) {
        super(BlockID.GRASS, 0, x, y, z, "grass", level);
    }

}
