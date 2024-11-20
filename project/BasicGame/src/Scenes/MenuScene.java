package Scenes;
import GameObjects.MenuStartButton;
import utils.GameObject;
import utils.Scene;

public class MenuScene extends Scene{


    public MenuScene() {
        gameObjects = new GameObject[1];
        gameObjects[0] = new MenuStartButton();
    }

    public void init() {

    }

    public void loop() {
        for (GameObject gameObject : gameObjects)
            gameObject.loop();
    }
}
