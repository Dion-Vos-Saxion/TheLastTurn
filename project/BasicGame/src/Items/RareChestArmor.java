package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class RareChestArmor extends BaseItem {

    public RareChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Chest Armor";
        ability = new BaseAbility("Block", 0, 9, 2, 80, "resources/Sprites/UI elements/ChestArmors/RareChestArmor.png");
    }

    public void loop() {

    }
}
