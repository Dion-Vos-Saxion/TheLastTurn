package utils;

public class Enemy extends BaseEnemy {

    public Enemy(){
        this.enemyName = enemyName;
        this.enemySprite = enemySprite;
        this.blockCapability = false;
        this.isDamaged = false;
    }

    @Override
    public void loop() {
        // while player is attacking and blocking capability is false
        // isDamaged = true
        // damageAmount = player.attackStat ( ? )
        // if blocking capability = true
        // print blocked
    }

    @Override
    public void update() {
        // while enemy has been attacked
        // update enemy hp
        // update enemy
    }
}
