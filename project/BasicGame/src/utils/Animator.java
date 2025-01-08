package utils;

import nl.saxion.app.SaxionApp;

public class Animator {
    private int x, y, width, height;
    private final String[] frames;
    private int currentFrame;
    private final int frameDelay;
    private int delayCounter;

    public Animator(int x, int y, int width, int height, String[] framePaths, int frameDelay) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.frames = framePaths;
        this.currentFrame = 0;
        this.frameDelay = frameDelay;
        this.delayCounter = 0;
    }

    public void loop() {
        delayCounter++;
        if (delayCounter >= frameDelay) {
            currentFrame = (currentFrame + 1) % frames.length;
            delayCounter = 0;
        }
    }

    public void draw() {
        SaxionApp.drawImage(frames[currentFrame], x, y, width, height);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void reset() {
        this.currentFrame = 0;
        this.delayCounter = 0;
    }
}
