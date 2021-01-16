package ru.aracle.general.settings;

import org.bukkit.configuration.file.FileConfiguration;
import ru.aracle.general.Core;

import java.io.File;
import java.io.IOException;

public class Settings {
    public static void load() {
        File settings = Core.instance().settings;
        FileConfiguration configuration = Core.instance().configuration;
        if (!settings.exists()) {
            configuration.set("mySQL.address","localhost");
            configuration.set("mySQL.database","database");
            configuration.set("mySQL.username","user");
            configuration.set("mySQL.password","password");
            configuration.set("mySQL.port", 3306);
            configuration.set("game-options.location","lobby");
            try { configuration.save(settings); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
}
