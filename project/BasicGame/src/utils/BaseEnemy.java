package utils;

import GameObjects.GaugeBar;
import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.Random;

public abstract class BaseEnemy extends GameObject {
    public int block;
    public int maxHealth;
    public int health;
    public String enemyName, sprite;
    public int[] attacks;
    public int[] blocks;
    public int currentActionAmount;
    public boolean currentIsAttacking;

    public GaugeBar healthBar;
    public Animator animator;

    public void TakeDamage(int damage){
        if (block > 0){
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

    public void GainBlock(int block){
        this.block += block;
    }

    public void LoseBlock(){
        block = 0;
    }

    public boolean IsDead() {
        return health <= 0;
    }

    public int GetActionAmount(){
        if (currentIsAttacking)
            return attacks[new Random().nextInt(attacks.length)];
        else
            return blocks[new Random().nextInt(blocks.length)];
    }

    public void NewAction(){
        currentIsAttacking = new Random().nextBoolean();
        currentActionAmount = GetActionAmount();
    }

    public void DrawIntent(){
        if (currentIsAttacking)
            SaxionApp.drawImage("resources/Sprites/UI elements/Weapons/BaseSword.png", x + 24, y + 100, 16, 64);
        else
            SaxionApp.drawImage("resources/Sprites/UI elements/Schild.png", x, y + 100, 64, 64);

        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText(Integer.toString(currentActionAmount), x + 8, y + 116, 40);
    }

    public void DrawName(){
        SaxionApp.setFill(Color.BLACK);
        SaxionApp.setBorderColor(Color.BLACK);
        SaxionApp.drawRectangle(700, 437, 110, 25);

        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText(enemyName, 700, 437, 28);
    }

    public void DrawBlock(){
        if (block > 0){
            SaxionApp.setBorderColor(Color.GRAY);
            SaxionApp.setFill(Color.GRAY);
            SaxionApp.drawCircle(x + width - 15, y + height - 70, 20);
            SaxionApp.setTextDrawingColor(Color.BLACK);
            SaxionApp.drawText(Integer.toString(block), x + width - 30, y + height - 80, 28);
        }
    }
}
