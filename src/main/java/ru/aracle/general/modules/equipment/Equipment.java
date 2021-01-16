package ru.aracle.general.modules.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors
@AllArgsConstructor
public class Equipment {
    @Getter @Setter
    private int main;
    @Getter @Setter
    private int other;
    @Getter @Setter
    private int first;
    @Getter @Setter
    private int second;
    @Getter @Setter
    private int third;
    @Getter @Setter
    private int armor;

    @Accessors
    public static class Constructor {
        int main = 0;
        int other = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        int armor = 0;

        public Constructor main(int main) { this.main = main; return this; }
        public Constructor other(int other) { this.other = other; return this; }
        public Constructor first(int first) { this.first = first; return this; }
        public Constructor second(int second) { this.second = second; return this; }
        public Constructor third(int third) { this.third = third; return this; }
        public Constructor armor(int armor) { this.armor = armor; return this; }

        public Equipment construct() { return new Equipment(main, other, first, second, third, armor); }
    }
}
