package utils;

public abstract class BaseItem {
    public int x;
    public int y;
    public int width;
    public int height;
    public String name;
    public BaseAbility ability;
    public abstract void drawAbilities(int x, int y);
    public abstract void loop();
}
