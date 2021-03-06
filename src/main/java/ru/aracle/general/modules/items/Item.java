package ru.aracle.general.modules.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Item {
    @Getter @Setter
    private String iid;
    @Getter @Setter
    private String type;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private String attack_speed;
    @Getter @Setter
    private String element;
    @Getter @Setter
    private String fraction;
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

    @Accessors
    public static class Constructor {
        String iid = "ItemID";
        String type = "ItemType";
        String name = "ItemName";
        String description = "Explorer";
        String attack_speed = "normal";
        String element = "none";
        String fraction = "none";
        int attack_damage = 0;
        int defence = 0;
        int health = 0;
        int arcana = 0;
        int endurance = 0;

        public Constructor iid(String iid) { this.iid = iid; return this; }
        public Constructor type(String type) { this.type = type; return this; }
        public Constructor name(String name) { this.name = name; return this; }
        public Constructor description(String description) { this.description = description; return this; }
        public Constructor attack_speed(String attack_speed) { this.attack_speed = attack_speed; return this; }
        public Constructor element(String element) { this.element = element; return this; }
        public Constructor fraction(String fraction) { this.element = fraction; return this; }
        public Constructor attack_damage(int attack_damage) { this.attack_damage = attack_damage; return this; }
        public Constructor defence(int defence) { this.defence = defence; return this; }
        public Constructor health(int health) { this.health = health; return this; }
        public Constructor arcana(int arcana) { this.arcana = arcana; return this; }
        public Constructor endurance(int endurance) { this.endurance = endurance; return this; }

        public Item construct() { return new Item(iid, type, name, description, attack_speed, element, fraction, attack_damage, defence, health, arcana, endurance); }
    }

}
