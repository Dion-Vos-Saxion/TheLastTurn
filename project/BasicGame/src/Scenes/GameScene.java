package Scenes;

import Enemies.Minotaur;
import Enemies.Skeleton;
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
    Sound sound = new Sound("resources/Sounds/CombatBackgroundMusic.wav");


    public GameScene(Player player, int level) {
        playerTurn = new PlayerTurn();
        enemyTurn = new EnemyTurn();
        currentTurn = playerTurn;

        this.level = level;
        this.player = player;
        enemy = new Minotaur(600, 100, 400, 400);
//        enemy = new Skeleton(750, 260, 150, 150);

        endTurnButton = new EndTurnButton(840, 940, 152, 68, "resources/Sprites/UI elements/End turn Button.png");
        gameObjects = new GameObject[4];
        gameObjects[0] = new GameImage(512, 512, 1024, 1024, "resources/Sprites/Fight-Background-1.png");
        gameObjects[1] = endTurnButton;
        gameObjects[2] = player;
        gameObjects[3] = enemy;
    }

    public void init() {
        sound.play();
    }

    public void loop() {
        for (GameObject gameObject : gameObjects) {
            gameObject.loop();
            gameObject.draw();
        }
        currentTurn.loop();
        SaxionApp.stopSound("resources/Sounds/MenuBackgroundMusic.wav");
    }

    public void unInit() {
        sound.stop();
    }

    private abstract class Turn {
        public abstract void StartTurn();
        public abstract void loop();
        public abstract void NextTurn();
    }

    private class PlayerTurn extends Turn {
        public void StartTurn() {
            player.LoseBlock();
            player.RegainStamina();
            player.staminaBar.updateCurrent(player.stamina);
        }

        public void loop() {
            for (BaseItem item : player.items) {
                if (MouseHandler.getInstance().clicked(item.x, item.y, item.width, item.height) && player.stamina >= item.ability.staminaCost) {
                    player.stamina -= item.ability.staminaCost;
                    player.staminaBar.updateCurrent(player.stamina);
                    if (!item.ability.doesHit())
                        return;
                    if (item.ability.attack > 0)
                        enemy.TakeDamage(item.ability.attack);
                    if (item.ability.defense > 0)
                        player.GainBlock(item.ability.defense);
                }
            }

            if (endTurnButton.pressed()) {
                currentTurn.NextTurn();
            }

            if (enemy.IsDead()) {
            }
        }

        public void NextTurn() {
            currentTurn = enemyTurn;
            currentTurn.StartTurn();
            enemy.LoseBlock();
        }
    }

    private class EnemyTurn extends Turn {

        public void StartTurn() {

        }

        public void loop() {
            if (enemy.currentIsAttacking) {
                player.TakeDamage(enemy.currentActionAmount);
            } else {
                enemy.GainBlock(enemy.currentActionAmount);
            }
            NextTurn();
        }

        public void NextTurn() {
            currentTurn = playerTurn;
            currentTurn.StartTurn();
            enemy.NewAction();
        }
    }
}
