package ru.aracle.general.modules.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Statistics {
    @Getter @Setter
    private int wins;
    @Getter @Setter
    private int defeats;
    @Getter @Setter
    private int kills;
    @Getter @Setter
    private int deaths;
    @Getter @Setter
    private int dungeons;
    @Getter @Setter
    private int prestige;

    @Accessors
    public static class Constructor {
        int wins = 0;
        int defeats = 0;
        int kills = 0;
        int deaths = 0;
        int dungeons = 0;
        int prestige = 0;

        public Constructor wins(int wins) { this.wins = wins; return this; }
        public Constructor defeats(int defeats) { this.defeats = defeats; return this; }
        public Constructor kills(int kills) { this.kills = kills; return this; }
        public Constructor deaths(int deaths) { this.deaths = deaths; return this; }
        public Constructor dungeons(int dungeons) { this.dungeons = dungeons; return this; }
        public Constructor prestige(int prestige) { this.prestige = prestige; return this; }

        public Statistics construct() { return new Statistics(wins, defeats, kills, deaths, dungeons, prestige); }

    }

}
