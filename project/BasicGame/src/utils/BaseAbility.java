package utils;

import java.util.Random;

public class BaseAbility {
    public String name;
    public int attack;
    public int defense;
    public int staminaCost;
    public int hitChance;
    public String image;

    public BaseAbility(String name, int attack, int defense, int staminaCost, int hitChance, String image) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.staminaCost = staminaCost;
        this.hitChance = hitChance;
        this.image = image;
    }

    public boolean doesHit() {
        Random random = new Random();
        int randomValue = random.nextInt(100);
        return randomValue < hitChance;
    }
}
