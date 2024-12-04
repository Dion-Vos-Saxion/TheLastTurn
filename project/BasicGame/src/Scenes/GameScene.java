package Scenes;
import utils.BaseItem;
import utils.GameObject;
import utils.MouseHandler;
import utils.Scene;
import GameObjects.*;

public class GameScene extends Scene{
//    private final Player player;
    private final EndTurnButton endTurnButton;
    private GameObject currentTurn;

    public GameScene(Player player) {
        currentTurn = new PlayerTurn(player);
        endTurnButton = new EndTurnButton(200, 200, 200, 200, "resources/Sprites/TheLastTurn.png");
        gameObjects = new GameObject[3];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "resources/Sprites/TheLastTurn.png");
        gameObjects[1] = endTurnButton;
        gameObjects[2] = player;

//        this.player = player;
//        this.enemies = enemies;
    }

    public void init(){

    }

    public void loop(){
        for (GameObject gameObject : gameObjects)
            gameObject.loop();
        currentTurn.loop();
    }

    public void unInit(){

    }

    private class PlayerTurn extends GameObject{

//        Enemy enemy
        Player player;

        public PlayerTurn(Player player) {
            this.player = player;
        }

        public void init() {

        }

        public void loop() {
            for (BaseItem item : player.items) {
                if (MouseHandler.getInstance().clicked(item.x, item.y, item.width, item.height)){

                }
            }
        }
    }
}
