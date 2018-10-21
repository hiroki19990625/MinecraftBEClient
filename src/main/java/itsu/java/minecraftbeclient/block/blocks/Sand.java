package itsu.java.minecraftbeclient.block.blocks;

import itsu.java.minecraftbeclient.block.Block;
import itsu.java.minecraftbeclient.block.BlockID;
import itsu.java.minecraftbeclient.block.Fallable;
import itsu.java.minecraftbeclient.core.GameServer;
import itsu.java.minecraftbeclient.level.Level;

public class Sand extends Block implements Fallable {

    public Sand() {
        this(0, 0, 0, GameServer.getLevel());
    }

    public Sand(double x, double y, double z, Level level) {
        super(BlockID.SAND, 0, x, y, z, "sand", level);
    }

}
