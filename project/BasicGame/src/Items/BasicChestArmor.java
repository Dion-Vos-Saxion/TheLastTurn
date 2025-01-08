package Items;

import utils.BaseAbility;
import utils.BaseChestArmor;

public class BasicChestArmor extends BaseChestArmor {

    public BasicChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Basic Chest Armor";
        ability = new BaseAbility("Block", 0, 5, 2, 80);
    }

    public void loop() {

    }
}
