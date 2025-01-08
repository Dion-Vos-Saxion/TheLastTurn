package Items;

import utils.BaseAbility;
import utils.BaseWeapon;

public class LegendaryWeapon extends BaseWeapon {

    public LegendaryWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Legendary Weapon";
        ability = new BaseAbility("Stab", 12, 0, 5, 85);
    }

    @Override
    public void loop() {

    }
}
