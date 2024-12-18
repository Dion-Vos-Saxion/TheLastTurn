package Items;

import utils.BaseAbility;
import utils.BaseTrousers;

public class BasicTrousers extends BaseTrousers {

    public BasicTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Basic Trousers";
        ability = new BaseAbility("Block", 0, 5, 2);
    }

    @Override
    public void loop() {

    }
}
