package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class UncommonWeapon extends BaseItem {

    public UncommonWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Weapon";
        ability = new BaseAbility("Stab", 8, 0, 2, 60, "resources/Sprites/UI elements/Weapon/UncommonSword.png");
    }

    @Override
    public void loop() {

    }
}
