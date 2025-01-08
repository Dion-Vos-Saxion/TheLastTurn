package Items;

import utils.BaseAbility;
import utils.BaseTrousers;

public class UncommonTrousers extends BaseTrousers {

    public UncommonTrousers(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        name = "Uncommon Trousers";
        ability = new BaseAbility("Kick", 5, 2, 2, 65);
    }

    @Override
    public void loop() {

    }
}
