package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class EpicWeapon extends BaseItem {

    public EpicWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Weapon";
        name = "Epic Weapon";
        ability = new BaseAbility("Stab", 9, 0, 3, 80, "resources/Sprites/UI elements/Weapons/EpicSword.png");
    }

    @Override
    public void loop() {

    }
}
