package utils;

import Scenes.GameScene;
import Scenes.MenuScene;
import nl.saxion.app.SaxionApp;

public final class SceneManager {
    private static SceneManager instance;

    private  final Scene[] scenes = new Scene[2];
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
        currentScene.init();
    }

    public void loop(){
        SaxionApp.clear();
        currentScene.loop();
    }

    public void switchScene(int index){
        currentScene.unInit();
        currentScene = scenes[index];
        currentScene.init();
    }
}

