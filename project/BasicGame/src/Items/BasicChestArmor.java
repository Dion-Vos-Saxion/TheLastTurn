package Items;

import nl.saxion.app.SaxionApp;
import utils.BaseAbility;
import utils.BaseItem;
import utils.MouseHandler;
import utils.SceneManager;

public class BasicChestArmor extends BaseItem {

    public BasicChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "ChestArmor";
        name = "Basic Chest Armor";
        ability = new BaseAbility("Block", 0, 5, 2, 80);
    }

    public void loop() {

    }
}
