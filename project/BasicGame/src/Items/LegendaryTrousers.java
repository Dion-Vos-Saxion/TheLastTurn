package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class LegendaryTrousers extends BaseItem {

    public LegendaryTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Trouser";
        name = "Legendary Trousers";
        ability = new BaseAbility("Kick", 8, 4, 4, 80, "resources/Sprites/UI elements/Trousers/LegendaryTrousers.png");
    }

    @Override
    public void loop() {

    }
}
