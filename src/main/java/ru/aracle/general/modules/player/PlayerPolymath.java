package ru.aracle.general.modules.player;

import lombok.experimental.Accessors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.aracle.general.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Accessors
public class PlayerPolymath {
    public static void create(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () ->
                PlayerManager.users().put(player.getUniqueId(), new Data.Constructor()
                .level(1)
                .xp(0)
                .health(50)
                .arcana(5)
                .endurance(5)
                .fraction("none")
                .name(player.getDisplayName())
                .skin("default")
                .construct()));
    }

    public static void load(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("SELECT name, fraction, skin, level, xp, health, arcana, endurance FROM player WHERE uuid = '%s'", player.getUniqueId()));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    PlayerManager.users().put(player.getUniqueId(), new Data.Constructor()
                            .level(resultSet.getInt("level"))
                            .xp(resultSet.getInt("xp"))
                            .health(resultSet.getInt("health"))
                            .arcana(resultSet.getInt("arcana"))
                            .endurance(resultSet.getInt("endurance"))
                            .name(resultSet.getString("name"))
                            .fraction(resultSet.getString("fraction"))
                            .skin(resultSet.getString("skin"))
                            .construct());
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateData(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET name = '%s', skin = '%s', fraction = '%s', level = %d, xp = %d, health = %d, arcana = %d, endurance = %d WHERE uuid= '%s'", constructor.getName(), constructor.getSkin(), constructor.getFraction(), constructor.getLevel(), constructor.getXp(), constructor.getHealth(), constructor.getArcana(), constructor.getEndurance(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateName(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET name = '%s' WHERE uuid= '%s'", constructor.getName(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateSkin(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET skin = '%s' WHERE uuid= '%s'", constructor.getSkin(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateFraction(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET fraction = '%s' WHERE uuid= '%s'", constructor.getFraction(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateLevel(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET level = %d WHERE uuid= '%s'", constructor.getLevel(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateXp(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET xp = %d WHERE uuid= '%s'", constructor.getXp(), player.getUniqueId()));
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
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET health = %d WHERE uuid= '%s'", constructor.getHealth(), player.getUniqueId()));
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
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET arcana = %d WHERE uuid= '%s'", constructor.getArcana(), player.getUniqueId()));
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
                Data constructor = PlayerManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE player SET endurance = %d WHERE uuid= '%s'", constructor.getEndurance(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
