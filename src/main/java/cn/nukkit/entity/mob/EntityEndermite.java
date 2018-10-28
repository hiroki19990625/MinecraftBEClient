package cn.nukkit.entity.mob;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author Box.
 */
public class EntityEndermite extends EntityMob {

    public static final int NETWORK_ID = 55;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntityEndermite(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        this.setMaxHealth(8);
    }

    @Override
    public float getEntityWidth() {
        return 0.4f;
    }

    @Override
    public float getEntityHeight() {
        return 0.3f;
    }

    @Override
    public String getName() {
        return "Endermite";
    }
}
