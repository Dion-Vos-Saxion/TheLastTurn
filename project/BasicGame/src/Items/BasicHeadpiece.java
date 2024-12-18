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
        ability = new BaseAbility("Brace", 0, 3, 2, 100);
    }

    @Override
    public void loop() {

    }
}
