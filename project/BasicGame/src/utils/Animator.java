package utils;

import nl.saxion.app.SaxionApp;

public class Animator {
    private int x, y, width, height; // Position and size of the animation
    private final String[] frames;         // Array of image paths for the animation
    private int currentFrame;        // Current frame index
    private final int frameDelay;          // Delay in loops between frames
    private int delayCounter;        // Counter to track when to switch frames

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

    /**
     * Update the animation's frame.
     */
    public void loop() {
        delayCounter++;
        if (delayCounter >= frameDelay) {
            currentFrame = (currentFrame + 1) % frames.length; // Move to the next frame, looping back to 0
            delayCounter = 0;
        }
    }

    /**
     * Draw the current frame of the animation.
     */
    public void draw() {
        SaxionApp.drawImage(frames[currentFrame], x, y, width, height);
    }

    /**
     * Set the position of the animation.
     * @param x New x-coordinate
     * @param y New y-coordinate
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Set the size of the animation.
     * @param width New width
     * @param height New height
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Reset the animation to the first frame.
     */
    public void reset() {
        this.currentFrame = 0;
        this.delayCounter = 0;
    }
}
