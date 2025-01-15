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
        width = 400;
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
        SaxionApp.setTextDrawingColor(Color.white);
        SaxionApp.setFill(Color.YELLOW);
        if (chosen)
            SaxionApp.drawRectangle(x - 4, y - 4, width + 8, height + 8);
        SaxionApp.setFill(Color.BLACK);
        SaxionApp.drawRectangle(x, y, width, height);
        SaxionApp.drawText(item.name, x + 10, y + 10, 30);

        SaxionApp.setTextDrawingColor(Color.GRAY);
        SaxionApp.drawText(Integer.toString(item.ability.defense), x+ 95, y+ 60, 24);
        SaxionApp.setTextDrawingColor(Color.RED);
        SaxionApp.drawText(Integer.toString(item.ability.attack), x + 135, y+ 60, 24);
        SaxionApp.setTextDrawingColor(Color.BLUE);
        SaxionApp.drawText(Integer.toString(item.ability.staminaCost), x + 165, y + 60, 24);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText(Integer.toString(item.ability.hitChance) + "%", x + 185, y + 60, 24);
    }

    public void setOtherItem(ItemChoice choice) {
        this.other = choice;
    }
}
