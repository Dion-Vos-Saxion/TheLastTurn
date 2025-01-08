package utils;

public abstract class Scene {
    protected GameObject[] gameObjects;

    public abstract void init();
    public abstract void loop();
    public abstract void unInit();
}
