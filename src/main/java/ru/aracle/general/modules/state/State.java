package ru.aracle.general.modules.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class State {
    @Getter @Setter
    private int health;
    @Getter @Setter
    private int arcana;
    @Getter @Setter
    private int endurance;

    @Accessors
    public static class Constructor {
        int health = 0;
        int arcana = 0;
        int endurance = 0;

        public Constructor health(int health) { this.health = health; return this; }
        public Constructor arcana(int arcana) { this.arcana = arcana; return this; }
        public Constructor endurance(int endurance) { this.endurance = endurance; return this; }

        public State construct() { return new State(health, arcana, endurance); }
    }
}
