package utils;

import nl.saxion.app.SaxionApp;

public abstract class BaseEnemy extends GameObject {
    public int block;
    public int maxHealth;
    public int health = maxHealth;
    public String enemyName, sprite;
    public int[] attacks;
    public int[] blocks;

    public GaugeBar healthBar = new GaugeBar(700, 420, 270, 15, Color.BLACK, Color.RED, maxHealth);

    public void TakeDamage(int damage){
        if (block < 0){
            int restDamage = 0;
            if (damage >= block){
                restDamage = damage-block;
                block = 0;
            }
            else
                block -= damage;
            if (restDamage > 0)
                health -= restDamage;
        }
        else
            health -= damage;
        healthBar.updateCurrent(health);
    }

    public boolean IsDead() {
        return health <= 0;
    }

    public void drawEnemy(){
        healthBar.loop();
    }
}
