package Scenes;
import nl.saxion.app.SaxionApp;
import utils.BaseItem;
import utils.GameObject;
import utils.MouseHandler;
import utils.Scene;
import GameObjects.*;

public class GameScene extends Scene{
//    private final Player player;
    private final EndTurnButton endTurnButton;
    private Turn currentTurn;
    private Turn playerTurn;
    private Turn enemyTurn;

    public GameScene(Player player) {
        playerTurn = new PlayerTurn(player, this);
        enemyTurn = new EnemyTurn(player, this);
        currentTurn = playerTurn;

        endTurnButton = new EndTurnButton(200, 200, 200, 200, "resources/Sprites/end-turn-placeholder.jpg");
        gameObjects = new GameObject[3];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "resources/Sprites/Fight-Background-1.png");
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

    private abstract class Turn{
        public abstract void loop();
        public abstract void NextTurn();
    }

    private class PlayerTurn extends Turn{

//        Enemy enemy
        Player player;
        GameScene gameScene;

        public PlayerTurn(Player player, GameScene gameScene) {
            this.player = player;
            this.gameScene = gameScene;
        }

        public void loop() {
            for (BaseItem item : player.items) {
                if (MouseHandler.getInstance().clicked(item.x, item.y, item.width, item.height)){
                    //enemy take damage
                    System.out.println("Damaging enemy using " + item.ability.name);
                }
            }

            if (gameScene.endTurnButton.pressed())
                currentTurn.NextTurn();
        }

        public void NextTurn() {
            gameScene.currentTurn = gameScene.enemyTurn;
        }
    }

    private class EnemyTurn extends Turn{
        Player player;
        GameScene gameScene;

        public EnemyTurn(Player player, GameScene gameScene) {
            this.player = player;
            this.gameScene = gameScene;
        }

        public void loop() {
            //damage player
            System.out.println("Damaging player");
            NextTurn();
        }

        public void NextTurn() {
            gameScene.currentTurn = gameScene.playerTurn;
        }
    }
}
