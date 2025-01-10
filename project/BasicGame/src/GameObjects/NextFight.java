package GameObjects;

import utils.BaseItem;
import utils.GameObject;
import utils.MouseHandler;
import utils.SceneManager;

public class NextFight extends GameObject {

    private String imagePath;

    public NextFight(int x, int y, int width, int height, String imagePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.imagePath = imagePath;
    }

    public void init() {

    }

    public void loop() {
        if (MouseHandler.getInstance().clicked(x + width / 2, y + height / 2, width, height)) {
            SceneManager.getInstance().newGame();
        }
    }

    public void nextFight(BaseItem item){
        if (item.)
    }

    public void draw() {

    }
}
