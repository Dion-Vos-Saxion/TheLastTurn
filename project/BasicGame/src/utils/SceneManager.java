package utils;

import GameObjects.Player;
import Scenes.GameScene;
import Scenes.MenuScene;
import nl.saxion.app.SaxionApp;

public final class SceneManager {
    private static SceneManager instance;

    private  Scene menuScene;
    private Scene currentScene;

    private Player player;

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
        currentScene = new GameScene(player, 1);
    }

    public void nextLevel(){
        currentScene = new GameScene(player, 1);
    }
}

