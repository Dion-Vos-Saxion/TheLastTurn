package Items;

import utils.BaseAbility;
import utils.BaseTrousers;

public class LegendaryTrousers extends BaseTrousers {

    public LegendaryTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Legendary Trousers";
        ability = new BaseAbility("Kick", 8, 4, 4, 80);
    }

    @Override
    public void loop() {

    }
}
