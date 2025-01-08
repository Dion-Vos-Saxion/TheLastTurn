package Items;

import utils.BaseAbility;
import utils.BaseWeapon;

public class UncommonWeapon extends BaseWeapon {

    public UncommonWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Weapon";
        ability = new BaseAbility("Stab", 8, 0, 2, 60);
    }

    @Override
    public void loop() {

    }
}
