package cn.nukkit.entity.mob;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntityElderGuardian extends EntityMob {

    public static final int NETWORK_ID = 50;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntityElderGuardian(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        this.setMaxHealth(80);
        this.setDataFlag(DATA_FLAGS, DATA_FLAG_ELDER, true);
    }

    @Override
    public float getEntityWidth() {
        return 1.9975f;
    }

    @Override
    public float getEntityHeight() {
        return 1.9975f;
    }

    @Override
    public String getName() {
        return "Elder Guardian";
    }
}
