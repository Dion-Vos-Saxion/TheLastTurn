package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;

public class CommonHeadpiece extends BaseHeadpiece {

    public CommonHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Common Head Piece";
        ability = new BaseAbility("Brace", 0, 4, 1, 80);
    }

    @Override
    public void loop() {

    }
}
