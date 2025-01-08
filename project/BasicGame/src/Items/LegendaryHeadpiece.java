package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;

public class LegendaryHeadpiece extends BaseHeadpiece {

    public LegendaryHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Legendary Head Piece";
        ability = new BaseAbility("Brace", 0, 9, 3, 85);
    }

    @Override
    public void loop() {

    }
}
