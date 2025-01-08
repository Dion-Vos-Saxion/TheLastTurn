package Items;

import utils.BaseAbility;
import utils.BaseWeapon;

public class MythicWeapon extends BaseWeapon {

    public MythicWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Mythic Weapon";
        ability = new BaseAbility("Slash", 15, 0, 7, 95);
    }

    @Override
    public void loop() {

    }
}
