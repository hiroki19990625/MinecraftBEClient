package cn.nukkit.entity.mob;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityHusk extends EntityMob {

    public static final int NETWORK_ID = 47;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntityHusk(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        this.setMaxHealth(20);
    }

    @Override
    public float getEntityWidth() {
        return 0.6f;
    }

    @Override
    public float getEntityHeight() {
        return 1.95f;
    }

    @Override
    public String getName() {
        return "Husk";
    }
}
