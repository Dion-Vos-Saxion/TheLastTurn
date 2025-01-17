package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class RareWeapon extends BaseItem {

    public RareWeapon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Weapon";
        name = "Rare Weapon";
        ability = new BaseAbility("Stab", 50, 0, 5, 50, "resources/Sprites/UI elements/Weapons/RareSword.png");
    }

    @Override
    public void loop() {

    }
}
