package Items;

import utils.BaseAbility;
import utils.BaseChestArmor;

public class UncommonChestArmor extends BaseChestArmor {

    public UncommonChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Chest Armor";
        ability = new BaseAbility("Block", 0, 9, 3, 75);
    }

    public void loop() {

    }
}
