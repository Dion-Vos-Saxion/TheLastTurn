package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class BasicTrousers extends BaseItem {

    public BasicTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Trouser";
        name = "Basic Trousers";
        ability = new BaseAbility("Kick", 2, 3, 2, 70);
    }

    @Override
    public void loop() {

    }
}
