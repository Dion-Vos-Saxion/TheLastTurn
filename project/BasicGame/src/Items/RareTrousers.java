package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class RareTrousers extends BaseItem {

    public RareTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Trousers";
        ability = new BaseAbility("Kick", 6, 1, 2, 65, "resources/Sprites/UI elements/Trousers/RareTrousers.png");
    }

    @Override
    public void loop() {

    }
}
