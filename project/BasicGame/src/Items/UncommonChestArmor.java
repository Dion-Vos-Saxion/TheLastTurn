package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class UncommonChestArmor extends BaseItem {

    public UncommonChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "ChestArmor";
        name = "Uncommon Chest Armor";
        ability = new BaseAbility("Block", 0, 30, 3, 75, "resources/Sprites/UI elements/ChestArmors/UncommonArmorPiece.png");
    }

    public void loop() {

    }
}
