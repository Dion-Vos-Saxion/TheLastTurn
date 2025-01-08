package Items;

import utils.BaseAbility;
import utils.BaseChestArmor;

public class MythicChestArmor extends BaseChestArmor {

    public MythicChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Mythic Chest Armor";
        ability = new BaseAbility("Block", 0, 18, 8, 90);
    }

    public void loop() {

    }
}
