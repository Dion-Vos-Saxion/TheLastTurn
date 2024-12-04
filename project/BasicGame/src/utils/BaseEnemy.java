package utils;

public abstract class BaseEnemy {
    public int healthAmount, damageAmount, defenseAmount;
    public boolean blockCapability, isDamaged;
    public String enemyName, enemySprite;

    public abstract void loop();
    public abstract void update();
}
