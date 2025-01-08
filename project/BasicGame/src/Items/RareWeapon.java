package Items;

import utils.BaseAbility;
import utils.BaseWeapon;

public class RareWeapon extends BaseWeapon {

    public RareWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Weapon";
        ability = new BaseAbility("Stab", 8, 0, 1, 70);
    }

    @Override
    public void loop() {

    }
}
