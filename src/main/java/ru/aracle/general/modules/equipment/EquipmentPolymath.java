package ru.aracle.general.modules.equipment;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.aracle.general.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentPolymath {
    public static void create(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () ->
                EquipmentManager.users().put(player.getUniqueId(), new Equipment.Constructor()
                        .main(0)
                        .other(0)
                        .first(0)
                        .second(0)
                        .third(0)
                        .armor(0)
                        .construct()));
    }
    public static void load(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("SELECT main, other, first, second, third, armor FROM equipment WHERE uuid = '%s'", player.getUniqueId()));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    EquipmentManager.users().put(player.getUniqueId(), new Equipment.Constructor()
                            .main(resultSet.getInt("main"))
                            .other(resultSet.getInt("main"))
                            .first(resultSet.getInt("main"))
                            .second(resultSet.getInt("main"))
                            .third(resultSet.getInt("main"))
                            .armor(resultSet.getInt("main"))
                            .construct());
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
