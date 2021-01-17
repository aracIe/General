package ru.aracle.general.modules.items;

import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Accessors
public class ItemsManager {
    private static Map<String, Item> items = new HashMap<>();
    public static Map<String, Item> items() { return items; }
}
