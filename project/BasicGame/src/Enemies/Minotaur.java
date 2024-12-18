package Enemies;

import utils.*;

public class Minotaur extends BaseEnemy {

    public Minotaur(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        attacks = new int[]{11, 5, 3};
        blocks = new int[]{22, 2, 7};
        enemyName = "Minotaur";
        sprite = "resources/Sprites/Enemies/Minotaur.png";
    }

    public void init() {

    }

    public void loop() {
        drawEnemy();
    }
}
