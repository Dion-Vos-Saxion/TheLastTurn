package Items;

import utils.BaseAbility;
import utils.BaseItem;

public class MythicHeadpiece extends BaseItem {

    public MythicHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        type = "Headpiece";
        name = "Mythic Head Piece";
        ability = new BaseAbility("Brace", 0, 12, 5, 95,"resources/Sprites/UI elements/Headpieces/MythicHeadPiece.png");
    }

    @Override
    public void loop() {

    }
}
