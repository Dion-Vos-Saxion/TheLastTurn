package GameObjects;

import nl.saxion.app.SaxionApp;
import utils.GameObject;
import utils.MouseHandler;
import utils.SceneManager;

public class EndTurnButton extends GameObject {
    String sprite;

    public EndTurnButton(int x, int y, int width, int height, String sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public void init() {
        
    }

    public void loop() {
        SaxionApp.drawImage(sprite,x - width / 2, y - height / 2, width, height);
    }

    public boolean pressed() {
        return MouseHandler.getInstance().clicked(x, y, width, height);
    }
}
