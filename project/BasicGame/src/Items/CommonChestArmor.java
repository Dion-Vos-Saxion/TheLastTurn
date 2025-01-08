package Items;

import utils.BaseAbility;
import utils.BaseChestArmor;

public class CommonChestArmor extends BaseChestArmor {

    public CommonChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Common Chest Armor";
        ability = new BaseAbility("Block", 0, 8, 3, 75);
    }

    public void loop() {

    }
}
