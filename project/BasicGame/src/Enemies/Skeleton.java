package Enemies;

import GameObjects.GaugeBar;
import nl.saxion.app.SaxionApp;
import utils.Animator;
import utils.BaseEnemy;
import java.util.Random;

// NEEDS TO BE SMALLER
// CHANGE HP

import java.awt.*;

public class Skeleton extends BaseEnemy {

    public Skeleton(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        maxHealth = 25;
        health = maxHealth;
        enemyName = "Skeleton";
        attacks = new int[]{10, 3, 2};
        blocks = new int[]{25, 5, 8};
        NewAction();

        sprite = "resources/Sprites/Enemies/Skeleton/Idle/Skeleton1.png";

        String[] idleFrames = {
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton1.png",
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton2.png",
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton3.png",
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton4.png",
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton5.png",
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton6.png",
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton7.png",
                "resources/Sprites/Enemies/Skeleton/Idle/Skeleton8.png"
        };

        animator = new Animator(x, y, width, height, idleFrames, 20); // 20 is de frame delay
        healthBar = new GaugeBar(700, 420, 270, 15, Color.BLACK, Color.RED, maxHealth);
    }

    public void init() {

    }

    public void loop() {
        animator.loop();
        healthBar.loop();
    }

    public void draw() {
        animator.draw();
        healthBar.draw();
        DrawName();
        DrawIntent();
        DrawBlock();
    }
}
