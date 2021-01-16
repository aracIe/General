package ru.aracle.general.modules.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Data {
    @Getter @Setter
    private int level;
    @Getter @Setter
    private int xp;
    @Getter @Setter
    private int health;
    @Getter @Setter
    private int arcana;
    @Getter @Setter
    private int endurance;
    @Getter @Setter
    private String fraction;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String skin;

    @Accessors
    public static class Constructor {
        int level = 1;
        int xp = 0;
        int health = 50;
        int arcana = 5;
        int endurance = 5;
        String fraction = "none";
        String name = "Explorer";
        String skin = "default";

        public Constructor level(int level) { this.level = level; return this; }
        public Constructor xp(int xp) { this.xp = xp; return this; }
        public Constructor health(int health) { this.health = health; return this; }
        public Constructor arcana(int arcana) { this.arcana = arcana; return this; }
        public Constructor endurance(int endurance) { this.endurance = endurance; return this; }
        public Constructor fraction(String fraction) { this.fraction = fraction; return this; }
        public Constructor name(String name) { this.name = name; return this; }
        public Constructor skin(String skin) { this.skin = skin; return this; }

        public Data construct() { return new Data(level, xp, health, arcana, endurance, fraction, name, skin); }
    }
}
