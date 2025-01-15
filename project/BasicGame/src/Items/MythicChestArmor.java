package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class MythicChestArmor extends BaseItem {

    public MythicChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Mythic Chest Armor";
        ability = new BaseAbility("Block", 0, 18, 8, 90, "resources/Sprites/UI elements/ChestArmors/MythicChestArmor.png");
    }

    public void loop() {

    }
}
