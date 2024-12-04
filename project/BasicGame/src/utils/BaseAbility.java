package utils;

public class BaseAbility {
    String name;
    int attack;
    int defense;
    int staminaCost;

    public BaseAbility(String name, int attack, int defense, int staminaCost){
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.staminaCost = staminaCost;
    }
}
