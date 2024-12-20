package utils;

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

    // Voeg de abstracte draw() methode toe
    public abstract void draw(); // Dit moet abstract zijn voor elke subklasse, zoals Minotaur
}
