package Scenes;
import GameObjects.*;
import utils.*;

public class MapScene extends Scene{

    public MapScene() {
        gameObjects = new GameObject[12];
        gameObjects[0] = new GameImage(512, 512, 1024,1024, "");

    }


    @Override
    public void init() {
    // new gameScene() every level level
    }

    @Override
    public void loop() {
    // while gameScene() is initialized
        // implement
    }
}
