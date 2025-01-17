package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class CommonChestArmor extends BaseItem {

    public CommonChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "ChestArmor";
        name = "Common Chest Armor";
        ability = new BaseAbility("Big Block", 0, 20, 2, 40,"resources/Sprites/UI elements/ChestArmors/CommonArmorPiece.png");
    }

    public void loop() {

    }
}
