package Items;

import utils.BaseAbility;
import utils.BaseTrousers;
import utils.BaseItem;

public class MythicTrousers extends BaseItem {

    public MythicTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Legendary Trousers";
        ability = new BaseAbility("Kick", 10, 5, 6, 90, "resources/Sprites/UI elements/Trousers/MythicTrousers.png");
    }

    @Override
    public void loop() {

    }
}
