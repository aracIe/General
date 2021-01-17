package ru.aracle.general.modules.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Inventory {
    @Getter @Setter
    private String uuid;
    @Getter @Setter
    private String iid;
    @Getter @Setter
    private String rarity;
    @Getter @Setter
    private String fraction;
    @Getter @Setter
    private int power;
    @Getter @Setter
    private int level;
    @Getter @Setter
    private int first;
    @Getter @Setter
    private int second;
    @Getter @Setter
    private int third;
    @Getter @Setter
    private int attack_damage;
    @Getter @Setter
    private int defence;
    @Getter @Setter
    private int health;
    @Getter @Setter
    private int arcana;
    @Getter @Setter
    private int endurance;

    public static class Constructor {
        String uuid = "uuid";
        String iid = "iid";
        String rarity = "rarity";
        String fraction = "rarity";
        int power = 0;
        int level = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        int attack_damage = 0;
        int defence = 0;
        int health = 0;
        int arcana = 0;
        int endurance = 0;

        public Constructor uuid(String uuid) { this.uuid = uuid; return this; }
        public Constructor iid(String iid) { this.iid = iid; return this; }
        public Constructor rarity(String rarity) { this.rarity = rarity; return this; }
        public Constructor fraction(String fraction) { this.fraction = fraction; return this; }
        public Constructor power(int power) { this.power = power; return this; }
        public Constructor level(int level) { this.level = level; return this; }
        public Constructor first(int first) { this.first = first; return this; }
        public Constructor second(int second) { this.second = second; return this; }
        public Constructor third(int third) { this.third = third; return this; }
        public Constructor attack_damage(int attack_damage) { this.attack_damage = attack_damage; return this; }
        public Constructor defence(int defence) { this.defence = defence; return this; }
        public Constructor health(int health) { this.health = health; return this; }
        public Constructor arcana(int arcana) { this.arcana = arcana; return this; }
        public Constructor endurance(int endurance) { this.endurance = endurance; return this; }

        public Inventory construct() { return new Inventory(uuid, iid, rarity, fraction, power, level, first, second, third, attack_damage, defence, health, arcana, endurance); }
    }
}
