package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class RareWeapon extends BaseItem {

    public RareWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Weapon";
        ability = new BaseAbility("Stab", 8, 0, 1, 70, "resources/Sprites/UI elements/Weapons/RareSword.png");
    }

    @Override
    public void loop() {

    }
}
