package ru.aracle.general.modules.state;

import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Accessors
public class StateManager {
    private static Map<UUID, State> users = new HashMap<>();
    public static Map<UUID, State> users() {
        return users;
    }
}
