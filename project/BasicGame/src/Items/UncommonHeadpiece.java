package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class UncommonHeadpiece extends BaseItem {

    public UncommonHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Head Piece";
        ability = new BaseAbility("Brace", 0, 5, 1, 75, "resources/Sprites/UI elements/Headpieces/UncommonHeadPiece.png");
    }

    @Override
    public void loop() {

    }
}
