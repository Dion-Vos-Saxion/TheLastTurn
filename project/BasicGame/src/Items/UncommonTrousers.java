package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class UncommonTrousers extends BaseItem {

    public UncommonTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Trousers";
        ability = new BaseAbility("Kick", 5, 2, 2, 65, "resources/Sprites/UI elements/Trousers/UncommonTrousers.png");
    }

    @Override
    public void loop() {

    }
}
