package Enemies;

import utils.Animator;
import utils.BaseEnemy;

public class Minotaur extends BaseEnemy {
    private Animator animator; // Animator voor idle animatie

    public Minotaur(int x, int y, int width, int height) {
        // Stel de basis parameters van het object in
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // Stel basiswaarden in voor de Minotaur
        health = 100; // Stel gezondheid in
        enemyName = "Minotaur";
        attacks = new int[]{11, 5, 3};
        blocks = new int[]{22, 2, 7};

        // Stel het sprite pad in voor de idle frame van de Minotaur
        sprite = "resources/Sprites/Enemies/Minotaur/Idle/minotaur-idle1.png";

        // Definieer de frames voor de idle animatie
        String[] idleFrames = {
                "resources/Sprites/Enemies/Minotaur/Idle/minotaur-idle1.png",
                "resources/Sprites/Enemies/Minotaur/Idle/minotaur-idle2.png"
        };

        // Initialiseer de Animator voor de Minotaur met de juiste frames en vertraging
        animator = new Animator(x, y, width, height, idleFrames, 20); // 20 is de frame delay
    }

    @Override
    public void init() {
        // Eventuele extra initialisatie kan hier gebeuren
    }

    @Override
    public void loop() {
        // Update de animatie bij elke loop
        animator.loop();
        healthBar.loop();
    }

    @Override
    public void draw() {
        // Teken de animatie via de animator
        animator.draw();
    }
}
