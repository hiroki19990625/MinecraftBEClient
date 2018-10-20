package itsu.java.minecraftbeclient.block;

import itsu.java.minecraftbeclient.level.Level;

public class Stone extends Block {

    public Stone(double x, double y, double z, Level level) {
        super(BlockID.STONE, x, y, z, "stone", level);
    }

    @Override
    public boolean isFallable() {
        return false;
    }

}
