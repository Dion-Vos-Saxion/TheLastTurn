package Items;

import utils.BaseAbility;
import utils.BaseChestArmor;

public class RareChestArmor extends BaseChestArmor {

    public RareChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Chest Armor";
        ability = new BaseAbility("Block", 0, 9, 2, 80);
    }

    public void loop() {

    }
}
