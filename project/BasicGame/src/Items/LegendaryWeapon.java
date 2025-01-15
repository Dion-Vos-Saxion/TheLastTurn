package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class LegendaryWeapon extends BaseItem {

    public LegendaryWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Legendary Weapon";
        ability = new BaseAbility("Stab", 12, 0, 5, 85, "resources/Sprites/UI elements/Weapons/LegendaryWeapon.png");
    }

    @Override
    public void loop() {

    }
}
