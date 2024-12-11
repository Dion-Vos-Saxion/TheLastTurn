package utils;

import nl.saxion.app.SaxionApp;

public abstract class BaseEnemy extends GameObject {
    public int health;
    public String enemyName, sprite;
    public int[] attacks;
    public int[] blocks;

    public void TakeDamage(int damage) {
        health -= damage;
    }

    public boolean IsDead() {
        return health <= 0;
    }

    public void drawEnemy(){
        SaxionApp.drawImage(sprite,x - width / 2, y - height / 2, width, height);
    }
}
