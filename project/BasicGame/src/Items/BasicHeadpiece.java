package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;

public class BasicHeadpiece extends BaseHeadpiece {

    public BasicHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Basic Head Piece";
        ability = new BaseAbility("Block", 0, 5, 2);
    }

    @Override
    public void loop() {

    }
}
