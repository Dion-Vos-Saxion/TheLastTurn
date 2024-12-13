package GameObjects;

import Items.*;
import nl.saxion.app.SaxionApp;
import utils.*;

public class Player extends GameObject {

    private int health;
    private int block;

    public BaseHeadpiece headpiece;
    public BaseChestArmor chestArmor;
    public BaseTrousers trousers;
    public BaseWeapon weapon;

    public BaseItem[] items;

    public int[][] UISlots = {{50, 800}, {5, 5}, {}, {}, {}, {}};
    private int[]  UIButtonsSize = {241, 90};

    String sprite = "resources/Sprites/Enemies/Minotaur.png";
    String UIBackgroundSprite = "resources/Sprites/UI elements/Border UI.png";

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
        drawUI();
//        headpiece.drawAbilities(200, 200);
        chestArmor.drawAbilities();
//        trousers.drawAbilities(200, 200);
//        weapon.drawAbilities(200, 200);
    }

    public void GainBlock(int block){
        this.block += block;
    }

    public void LoseBlock(){
        block = 0;
    }

    public void drawPlayer(){
        SaxionApp.drawImage(sprite,x - width / 2, y - height / 2, width, height);
    }

    public void drawUI(){
        SaxionApp.drawImage(UIBackgroundSprite, 12, 600, 999, 408);
    }
}
