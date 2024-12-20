package GameObjects;

import Items.*;
import nl.saxion.app.SaxionApp;
import utils.*;

import java.awt.*;

public class Player extends GameObject {

    private int maxHealth = 50;
    public int health;
    private int block;
    private int maxStamina = 10;
    public int stamina = maxStamina;

    public BaseHeadpiece headpiece;
    public BaseChestArmor chestArmor;
    public BaseTrousers trousers;
    public BaseWeapon weapon;

    public GaugeBar healthBar;
    public GaugeBar staminaBar;

    public BaseItem[] items;

    public int[][] UISlots = {{150, 665}, {150, 802}, {150, 940}, {490, 665}, {490, 802}, {490, 940}};
    private int[]  UIButtonsSize = {241, 90};

    //String sprite = "resources/Sprites/Enemies/Minotaur.png";
    String UIBackgroundSprite = "resources/Sprites/UI elements/Border UI.png";

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        headpiece = new BasicHeadpiece(UISlots[0][0], UISlots[0][1], UIButtonsSize[0], UIButtonsSize[1]);
        chestArmor = new BasicChestArmor(UISlots[1][0], UISlots[1][1], UIButtonsSize[0], UIButtonsSize[1]);
        trousers = new BasicTrousers(UISlots[2][0], UISlots[2][1], UIButtonsSize[0], UIButtonsSize[1]);
        weapon = new BasicWeapon(UISlots[3][0], UISlots[3][1], UIButtonsSize[0], UIButtonsSize[1]);
        items = new BaseItem[]{headpiece, chestArmor, trousers, weapon};

        healthBar = new GaugeBar(75, 420, 270, 15, Color.BLACK, Color.RED, maxHealth);
        staminaBar = new GaugeBar(700, 850, 270, 30, Color.BLACK, Color.BLUE, maxStamina);
    }

    public void init(){

    }

    public void loop(){
        drawPlayer();
        drawUI();
    }

    public void GainBlock(int block){
        this.block += block;
    }

    public void LoseBlock(){
        block = 0;
    }

    public void RegainStamina(){
        stamina = maxStamina;
    }

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

    public void drawPlayer(){
        //SaxionApp.drawImage(sprite,x - width / 2, y - height / 2, width, height);
    }

    public void drawUI(){
        SaxionApp.drawImage(UIBackgroundSprite, 12, 600, 999, 408);
        SaxionApp.drawImage(UIBackgroundSprite, 690, 620, 300, 368);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText("Current equipment: ", 695, 630, 18);
        for (int i = 0, nextPos = 0; i < items.length; i++, nextPos += 20) {
            SaxionApp.drawText(items[i].name, 700, 650 + nextPos, 20);
        }
        for (BaseItem item : items)
            item.drawAbilities();

        staminaBar.loop();
        healthBar.loop();
    }
}
