package Enemies;

import GameObjects.GaugeBar;
import nl.saxion.app.SaxionApp;
import utils.Animator;
import utils.BaseEnemy;
import java.util.Random;

import java.awt.*;

public class Bat extends BaseEnemy {

    public Bat(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        maxHealth = 30;
        health = maxHealth;
        enemyName = "Batwoman";
        attacks = new int[]{11, 3, 2};
        blocks = new int[]{26, 17, 9};
        NewAction();

        sprite = "resources/Sprites/Enemies/Bat/Idle/Bat1.png";

        String[] idleFrames = {
                "resources/Sprites/Enemies/Bat/Idle/BatIdle1.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle2.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle3.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle4.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle5.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle6.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle7.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle8.png",
                "resources/Sprites/Enemies/Bat/Idle/BatIdle9.png"
        };

        animator = new Animator(x, y, width, height, idleFrames, 4); // 20 is de frame delay
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
