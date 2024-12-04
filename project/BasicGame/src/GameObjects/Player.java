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

    public BaseItem[] items;

    public int[][] UISlots = {{2, 2}, {5, 5}};
    private int[]  UIButtonsSize = {200, 300};

    String sprite;

    public Player(int x, int y, int width, int height, String sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
        headpiece = new BasicHeadpiece();
        chestArmor = new BasicChestArmor(UISlots[0][0], UISlots[0][1], UIButtonsSize[0], UIButtonsSize[1]);
        trousers = new BasicTrousers();
        weapon = new BasicWeapon();
        items = new BaseItem[]{headpiece, chestArmor, trousers, weapon};
    }

    public void init(){

    }

    public void loop(){
        drawPlayer();
        headpiece.drawAbilities(200, 200);
        chestArmor.drawAbilities(200, 200);
        trousers.drawAbilities(200, 200);
        weapon.drawAbilities(200, 200);
    }

    public void drawPlayer(){
        SaxionApp.drawImage(sprite,x - width / 2, y - height / 2, width, height);
    }
}
