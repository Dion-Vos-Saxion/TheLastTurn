package Items;

import utils.BaseAbility;
import utils.BaseItem;
import utils.BaseTrousers;
import utils.BaseItem;

public class BasicTrousers extends BaseItem {

    public BasicTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Basic Trousers";
        ability = new BaseAbility("Kick", 2, 3, 2, 70,"resources/Sprites/UI elements/Trousers/BaseTrousers.png");
    }

    @Override
    public void loop() {

    }
}
