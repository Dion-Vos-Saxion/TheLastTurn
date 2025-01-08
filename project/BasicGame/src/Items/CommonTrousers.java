package Items;

import utils.BaseAbility;
import utils.BaseTrousers;

public class CommonTrousers extends BaseTrousers {

    public CommonTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Trousers";
        ability = new BaseAbility("Kick", 4, 2, 2, 75);
    }

    @Override
    public void loop() {

    }
}
