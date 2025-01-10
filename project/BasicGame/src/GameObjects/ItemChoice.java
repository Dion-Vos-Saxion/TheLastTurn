package GameObjects;

import nl.saxion.app.SaxionApp;
import utils.BaseItem;
import utils.GameObject;
import utils.MouseHandler;

import java.awt.*;

public class ItemChoice extends GameObject {

    public boolean chosen = false;
    public BaseItem item;
    public ItemChoice other;

    public ItemChoice(int x, int y, BaseItem item) {
        this.x = x;
        this.y = y;
        width = 250;
        height = 100;
        this.item = item;
    }

    public void init() {

    }

    public void loop() {
        if (MouseHandler.getInstance().clicked(x + width / 2, y + height / 2, width, height)){
            other.chosen = false;
            chosen = true;
        }
    }

    public void draw() {
        SaxionApp.setFill(Color.GREEN);
        if (chosen)
            SaxionApp.drawRectangle(x - 4, y - 4, width + 8, height + 8);
        SaxionApp.setFill(Color.BLACK);
        SaxionApp.drawRectangle(x, y, width, height);
        SaxionApp.drawText(item.name, x, y, 30);
    }

    public void setOtherItem(ItemChoice choice) {
        this.other = choice;
    }
}
