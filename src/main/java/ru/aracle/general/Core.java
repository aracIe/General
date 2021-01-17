package ru.aracle.general;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ru.aracle.general.mysql.Tables;
import ru.aracle.general.mysql.HP;
import ru.aracle.general.settings.Items;
import ru.aracle.general.settings.Settings;

import java.io.File;
import java.util.Objects;

public final class Core extends JavaPlugin {

    private static Core plugin;
    private static HP pool;
    public static Core instance() { return plugin; }
    public static HP pool() {return pool;}
    public File settings = new File(getDataFolder()+File.separator+"settings.yml");
    public FileConfiguration configuration = YamlConfiguration.loadConfiguration(settings);
    public File items = new File(getDataFolder()+File.separator+"items.yml");
    public FileConfiguration itemsConfiguration = YamlConfiguration.loadConfiguration(items);


    @Override
    public void onEnable() {
        plugin = this;
        Settings.load();
        Items.load();
        Bukkit.getConsoleSender().sendMessage(configuration.getString("MySQL.address"));
        connection();
        Tables.load();
    }

    public void connection() {
        String address = configuration.getString("MySQL.address");
        String database = configuration.getString("MySQL.database");
        String username = configuration.getString("MySQL.username");
        String password = configuration.getString("MySQL.password");
        String source = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
        int port = configuration.getInt("MySQL.port");
        int size = 10;
        int time = 180000;
        pool = new HP(address, database, username, password, source, port, size, time);
    }

    @Override
    public void onDisable() {
        if (pool != null) {
            pool.closePool();
        }
    }
}
