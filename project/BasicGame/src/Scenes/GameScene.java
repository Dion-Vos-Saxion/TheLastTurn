package Scenes;
import Enemies.Minotaur;
import nl.saxion.app.SaxionApp;
import utils.*;
import GameObjects.*;

public class GameScene extends Scene{
    private Player player;
    private BaseEnemy enemy;

    private EndTurnButton endTurnButton;
    private Turn currentTurn;
    private Turn playerTurn;
    private Turn enemyTurn;

    private int level;

    public GameScene(Player player, int level) {
        playerTurn = new PlayerTurn(player);
        enemyTurn = new EnemyTurn(player);
        currentTurn = playerTurn;

        //level later sets the enemy difficulty and which you can see.
        this.level = level;
        enemy = new Minotaur(200, 200, 200, 200);

        endTurnButton = new EndTurnButton(200, 200, 200, 200, "resources/Sprites/end-turn-placeholder.jpg");
        gameObjects = new GameObject[3];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "resources/Sprites/Fight-Background-1.png");
        gameObjects[1] = endTurnButton;
        gameObjects[2] = player;

        this.player = player;
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

        BaseEnemy enemy;
        Player player;

        public PlayerTurn(Player player) {
            this.player = player;
        }

        public void loop() {
            for (BaseItem item : player.items) {
                if (MouseHandler.getInstance().clicked(item.x, item.y, item.width, item.height)){
                    //enemy take damage
                    System.out.println("Damaging enemy using " + item.ability.name);
                }
            }

            if (endTurnButton.pressed())
                currentTurn.NextTurn();

            //if enemy is dead change scene
        }

        public void NextTurn() {
            currentTurn = enemyTurn;
        }
    }

    private class EnemyTurn extends Turn{
        Player player;
        BaseEnemy enemy;

        public EnemyTurn(Player player) {
            this.player = player;
        }

        public void loop() {
            //damage player
            System.out.println("Damaging player");
            NextTurn();
        }

        public void NextTurn() {
            currentTurn = playerTurn;
        }
    }
}
