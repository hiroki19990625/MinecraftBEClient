package cn.nukkit.entity.mob;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntitySilverfish extends EntityMob {

    public static final int NETWORK_ID = 39;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntitySilverfish(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public String getName() {
        return "Silverfish";
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
    public void initEntity() {
        super.initEntity();
        this.setMaxHealth(8);
    }
}