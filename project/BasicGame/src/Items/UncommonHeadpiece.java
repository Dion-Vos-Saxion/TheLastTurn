package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;

public class UncommonHeadpiece extends BaseHeadpiece {

    public UncommonHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Head Piece";
        ability = new BaseAbility("Brace", 0, 5, 1, 75);
    }

    @Override
    public void loop() {

    }
}
