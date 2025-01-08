package Scenes;

import GameObjects.*;
import nl.saxion.app.SaxionApp;
import utils.*;

public class MenuScene extends Scene {

    Sound sound = new Sound(("resources/Sounds/MenuBackgroundMusic.wav"));

    public MenuScene() {
        gameObjects = new GameObject[4];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "resources/Sprites/main-menu-background.png");
        gameObjects[1] = new SceneSwitchButton(512, 400, 256, 64, "resources/Sprites/startgame-W128-H64.png", 1);
        gameObjects[2] = new SceneSwitchButton(512, 462, 256, 64, "resources/Sprites/exitgame-W128-H64.png", -1);
        gameObjects[3] = new GameImage(512, 300, 512, 128, "resources/Sprites/TheLastTurn.png");
    }

    public void init() {
        sound.play();
        for (GameObject gameObject : gameObjects) {
            gameObject.init();
        }
    }

    public void loop() {
        for (GameObject gameObject : gameObjects) {
            gameObject.loop();
            gameObject.draw();
        }
    }

    public void unInit() {
        sound.stop();
    }
}
