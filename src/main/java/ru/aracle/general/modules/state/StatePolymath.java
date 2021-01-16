package ru.aracle.general.modules.state;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.aracle.general.Core;
import ru.aracle.general.modules.player.Data;
import ru.aracle.general.modules.player.PlayerManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatePolymath {
    public static void create(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Data constructor = PlayerManager.users().get(player.getUniqueId());
            StateManager.users().put(player.getUniqueId(), new State.Constructor()
                    .health(constructor.getHealth())
                    .arcana(constructor.getArcana())
                    .endurance(constructor.getEndurance())
                    .construct());
        });
    }

    public static void load(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("SELECT health, arcana, endurance FROM state WHERE uuid = '%s'", player.getUniqueId()));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    StateManager.users().put(player.getUniqueId(), new State.Constructor()
                            .health(resultSet.getInt("health"))
                            .arcana(resultSet.getInt("arcana"))
                            .endurance(resultSet.getInt("endurance"))
                            .construct());
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateState(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                State constructor = StateManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE state SET health = %d, arcana = %d, endurance = %d WHERE uuid= '%s'", constructor.getHealth(), constructor.getArcana(), constructor.getEndurance(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateHealth(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                State constructor = StateManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE state SET health = %d WHERE uuid= '%s'", constructor.getHealth(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateArcana(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                State constructor = StateManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE state SET arcana = %d WHERE uuid= '%s'", constructor.getArcana(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateEndurance(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                State constructor = StateManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE state SET endurance = %d WHERE uuid= '%s'", constructor.getEndurance(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
