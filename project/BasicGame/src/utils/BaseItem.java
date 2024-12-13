package utils;

import nl.saxion.app.SaxionApp;

public abstract class BaseItem {
    public int x;
    public int y;
    public int width;
    public int height;
    public String name;
    public String buttonBackground = "resources/Sprites/UI elements/AbilityHolder.png";
    public BaseAbility ability;
    public void drawAbilities(){
        SaxionApp.drawImage(buttonBackground, x, y, width, height);
    }
    public abstract void loop();
}
