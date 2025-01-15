package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class RareHeadpiece extends BaseItem {

    public RareHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Rare Head Piece";
        ability = new BaseAbility("Brace", 0, 6, 1, 75, "resources/Sprites/UI elements/Headpieces/RareHeadPiece.png");
    }

    @Override
    public void loop() {

    }
}
