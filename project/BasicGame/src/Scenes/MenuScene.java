package Scenes;
import GameObjects.SceneSwitchButton;
import utils.GameObject;
import utils.Scene;

public class MenuScene extends Scene{


    public MenuScene() {
        gameObjects = new GameObject[1];
        gameObjects[0] = new SceneSwitchButton(200, 200, 200, 200, "", 1);
    }

    public void init() {

    }

    public void loop() {
        for (GameObject gameObject : gameObjects)
            gameObject.loop();
    }
}
