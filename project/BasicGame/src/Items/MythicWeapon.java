package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class MythicWeapon extends BaseItem {

    public MythicWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Weapon";
        name = "Mythic Weapon";
        ability = new BaseAbility("Slash", 35, 0, 1, 95, "resources/Sprites/UI elements/Weapons/MythicSword.png");
    }

    @Override
    public void loop() {

    }
}
