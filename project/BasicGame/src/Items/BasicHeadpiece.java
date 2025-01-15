package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class BasicHeadpiece extends BaseItem {

    public BasicHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Headpiece";
        name = "Basic Head Piece";
        ability = new BaseAbility("Brace", 0, 3, 2, 100,"resources/Sprites/UI elements/Headpieces/BaseChestPiece.png");
    }

    @Override
    public void loop() {

    }
}
