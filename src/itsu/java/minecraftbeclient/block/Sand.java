package itsu.java.minecraftbeclient.block;

import itsu.java.minecraftbeclient.level.Level;

public class Sand extends Block {

    public Sand(double x, double y, double z, Level level) {
        super(BlockID.SAND, x, y, z, "sand", level);
    }

    @Override
    public boolean isFallable() {
        return true;
    }

}
