package Items;

import utils.BaseAbility;
import utils.BaseTrousers;

public class MythicTrousers extends BaseTrousers {

    public MythicTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Legendary Trousers";
        ability = new BaseAbility("Kick", 10, 5, 6, 90);
    }

    @Override
    public void loop() {

    }
}
