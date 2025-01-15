package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class LegendaryHeadpiece extends BaseItem {

    public LegendaryHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Headpiece";
        name = "Legendary Head Piece";
        ability = new BaseAbility("Brace", 0, 9, 3, 85, "resources/Sprites/UI elements/Headpieces/LegendaryHeadPiece.png");
    }

    @Override
    public void loop() {

    }
}
