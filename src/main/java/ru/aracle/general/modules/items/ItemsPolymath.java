package ru.aracle.general.modules.items;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import ru.aracle.general.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemsPolymath {
    public static void upload(String iid) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            FileConfiguration configuration = Core.instance().itemsConfiguration;
            Connection connection;
            PreparedStatement statement;
            ItemsManager.items().put(iid, new Item.Constructor()
                            .iid(iid)
                            .type(configuration.getString(iid+".type"))
                            .name(configuration.getString(iid+".name"))
                            .description(configuration.getString(iid+".description"))
                            .attack_speed(configuration.getString(iid+".attack_speed"))
                            .attack_damage(configuration.getInt(iid+".attack_damage"))
                            .defence(configuration.getInt(iid+".defence"))
                            .health(configuration.getInt(iid+".health"))
                            .arcana(configuration.getInt(iid+".arcana"))
                            .endurance(configuration.getInt(iid+".endurance"))
                            .construct());
            try {
                Item constructor = ItemsManager.items().get(iid);
                connection = ru.aracle.general.Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("INSERT INTO items (iid, type, name, description, attack_speed, attack_damage, defence, health, arcana, endurance) VALUES ('%s','%s','%s','%s','%s',%d,%d,%d,%d,%d);", constructor.getIid(), constructor.getType(), constructor.getName(), constructor.getDescription(), constructor.getAttack_speed(), constructor.getAttack_damage(), constructor.getDefence(), constructor.getHealth(), constructor.getArcana(), constructor.getEndurance()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void reload(String iid) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            FileConfiguration configuration = Core.instance().itemsConfiguration;
            Connection connection;
            PreparedStatement statement;
            ItemsManager.items().put(iid, new Item.Constructor()
                    .iid(iid)
                    .type(configuration.getString(iid+".type"))
                    .name(configuration.getString(iid+".name"))
                    .description(configuration.getString(iid+".description"))
                    .attack_speed(configuration.getString(iid+".attack_speed"))
                    .attack_damage(configuration.getInt(iid+".attack_damage"))
                    .defence(configuration.getInt(iid+".defence"))
                    .health(configuration.getInt(iid+".health"))
                    .arcana(configuration.getInt(iid+".arcana"))
                    .endurance(configuration.getInt(iid+".endurance"))
                    .construct());
            try {
                Item constructor = ItemsManager.items().get(iid);
                connection = ru.aracle.general.Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE items SET iid = '%s', type = '%s', name = '%s', description = '%s', attack_speed = '%s', attack_damage = %d, defence = %d, health = %d, arcana = %d, endurance = %d WHERE iid= '%s'", constructor.getIid(), constructor.getType(), constructor.getName(), constructor.getDescription(), constructor.getAttack_speed(), constructor.getAttack_damage(), constructor.getDefence(), constructor.getHealth(), constructor.getArcana(), constructor.getEndurance(), iid));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void delete(String iid) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                connection = ru.aracle.general.Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("DELETE FROM items WHERE iid = '%s'", iid));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
