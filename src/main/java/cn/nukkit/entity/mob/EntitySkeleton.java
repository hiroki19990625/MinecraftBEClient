package cn.nukkit.entity.mob;

import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author PikyCZ
 */
public class EntitySkeleton extends EntityMob {

    public static final int NETWORK_ID = 34;

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    public EntitySkeleton(FullChunk chunk, CompoundTag nbt) {
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
        return 1.99f;
    }

    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public Item[] getDrops() {
        return new Item[]{Item.get(Item.BONE, Item.ARROW)};
    }
}
