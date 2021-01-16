package ru.aracle.general.modules.statistics;

import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Accessors
public class StatisticsManager {
    private static Map<UUID, Statistics> users = new HashMap<>();
    public static Map<UUID, Statistics> users() {
        return users;
    }
}
