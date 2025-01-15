package GameObjects;

import Items.BasicChestArmor;
import Items.BasicHeadpiece;
import Items.BasicTrousers;
import nl.saxion.app.SaxionApp;
import utils.*;

public class NextFight extends GameObject {

    private String imagePath;
    public BaseItem item;

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
            nextFight(SceneManager.getInstance().player);
            System.out.println("Clicked");
        }
    }

    public void nextFight(Player player) {
        player.ChangeGear(item);
    }

    public void draw() {
        SaxionApp.drawImage(imagePath,x - width / 2, y - height / 2, width, height);
    }
}
