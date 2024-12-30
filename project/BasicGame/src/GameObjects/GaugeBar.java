package GameObjects;

import nl.saxion.app.SaxionApp;
import utils.GameObject;

import java.awt.*;

public class GaugeBar extends GameObject {

    Color backgroundColor;
    Color fillColor;
    private int max;
    public int current;

    public GaugeBar(int x, int y, int width, int height, Color backgroundColor, Color fillColor, int max) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.fillColor = fillColor;
        this.max = max;
        this.current = max;
    }

    public void init() {

    }

    public void loop() {

    }

    public void draw() {
        SaxionApp.setBorderColor(fillColor);
        SaxionApp.setFill(backgroundColor);
        SaxionApp.drawRectangle(x, y, width, height);

        int filledWidth = (int) ((double) current / max * width);

        SaxionApp.setFill(fillColor);
        SaxionApp.drawRectangle(x, y, filledWidth, height);
    }

    // Method to update the current value (optional helper)
    public void updateCurrent(int newValue) {
        if (newValue < 0) {
            this.current = 0;
        } else if (newValue > max) {
            this.current = max;
        } else {
            this.current = newValue;
        }
    }
}
