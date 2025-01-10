package Enemies;

import GameObjects.GaugeBar;
import nl.saxion.app.SaxionApp;
import utils.Animator;
import utils.BaseEnemy;
import java.util.Random;

import java.awt.*;

public class Minotaur extends BaseEnemy {

    public Minotaur(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        maxHealth = 3;
        health = maxHealth;
        enemyName = "Minotaur";
        attacks = new int[]{11, 5, 3};
        blocks = new int[]{22, 2, 7};
        NewAction();

        sprite = "resources/Sprites/Enemies/Minotaur/Idle/minotaur-idle1.png";

        String[] idleFrames = {
                "resources/Sprites/Enemies/Minotaur/Idle/minotaur-idle1.png",
                "resources/Sprites/Enemies/Minotaur/Idle/minotaur-idle2.png"
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
