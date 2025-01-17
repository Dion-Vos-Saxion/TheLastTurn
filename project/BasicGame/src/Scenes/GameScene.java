package Scenes;

import Enemies.Bat;
import Enemies.Minotaur;
import Items.*;
import Enemies.Skeleton;
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

    private BaseEnemy[] enemies = new BaseEnemy[]{
            new Minotaur(600, 100, 400, 400),
            new Skeleton(750, 260, 150, 150),
            new Bat(750, 260, 150, 150)
    };

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

        Random random = new Random();

        this.level = level;
        this.player = player;
        enemy = enemies[random.nextInt(enemies.length)];

        enemy.health += (enemy.health / 10) * level;
        System.out.println(enemy.health);

        items = new BaseItem[]{
                new BasicHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new BasicChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new BasicTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new BasicWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),

                new CommonHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new CommonChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new CommonTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new CommonWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),

                new UncommonHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new UncommonChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new UncommonTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new UncommonWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),

                new RareHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new RareChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new RareTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new RareWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),

                new EpicHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new EpicChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new EpicTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new EpicWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),

                new LegendaryHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new LegendaryChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new LegendaryTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new LegendaryWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),

                new MythicHeadpiece(player.UISlots[0][0], player.UISlots[0][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new MythicChestArmor(player.UISlots[1][0], player.UISlots[1][1], player.UIButtonsSize[0], player.UIButtonsSize[1]),
                new MythicTrousers(player.UISlots[2][0], player.UISlots[2][1], player.UIButtonsSize[0],player.UIButtonsSize[1]),
                new MythicWeapon(player.UISlots[3][0], player.UISlots[3][1], player.UIButtonsSize[0], player.UIButtonsSize[1])
        };

        optionOne = items[random.nextInt(items.length)];
        do {
            optionTwo = items[random.nextInt(items.length)];
        } while (optionOne == optionTwo);

        choiceOne = new ItemChoice(50, 650, optionOne);
        choiceTwo = new ItemChoice(550, 650, optionTwo);
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
        player.stamina = player.maxStamina;
        player.health = player.maxHealth;
        player.staminaBar.updateCurrent(player.stamina);
        player.healthBar.updateCurrent(player.health);
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
        SaxionApp.drawText("Level reached: " + Integer.toString(SceneManager.getInstance().level), 420, 700, 24);
        exit.loop();
        exit.draw();
        startGame.loop();
        startGame.draw();
    }

    public void DrawWin() {
        endTurnButton.x = -100;
        SaxionApp.drawText("Victory!",375, 500, 90);
        SaxionApp.drawText("choose your prize",375, 600, 40);
        SaxionApp.drawText("current gear", 425, 775, 30);
        SaxionApp.setTextDrawingColor(Color.WHITE);
        for (int i = 0; i < player.items.length; i++){
            if (player.items[i].type.equalsIgnoreCase(choiceOne.item.type)){
                SaxionApp.setTextDrawingColor(Color.WHITE);
                SaxionApp.setFill(Color.BLACK);
                int x = 50;
                int y = 750;
                SaxionApp.drawRectangle(x, y, 300, 100);
                SaxionApp.drawText(player.items[i].name, x + 10, y + 10, 30);

                SaxionApp.setTextDrawingColor(Color.GRAY);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.defense), x+ 95, y+ 60, 24);
                SaxionApp.setTextDrawingColor(Color.RED);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.attack), x + 135, y+ 60, 24);
                SaxionApp.setTextDrawingColor(Color.BLUE);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.staminaCost), x + 165, y + 60, 24);
                SaxionApp.setTextDrawingColor(Color.WHITE);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.hitChance) + "%", x + 185, y + 60, 24);
            }
            if (player.items[i].type.equalsIgnoreCase(choiceTwo.item.type)){
                SaxionApp.setTextDrawingColor(Color.WHITE);
                SaxionApp.setFill(Color.BLACK);
                int x = 650;
                int y = 750;
                SaxionApp.drawRectangle(x, y, 300, 100);
                SaxionApp.drawText(player.items[i].name, x + 10, y + 10, 30);

                SaxionApp.setTextDrawingColor(Color.GRAY);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.defense), x+ 95, y+ 60, 24);
                SaxionApp.setTextDrawingColor(Color.RED);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.attack), x + 135, y+ 60, 24);
                SaxionApp.setTextDrawingColor(Color.BLUE);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.staminaCost), x + 165, y + 60, 24);
                SaxionApp.setTextDrawingColor(Color.WHITE);
                SaxionApp.drawText(Integer.toString(player.items[i].ability.hitChance) + "%", x + 185, y + 60, 24);
            }
        }

        choiceOne.loop();
        choiceTwo.loop();
        choiceOne.draw();
        choiceTwo.draw();

        NextFight nextfight = new NextFight(512, 950, 256, 64, "resources/Sprites/startgame-W128-H64.png");

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
