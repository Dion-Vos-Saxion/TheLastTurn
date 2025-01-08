package Items;

import utils.BaseAbility;
import utils.BaseTrousers;

public class RareTrousers extends BaseTrousers {

    public RareTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Trousers";
        ability = new BaseAbility("Kick", 6, 1, 2, 65);
    }

    @Override
    public void loop() {

    }
}
