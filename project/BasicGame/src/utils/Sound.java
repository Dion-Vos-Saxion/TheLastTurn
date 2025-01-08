package utils;

import nl.saxion.app.SaxionApp;

public class SoundManager {
    private static boolean isPlaying = false;
    private static String currentSound = "";

    public static void play(String filename) {
        if (!isPlaying || !filename.equals(currentSound)) {
            stop();
            SaxionApp.playSound(filename, true);
            currentSound = filename;
            isPlaying = true;
        }
    }

    public static void stop() {
        if (isPlaying) {
            SaxionApp.stopAllSounds();
            isPlaying = false;
            currentSound = "";
        }
    }
}
