package utils;

import Scenes.GameScene;
import Scenes.MenuScene;

public class SceneManager {
    private Scene[] scenes = new Scene[2];
    private Scene currentScene;
    public SceneManager(){
        scenes[0] = new MenuScene();
        scenes[1] = new GameScene();

        currentScene = scenes[0];
    }

    public void loop(){
        if (currentScene != null)
            currentScene.loop();
    }

    public void switchScene(int index){
        currentScene = scenes[index];
    }
}
