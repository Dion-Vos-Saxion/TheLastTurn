package Scenes;

import Enemies.Minotaur;
import nl.saxion.app.SaxionApp;
import utils.*;
import GameObjects.*;

public class GameScene extends Scene {
    private Player player;
    private BaseEnemy enemy;
    private EndTurnButton endTurnButton;
    private Turn currentTurn;
    private Turn playerTurn;
    private Turn enemyTurn;
    private int level;

    public GameScene(Player player, int level) {
        playerTurn = new PlayerTurn();
        enemyTurn = new EnemyTurn();
        currentTurn = playerTurn;

        this.level = level;
        this.player = player;
        enemy = new Minotaur(600, 300, 300, 300);

        endTurnButton = new EndTurnButton(840, 940, 152, 68, "resources/Sprites/UI elements/End turn Button.png");
        gameObjects = new GameObject[4];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "resources/Sprites/Fight-Background-1.png");
        gameObjects[1] = endTurnButton;
        gameObjects[2] = player;
        gameObjects[3] = enemy;


    }

    public void init() {
        // Eventuele extra initialisatie kan hier gebeuren
    }

    public void loop() {
        for (GameObject gameObject : gameObjects) {
            gameObject.loop(); // Roep de loop methode aan om logica van elk object uit te voeren
            gameObject.draw(); // Roep de draw methode aan om het object te tekenen
        }
        currentTurn.loop();
    }

    public void unInit() {
        // Eventuele opruim acties kunnen hier worden gedaan
    }

    private abstract class Turn {
        public abstract void StartTurn();
        public abstract void loop();
        public abstract void NextTurn();
    }

    private class PlayerTurn extends Turn{


        public void StartTurn(){
            player.LoseBlock();
            player.RegainStamina();
            player.staminaBar.updateCurrent(player.stamina);
        }

        public void loop() {
            for (BaseItem item : player.items) {
                if (MouseHandler.getInstance().clicked(item.x, item.y, item.width, item.height) && player.stamina >= item.ability.staminaCost){
                    player.stamina -= item.ability.staminaCost;
                    player.staminaBar.updateCurrent(player.stamina);
                    System.out.println(player.stamina);
                    if (!item.ability.doesHit())
                        return;
                    if (item.ability.attack > 0)
                        enemy.TakeDamage(item.ability.attack);
                    if (item.ability.defense > 0)
                        player.GainBlock(item.ability.defense);
                    System.out.println("using " + item.ability.name + " with " + item.ability.attack + " attack and " + item.ability.defense + " defense");
                }
            }

            if (endTurnButton.pressed()) {
                currentTurn.NextTurn();
            }

            //if enemy is dead change scene
        }

        public void NextTurn() {
            currentTurn = enemyTurn;
            currentTurn.StartTurn();
        }
    }

    private class EnemyTurn extends Turn{

        public void StartTurn(){

        }

        public void loop() {
            //damage player
            System.out.println("Enemy Turn");
            NextTurn();
        }

        public void NextTurn() {
            currentTurn = playerTurn;
            currentTurn.StartTurn();
        }
    }
}
