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
        this.current = max; // Set the current value to max initially
    }

    public void init() {
        // Initialization code if needed
    }

    public void loop() {
        // Draw the background bar
        SaxionApp.setFill(backgroundColor);
        SaxionApp.drawRectangle(x, y, width, height);

        // Calculate the width of the filled portion based on current/max
        int filledWidth = (int) ((double) current / max * width);

        // Draw the filled portion of the bar
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
