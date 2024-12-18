package Items;

import utils.BaseAbility;
import utils.BaseWeapon;

public class BasicWeapon extends BaseWeapon {

    public BasicWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Basic Weapon";
        ability = new BaseAbility("Block", 0, 5, 2);
    }

    @Override
    public void loop() {

    }
}
