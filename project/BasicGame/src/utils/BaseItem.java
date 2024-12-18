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
    }
    public abstract void loop();
}
