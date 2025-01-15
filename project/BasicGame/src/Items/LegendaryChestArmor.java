package Items;

import utils.BaseAbility;
import utils.BaseChestArmor;
import utils.BaseItem;

public class LegendaryChestArmor extends BaseItem {

    public LegendaryChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Legendary Chest Armor";
        ability = new BaseAbility("Block", 0, 14, 5, 80, "resources/Sprites/UI elements/ChestArmors/LegendaryChestArmor.png");
    }

    public void loop() {

    }
}
