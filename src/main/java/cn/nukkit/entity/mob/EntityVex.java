package cn.nukkit.entity.mob;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityVex extends EntityMob {

    public static final int NETWORK_ID = 105;

    public EntityVex(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        this.setMaxHealth(14);
    }

    @Override
    public float getEntityWidth() {
        return 0.4f;
    }

    @Override
    public float getEntityHeight() {
        return 0.8f;
    }

    @Override
    public String getName() {
        return "Vex";
    }
}
