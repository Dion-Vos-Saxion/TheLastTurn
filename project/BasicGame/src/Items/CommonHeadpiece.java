package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;
import utils.BaseItem;

public class CommonHeadpiece extends BaseItem {

    public CommonHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Common Head Piece";
        ability = new BaseAbility("Brace", 0, 4, 1, 80,"resources/Sprites/UI elements/Headpieces/CommonHeadPiece.png");
    }

    @Override
    public void loop() {

    }
}
