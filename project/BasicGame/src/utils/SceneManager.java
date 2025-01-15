package utils;

import GameObjects.Player;
import Scenes.GameScene;
import Scenes.MenuScene;
import nl.saxion.app.SaxionApp;

public final class SceneManager {
    private static SceneManager instance;

    private Scene menuScene;
    private Scene currentScene;

    public Player player;

    public static SceneManager getInstance() {
        if (instance == null)
            instance = new SceneManager();

        return instance;
    }

    public SceneManager(){
        currentScene = new MenuScene();
        currentScene.init();
    }

    public void loop(){
        SaxionApp.clear();
        currentScene.loop();
    }

    public void newGame(){
        player = new Player(110, 260, 100, 153);
        currentScene.unInit();
        currentScene = new GameScene(player, 1);
        currentScene.init();
    }

    public void nextLevel(){
        currentScene.unInit();
        currentScene = new GameScene(player, 1);
        currentScene.init();
    }
}

