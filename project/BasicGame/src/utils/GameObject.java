package utils;

public abstract class GameObject {
    public int x, y, width, height;
    public abstract void init();
    public abstract void loop();
    public abstract void draw();
}
