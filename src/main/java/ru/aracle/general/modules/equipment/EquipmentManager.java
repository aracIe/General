package ru.aracle.general.modules.equipment;

import lombok.experimental.Accessors;
import ru.aracle.general.modules.statistics.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Accessors
public class EquipmentManager {
    private static Map<UUID, Equipment> users = new HashMap<>();
    public static Map<UUID, Equipment> users() {
        return users;
    }
}
