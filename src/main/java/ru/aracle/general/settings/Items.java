package ru.aracle.general.settings;

import org.bukkit.configuration.file.FileConfiguration;
import ru.aracle.general.Core;

import java.io.File;
import java.io.IOException;

public class Items {
    public static void load() {
        File items = Core.instance().items;
        FileConfiguration configuration = Core.instance().itemsConfiguration;
        if (!items.exists()) {
            configuration.set("DefaultItem.type","ItemType");
            configuration.set("DefaultItem.name","ItemName");
            configuration.set("DefaultItem.description","ItemDescription");
            configuration.set("DefaultItem.attack_speed", 0);
            configuration.set("DefaultItem.attack_damage", 0);
            configuration.set("DefaultItem.defence", 0);
            configuration.set("DefaultItem.health", 0);
            configuration.set("DefaultItem.arcana", 0);
            configuration.set("DefaultItem.endurance", 0);
            try { configuration.save(items); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
}
