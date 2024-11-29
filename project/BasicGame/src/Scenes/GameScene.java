package Scenes;
import utils.GameObject;
import utils.Scene;
import GameObjects.*;

public class GameScene extends Scene{
    private final Player player;

    public GameScene() {
        gameObjects = new GameObject[0];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "");
//        this.player = player;
//        this.enemies = enemies;

        player = new Player(200, 200, 200, 200, "");
    }

    public void init(){

    }

    public void loop(){

    }

    public void unInit(){

    }

    private class PlayerTurn extends GameObject{

        Player player;

        public PlayerTurn(Player player) {
            this.player = player;
        }

        public void init() {

        }

        public void loop() {

        }
    }
}
