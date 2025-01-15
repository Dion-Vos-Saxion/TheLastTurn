package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class BasicWeapon extends BaseItem {

    public BasicWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Weapon";
        name = "Basic Weapon";
        ability = new BaseAbility("Stab", 5, 0, 2, 60,"resources/Sprites/UI elements/Weapons/BaseSword.png");
    }

    @Override
    public void loop() {

    }
}
