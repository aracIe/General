package ru.aracle.general.modules.inventory;

import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Accessors
public class InventoryManager {
    private static Map<UUID, Inventory> inventories = new HashMap<>();
    public static Map<UUID, Inventory> inventories() {
        return inventories;
    }
}
