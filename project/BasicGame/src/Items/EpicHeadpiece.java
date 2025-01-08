package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;

public class EpicHeadpiece extends BaseHeadpiece {

    public EpicHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Epic Head Piece";
        ability = new BaseAbility("Brace", 0, 7, 2, 80);
    }

    @Override
    public void loop() {

    }
}
