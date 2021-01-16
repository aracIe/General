package ru.aracle.general.modules.player;

import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Accessors
public class PlayerManager {
    private static Map<UUID, Data> users = new HashMap<>();
    public static Map<UUID, Data> users() {
        return users;
    }
}
