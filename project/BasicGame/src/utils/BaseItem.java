package utils;

import nl.saxion.app.SaxionApp;

import java.awt.*;

public abstract class BaseItem {
    public int x;
    public int y;
    public int width;
    public int height;
    public String name;
    public String buttonBackground = "resources/Sprites/UI elements/AbilityHolder.png";
    public BaseAbility ability;

    public void drawAbilities(){
        int posX = x - width / 2;
        int posY = y - height / 2;

        SaxionApp.drawImage(buttonBackground, posX, posY, width, height);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        SaxionApp.drawText(ability.name, posX + 100, posY + 12, 24);
        SaxionApp.drawText(Integer.toString(ability.hitChance) + "%", posX + 245, posY + 35, 30);

        if (ability.attack >= ability.defense)
            SaxionApp.drawImage("resources/Sprites/UI elements/BaseSword.png", posX + 40, posY + 14, 16, 64);
        else
            SaxionApp.drawImage("resources/Sprites/UI elements/Schild.png", posX + 16, posY + 14, 64, 64);

        SaxionApp.setTextDrawingColor(Color.GRAY);
        SaxionApp.setFill(Color.GRAY);
        for (int i = 0, nextPos = 0; i < ability.defense; i++, nextPos += 15){
            SaxionApp.drawCircle(posX + 105 + nextPos, posY + 60, 4);
        }

        SaxionApp.setTextDrawingColor(Color.RED);
        SaxionApp.setFill(Color.RED);
        for (int i = 0, nextPos = 0; i < ability.attack; i++, nextPos += 15){
            SaxionApp.drawCircle(posX + 105 + nextPos, posY + 72, 4);
        }
        SaxionApp.setFill(Color.BLUE);
        SaxionApp.setTextDrawingColor(Color.BLUE);
        for (int i = 0, nextPos = 0; i < ability.staminaCost; i++, nextPos += 15){
            SaxionApp.drawCircle(posX + 105 + nextPos, posY + 84, 4);
        }
    }
    public abstract void loop();
}
