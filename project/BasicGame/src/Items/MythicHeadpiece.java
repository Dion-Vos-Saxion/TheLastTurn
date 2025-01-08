package Items;

import utils.BaseAbility;
import utils.BaseHeadpiece;

public class MythicHeadpiece extends BaseHeadpiece {

    public MythicHeadpiece(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Mythic Head Piece";
        ability = new BaseAbility("Brace", 0, 12, 5, 95);
    }

    @Override
    public void loop() {

    }
}
