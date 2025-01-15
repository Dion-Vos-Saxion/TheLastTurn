package Items;

import utils.BaseAbility;
import utils.BaseWeapon;
import utils.BaseItem;

public class CommonWeapon extends BaseItem {

    public CommonWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Basic Weapon";
        ability = new BaseAbility("Slash", 8, 0, 3, 55,"resources/Sprites/UI elements/Weapons/CommonSword.png");
    }

    @Override
    public void loop() {

    }
}
