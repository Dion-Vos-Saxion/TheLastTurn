package Items;

import utils.BaseAbility;
import utils.BaseWeapon;

public class EpicWeapon extends BaseWeapon {

    public EpicWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Epic Weapon";
        ability = new BaseAbility("Stab", 9, 0, 3, 80);
    }

    @Override
    public void loop() {

    }
}
