package GameObjects;

import Items.*;
import nl.saxion.app.SaxionApp;
import utils.*;

public class Player extends GameObject {

    private int health;

    public BaseHeadpiece headpiece;
    public BaseChestArmor chestArmor;
    public BaseTrousers trousers;
    public BaseWeapon weapon;

    String sprite;

    public Player(int x, int y, int width, int height, String sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        headpiece = new BasicHeadpiece();
        chestArmor = new BasicChestArmor();
        trousers = new BasicTrousers();
        weapon = new BasicWeapon();
    }

    public void init(){

    }

    public void loop(){
        drawPlayer();
    }

    public void drawPlayer(){
        SaxionApp.drawImage(sprite,x - width / 2, y - height / 2, width, height);
    }
}
