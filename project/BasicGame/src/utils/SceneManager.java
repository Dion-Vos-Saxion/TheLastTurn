package utils;

import Scenes.GameScene;
import Scenes.MenuScene;
import nl.saxion.app.SaxionApp;

public final class SceneManager {
    private static SceneManager instance;

    private Scene[] scenes = new Scene[2];
    private Scene currentScene;

    public static SceneManager getInstance() {
        if (instance == null)
            instance = new SceneManager();

        return instance;
    }

    public SceneManager(){
        scenes[0] = new MenuScene();
        scenes[1] = new GameScene();

        currentScene = scenes[0];
    }

    public void loop(){
        currentScene.loop();
    }

    public void switchScene(int index){
        SaxionApp.clear();
        currentScene = scenes[index];
        currentScene.init();
    }
}

