package GameObjects;
import nl.saxion.app.SaxionApp;
import utils.GameObject;
import utils.MouseHandler;
import nl.saxion.app.interaction.MouseEvent;

import java.awt.*;

public class MenuStartButton extends GameObject {
    public MenuStartButton() {
        x = 200;
        y = 200;
        width = 200;
        height = 200;
    }

    public void loop() {
        SaxionApp.drawRectangle(x - width / 2, y - height / 2, width, height);

        if (MouseHandler.getInstance().hovering(x, y, width, height))
            System.out.println("hovering");

        if (MouseHandler.getInstance().clicked(x, y, width, height))
            SaxionApp.drawText("click", x + 100, y, 50);
    }
}
