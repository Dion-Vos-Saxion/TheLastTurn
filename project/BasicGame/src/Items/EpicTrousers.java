package Items;

import utils.BaseAbility;
import utils.BaseTrousers;

public class EpicTrousers extends BaseTrousers {

    public EpicTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Epic Trousers";
        ability = new BaseAbility("Kick", 6, 2, 3, 70);
    }

    @Override
    public void loop() {

    }
}
