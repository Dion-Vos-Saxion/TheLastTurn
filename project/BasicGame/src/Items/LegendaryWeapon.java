package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class LegendaryWeapon extends BaseItem {

    public LegendaryWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Weapon";
        name = "Legendary Weapon";
        ability = new BaseAbility("Stab", 200, 0, 10, 40, "resources/Sprites/UI elements/Weapons/LegendaryWeapon.png");
    }

    @Override
    public void loop() {

    }
}
