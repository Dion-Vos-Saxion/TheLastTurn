package utils;

import GameObjects.Player;
import Scenes.GameScene;
import Scenes.MapScene;
import Scenes.MenuScene;
import nl.saxion.app.SaxionApp;

public class SoundManager {
    public static void play(String filename) {
        SaxionApp.playSound(filename);
    }

    public static void stop() {
        SaxionApp.playSound("resources/music/silence.wav");
    }

    public static void setVolume(float volume) {

    }
}
