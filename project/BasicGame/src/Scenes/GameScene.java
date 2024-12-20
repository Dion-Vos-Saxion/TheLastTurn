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
        playerTurn = new PlayerTurn(player);
        enemyTurn = new EnemyTurn(player);
        currentTurn = playerTurn;

        this.level = level;
        enemy = new Minotaur(550, 30, 500, 500); // Minotaur wordt hier toegevoegd

        endTurnButton = new EndTurnButton(900, 900, 152, 68, "resources/Sprites/UI elements/End turn Button.png");
        gameObjects = new GameObject[4];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "resources/Sprites/Fight-Background-1.png");
        gameObjects[1] = endTurnButton;
        gameObjects[2] = player;
        gameObjects[3] = enemy; // Voeg de Minotaur toe aan de gameobjecten

        this.player = player;
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

    private class PlayerTurn extends Turn {
        BaseEnemy enemy;
        Player player;

        public PlayerTurn(Player player) {
            this.player = player;
        }

        public void StartTurn() {
            player.LoseBlock();
        }

        public void loop() {
            for (BaseItem item : player.items) {
                if (MouseHandler.getInstance().clicked(item.x, item.y, item.width, item.height)) {
                    enemy.TakeDamage(item.ability.attack);
                    player.GainBlock(item.ability.defense);
                    System.out.println("Damaging enemy using " + item.ability.name);
                }
            }

            if (endTurnButton.pressed()) {
                currentTurn.NextTurn();
            }

            //if enemy is dead change scene
        }

        public void NextTurn() {
            currentTurn = enemyTurn;
        }
    }

    private class EnemyTurn extends Turn {
        Player player;
        BaseEnemy enemy;

        public EnemyTurn(Player player) {
            this.player = player;
        }

        public void StartTurn() {
            // Logica voor de vijand zijn beurt
        }

        public void loop() {
            //damage player
            System.out.println("Enemy Turn");
            NextTurn();
        }

        public void NextTurn() {
            currentTurn = playerTurn;
        }
    }
}
