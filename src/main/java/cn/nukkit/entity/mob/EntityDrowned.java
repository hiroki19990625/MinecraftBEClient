package cn.nukkit.entity.mob;

import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * Created by PetteriM1
 */
public class EntityDrowned extends EntityMob {

    public static final int NETWORK_ID = 110;

    public EntityDrowned(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
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
        return "Drowned";
    }

    @Override
    public Item[] getDrops() {
        return new Item[]{Item.get(Item.ROTTEN_FLESH)};
    }
}