package Scenes;

import Enemies.Minotaur;
import Items.BasicChestArmor;
import Items.BasicHeadpiece;
import Items.BasicTrousers;
import Items.BasicWeapon;
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

    private BaseItem[] items;
    private BaseItem optionOne;
    private BaseItem optionTwo;
    GameImage[] backgrounds = new GameImage[]{
            new GameImage(512, 512, 1024, 1024, "resources/Sprites/UI elements/Fight-Backgrounds/Fight-Background-1.png", "One"),
            new GameImage(512, 512, 1024, 1024, "resources/Sprites/UI elements/Fight-Backgrounds/Fight-Background-2.png", "Two"),
            new GameImage(512, 512, 1024, 1024, "resources/Sprites/UI elements/Fight-Backgrounds/Fight-Background-3.png", "Three"),
    };

    private ItemChoice choiceOne;
    private ItemChoice choiceTwo;

    public GameScene(Player player, int level) {
        playerTurn = new PlayerTurn();
        enemyTurn = new EnemyTurn();
        currentTurn = playerTurn;

        this.level = level;
        this.player = player;
        enemy = new Minotaur(600, 100, 400, 400);

        items = new BaseItem[]{
                new BasicHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new BasicChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new BasicTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new BasicWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1])
        };

        Random random = new Random();
        optionOne = items[random.nextInt(items.length)];
        do {
            optionTwo = items[random.nextInt(items.length)];
        } while (optionOne == optionTwo);

        choiceOne = new ItemChoice(200, 800, optionOne);
        choiceTwo = new ItemChoice(700, 800, optionTwo);
        choiceOne.setOtherItem(choiceTwo);
        choiceTwo.setOtherItem(choiceOne);

        Vuurtje vuurtje1 = null;
        Vuurtje vuurtje2 = null;

        GameImage background = backgrounds[random.nextInt(backgrounds.length)];

        switch (background.name) {
            case "One":
                vuurtje1 = new Vuurtje(375, -72);
                vuurtje2 = new Vuurtje(840, -2);
                break;
            case "Two":
                vuurtje1 = new Vuurtje(841, 40);
                vuurtje2 = new Vuurtje(65, 42);
                break;
            default:
                vuurtje1 = new Vuurtje(30000000, 1000000000);
                vuurtje2 = new Vuurtje(10000000, 100000000);
                break;
        }

        endTurnButton = new EndTurnButton(840, 940, 152, 68, "resources/Sprites/UI elements/End turn Button.png");

       gameObjects = new GameObject[]{background, endTurnButton, player, enemy, vuurtje1, vuurtje2};
    }

    public void init() {
        sound.play();
    }

    public void loop() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject != null) {
                gameObject.loop();
                gameObject.draw();
            }
        }

        if (player.health <= 0)
            DrawGameOver();
        if (enemy.health <= 0)
            DrawWin();

        if (enemy.health > 0 && player.health > 0) {
            player.DrawBottomUI();
        }

        currentTurn.loop();
    }

    public void unInit() {
        sound.stop();
    }

    public void DrawGameOver() {
        endTurnButton.x = -100;
        SaxionApp.drawImage("resources/Sprites/UI elements/GameOverText.png", 350, 650, 338, 35);
        SceneSwitchButton exit = new SceneSwitchButton(512, 900, 256, 64, "resources/Sprites/exitgame-W128-H64.png", -1);
        SceneSwitchButton startGame = new SceneSwitchButton(512, 800, 256, 64, "resources/Sprites/startgame-W128-H64.png", 1);
        exit.loop();
        exit.draw();
        startGame.loop();
        startGame.draw();
    }

    public void DrawWin() {
        endTurnButton.x = -100;
        SaxionApp.drawText("Victory!", 275, 600, 90);
        SaxionApp.drawText("choose your prize", 250, 700, 40);

        choiceOne.loop();
        choiceTwo.loop();
        choiceOne.draw();
        choiceTwo.draw();

        NextFight nextfight = new NextFight(512, 800, 256, 64, "resources/Sprites/startgame-W128-H64.png");

        if (choiceOne.chosen)
            nextfight.item = choiceOne.item;
        if (choiceTwo.chosen)
            nextfight.item = choiceTwo.item;

        nextfight.loop();
        nextfight.draw();
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
        }

        public void NextTurn() {
            currentTurn = enemyTurn;
            currentTurn.StartTurn();
            enemy.LoseBlock();
        }
    }

    private class EnemyTurn extends Turn {
        public void StartTurn() {}

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
