package Items;

import nl.saxion.app.SaxionApp;
import utils.BaseAbility;
import utils.BaseChestArmor;
import utils.MouseHandler;
import utils.SceneManager;

public class BasicChestArmor extends BaseChestArmor {
    String buttonBackground = "";

    public BasicChestArmor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Basic Chest Armor";
        ability = new BaseAbility("Block", 0, 5, 2);
    }

    public void drawAbilities(int x, int y) {
        SaxionApp.drawImage(buttonBackground, x, y);
    }

    public void loop() {

    }
}
