package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemTool;

public class BlockBricksRedNether extends BlockNetherBrick {

    public BlockBricksRedNether() {
    }

    @Override
    public String getName() {
        return "Red Nether Bricks";
    }

    @Override
    public int getBlockId() {
        return RED_NETHER_BRICK;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN) {
            return new Item[]{
                    Item.get(Item.RED_NETHER_BRICK, 0, 1)
            };
        } else {
            return new Item[0];
        }
    }

}
