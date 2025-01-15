package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class CommonTrousers extends BaseItem {

    public CommonTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Trouser";
        name = "Uncommon Trousers";
        ability = new BaseAbility("Kick", 4, 2, 2, 75,"resources/Sprites/UI elements/Trousers/CommonTrousers.png");
    }

    @Override
    public void loop() {

    }
}
