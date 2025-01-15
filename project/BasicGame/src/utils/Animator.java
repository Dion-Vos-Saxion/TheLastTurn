package utils;

import nl.saxion.app.SaxionApp;

public class Animator {
    private int x, y, width, height;
    private String[] currentFrames;
    private final String[] idleFrames;
    private int currentFrame;
    private final int frameDelay;
    private int delayCounter;

    private boolean isHurt = false;
    private int hurtDuration;
    private int hurtTimer;
    private String[] hurtFrames;

    // Voor de aanvalsanime
    private boolean isAttacking = false;
    private int attackDuration;
    private int attackTimer;
    private String[] attackFrames;

    public Animator(int x, int y, int width, int height, String[] idleFrames, int frameDelay) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.idleFrames = idleFrames;
        this.currentFrames = idleFrames;
        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.delayCounter = 0;
    }

    // Zet de hurt animatie
    public void setHurtAnimation(String[] hurtFrames, int hurtDuration) {
        this.hurtFrames = hurtFrames;
        this.hurtDuration = hurtDuration;
    }

    // Zet de attack animatie
    public void setAttackAnimation(String[] attackFrames, int attackDuration) {
        this.attackFrames = attackFrames;
        this.attackDuration = attackDuration;
    }

    // Start de hurt animatie
    public void triggerHurt() {
        if (!isHurt) {
            isHurt = true;
            hurtTimer = 0;
            currentFrames = hurtFrames;  // Gebruik de hurt frames
            reset();
        }
    }

    // Start de attack animatie
    public void triggerAttack() {
        if (!isAttacking) {
            isAttacking = true;
            attackTimer = 0;
            currentFrames = attackFrames;  // Gebruik de attack frames
            reset();
        }
    }

    public void loop() {
        // Handle hurt animatie
        if (isHurt) {
            hurtTimer++;
            if (hurtTimer >= hurtDuration) {
                isHurt = false;
                currentFrames = idleFrames;  // Ga terug naar de idle animatie
                reset();
            }
        }

        // Handle attack animatie
        if (isAttacking) {
            attackTimer++;
            if (attackTimer >= attackDuration) {
                isAttacking = false;
                currentFrames = idleFrames;  // Ga terug naar idle na aanval
                reset();
            }
        }

        // Beheer frame wisseling
        delayCounter++;
        if (delayCounter >= frameDelay) {
            currentFrame = (currentFrame + 1) % currentFrames.length;
            delayCounter = 0;
        }
    }

    public void draw() {
        SaxionApp.drawImage(currentFrames[currentFrame], x, y, width, height);
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
