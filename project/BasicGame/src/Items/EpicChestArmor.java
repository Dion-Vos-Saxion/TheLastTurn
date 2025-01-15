package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class EpicChestArmor extends BaseItem {

    public EpicChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Epic Chest Armor";
        ability = new BaseAbility("Block", 0, 12, 3, 75, "resources/Sprites/UI elements/ChestArmors/EpicArmorPiece.png");
    }

    public void loop() {

    }
}
