package Scenes;

import GameObjects.*;
import nl.saxion.app.SaxionApp;
import utils.*;
import java.util.Random;

// Het idee van jou dat we op play drukken en dan beginnen op een tutorial level met daarna andere levels die "random" zijn leek mij beter dan een minimap maken.
// Bij die levels als ze random zijn kan je dan ook wel items implementeren (items die worden gegeven na het verslaan van mobs/bosses of een wave van mobs.)
// Ligt eraan wat jullie leuker/gemakkelijker vinden

// Create a starting tutorial method
// Create a method that shows whether the enemy is defeated or not
// Create a random level generator (!)
// Create a ending screen method

// Difficulty could be implemented later
// Some of these could use a bit of other classes ( like gamescene )


public class MapScene extends Scene{

    private boolean isTutorialCompleted;
    private int currentLevel;
    private boolean gameCompleted;
    private final int maxLevels;
    private Random random;

    public MapScene() {
        gameObjects = new GameObject[1];
        gameObjects[0] = new GameImage(512, 512, 1024,1024, "");
        isTutorialCompleted = false;
        currentLevel = 0;
        maxLevels = 5;
        gameCompleted = false;
        random = new Random();
    }

    private boolean allEnemiesDefeated() {
        for (GameObject obj : gameObjects) {
            if (obj instanceof BaseEnemy)
                return false;
        }
        return true;
    }

    private void startTutorial() {
        System.out.println("Starting tutorial. . .");
        gameObjects= new GameObject[]{
                new GameImage(512, 512, 1024,1024, "resources/Sprites/tutorial-background.png"),
                new GameImage(256, 256, 512, 512, "resources/Sprites/tutorial")

                // maybe change it to only one tutorial image
                // SOMEONE PLEASE MAKE THE TUTORIAL IMAGE THANKS !!
                // could be changed to a button in game !
        };
    }

    private void generateRandomLevel() {
        currentLevel++;
        System.out.println("Generating random level. . .");

        // add enemies ( I have no idea how im supposed to implement these )
        // int amountEnemies = random.nextInt(...) ( int needs to be between 0 and ... )
        // gameObjects[] = new gameImage ( enemy image ) + player image
        // think its best i add onto it the gamescene instead
        // maybe add random item stats idk
    }

    private void runRandomLevel() {
        if (allEnemiesDefeated()) {
            SaxionApp.print("Level " + currentLevel + " completed!");
            if (currentLevel < maxLevels) {
                generateRandomLevel();
            } else {
                showEndingScreen();
                gameCompleted = true;
            }
        }
    }

    private void showEndingScreen() {
        System.out.println("Showing ending screen. . .");
        gameObjects = new GameObject[]{
                new GameImage(512, 512, 1024,1024, "resources/Sprites/ending-background.png"),
                new GameImage(256, 256, 512, 512, "resources/Sprites/ending")
        };
        // probably should add an exit button to this or make it automatically exit
        // no textures as of now btw
    }


    @Override
    public void init() {
        if (!isTutorialCompleted) {
            startTutorial();
            SaxionApp.sleep(30);
            isTutorialCompleted = true;
            if (currentLevel < maxLevels) {
                generateRandomLevel();
            } else {
                showEndingScreen();
                gameCompleted = true;
            }
        }
        // should probably add a skip button lol
    }

    @Override
    public void loop() {
    // while gameScene() is initialized
        // implement
        if (!isTutorialCompleted) {
            System.out.println("Game scene is being initialized. . .");
        } else if (!gameCompleted) {
            System.out.println("Running level " + currentLevel);
            runRandomLevel();
        }
    }

    @Override
    public void unInit() {
        gameObjects = new GameObject[0];
        System.out.println("Game scene is being uninitialized. . .");
    }
}
