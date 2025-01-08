package GameObjects;

import utils.Animator;
import utils.GameObject;

public class Vuurtje extends GameObject {
    private Animator fireAnimator;

    public Vuurtje(int x, int y) {
        // Vuuranimatieframes
        String[] fireFrames = new String[] {
                "resources/Sprites/Fire/vuur1.png",
                "resources/Sprites/Fire/vuur2.png",
                "resources/Sprites/Fire/vuur3.png",
                "resources/Sprites/Fire/vuur4.png",
                "resources/Sprites/Fire/vuur5.png",
                "resources/Sprites/Fire/vuur6.png",
                "resources/Sprites/Fire/vuur7.png",
                "resources/Sprites/Fire/vuur8.png",
                "resources/Sprites/Fire/vuur9.png",
                "resources/Sprites/Fire/vuur10.png",
                "resources/Sprites/Fire/vuur11.png",
                "resources/Sprites/Fire/vuur12.png",
                "resources/Sprites/Fire/vuur13.png",
                "resources/Sprites/Fire/vuur14.png",
                "resources/Sprites/Fire/vuur15.png",
                "resources/Sprites/Fire/vuur16.png",
                "resources/Sprites/Fire/vuur17.png",
                "resources/Sprites/Fire/vuur18.png",
                "resources/Sprites/Fire/vuur19.png",
        };

        // Initialiseer de Animator voor de vuuranimatie
        fireAnimator = new Animator(x, y, 128, 128, fireFrames, 5);  // Positie (x, y), grootte 64x64, frames, framevertraging

    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        fireAnimator.loop();  // Vuuranimatie bijwerken
    }

    @Override
    public void draw() {
        fireAnimator.draw();  // Vuuranimatie tekenen
    }
}
