package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;

public class RareHeadpiece extends BaseHeadpiece {

    public RareHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Head Piece";
        ability = new BaseAbility("Brace", 0, 6, 1, 75);
    }

    @Override
    public void loop() {

    }
}
