package utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import utils.FontUtils;

public class FontUtils {

    private static Font customFont;

    public static void loadCustomFont() {
        if (customFont != null) return;  // Prevent double loading

        try {
            File fontFile = new File("resources/Fonts/Pixellettersfull-BnJ5.ttf");
            if (fontFile.exists()) {
                customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            } else {
                System.out.println("Font file not found at: " + fontFile.getAbsolutePath());
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            System.out.println("Could not load custom font.");
        }
    }
}
