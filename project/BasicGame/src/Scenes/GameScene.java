package Scenes;

import Enemies.Minotaur;
import nl.saxion.app.SaxionApp;
import utils.*;
import GameObjects.*;

import java.awt.*;
import java.util.Random;

public class GameScene extends Scene {
    private Player player;
    private BaseEnemy enemy;
    private EndTurnButton endTurnButton;
    private Turn currentTurn;
    private Turn playerTurn;
    private Turn enemyTurn;
    private int level;
    Sound sound = new Sound("resources/Sounds/CombatBackgroundMusic.wav");
    Sound attackSound = new Sound("resources/Sounds/attackSound.wav");
    Sound blockSound = new Sound("resources/Sounds/blockSound.wav");

    GameImage[] backgrounds = new GameImage[]{
            new GameImage(512, 512, 1024, 1024, "resources/Sprites/UI elements/Fight-Backgrounds/Fight-Background-1.png"),
            new GameImage(512, 512, 1024, 1024, "resources/Sprites/UI elements/Fight-Backgrounds/Fight-Background-2.png"),
            new GameImage(512, 512, 1024, 1024, "resources/Sprites/UI elements/Fight-Backgrounds/Fight-Background-3.png")
    };

    public GameScene(Player player, int level) {
        playerTurn = new PlayerTurn();
        enemyTurn = new EnemyTurn();
        currentTurn = playerTurn;

        this.level = level;
        this.player = player;
        enemy = new Minotaur(600, 100, 400, 400);

        Random random = new Random();

        endTurnButton = new EndTurnButton(840, 940, 152, 68, "resources/Sprites/UI elements/End turn Button.png");
        gameObjects = new GameObject[6];
        gameObjects[0] = backgrounds[random.nextInt(backgrounds.length)];
        gameObjects[1] = endTurnButton;
        gameObjects[2] = player;
        gameObjects[3] = enemy;
        gameObjects[4] = new Vuurtje(375,-72);
        gameObjects[5] = new Vuurtje(840,-2);

    }

    public void init() {
        sound.play();
    }

    public void loop() {
        for (GameObject gameObject : gameObjects) {
            gameObject.loop();
            gameObject.draw();
        }

        DrawGameOver();

        currentTurn.loop();
        SaxionApp.stopSound("resources/Sounds/MenuBackgroundMusic.wav");
    }

    public void unInit() {
        sound.stop();
    }

    public void DrawGameOver() {
        if (player.health > 0)
            return;
        endTurnButton.x = -100;
        SaxionApp.drawText("Game Over",275, 600, 90);
        SceneSwitchButton exit = new SceneSwitchButton(512, 900,256, 64, "resources/Sprites/exitgame-W128-H64.png", -1);
        SceneSwitchButton startGame = new SceneSwitchButton(512, 800, 256, 64, "resources/Sprites/startgame-W128-H64.png", 1);
        exit.loop();
        exit.draw();
        startGame.loop();
        startGame.draw();
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
                    if (item.ability.attack > item.ability.defense)
                        attackSound.play();
                    else
                        blockSound.play();
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
