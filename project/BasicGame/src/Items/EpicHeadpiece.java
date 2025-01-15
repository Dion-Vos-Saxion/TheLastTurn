package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class EpicHeadpiece extends BaseItem {

    public EpicHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Epic Head Piece";
        ability = new BaseAbility("Brace", 0, 7, 2, 80,"resources/Sprites/UI elements/Headpieces/EpicHeadPiece.png");
    }

    @Override
    public void loop() {

    }
}
