package ru.aracle.general.modules.statistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.aracle.general.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsPolymath {
    public static void create(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () ->
                StatisticsManager.users().put(player.getUniqueId(), new Statistics.Constructor()
                        .wins(0)
                        .defeats(0)
                        .kills(0)
                        .deaths(0)
                        .dungeons(0)
                        .prestige(0)
                        .construct()));
    }

    public static void load(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("SELECT wins, defeats, kills, deaths, dungeons, prestige FROM statistics WHERE uuid = '%s'", player.getUniqueId()));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    StatisticsManager.users().put(player.getUniqueId(), new Statistics.Constructor()
                            .wins(resultSet.getInt("wins"))
                            .defeats(resultSet.getInt("defeats"))
                            .kills(resultSet.getInt("kills"))
                            .deaths(resultSet.getInt("deaths"))
                            .dungeons(resultSet.getInt("dungeons"))
                            .prestige(resultSet.getInt("prestige"))
                            .construct());
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateStatistics(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Statistics constructor = StatisticsManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE statistics SET wins = %d, defeats = %d, kills = %d, deaths = %d, dungeons = %d, prestige = %d WHERE uuid= '%s'", constructor.getWins(), constructor.getDefeats(), constructor.getKills(), constructor.getDeaths(), constructor.getDungeons(), constructor.getPrestige(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateWins(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Statistics constructor = StatisticsManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE statistics SET wins = %d WHERE uuid= '%s'", constructor.getWins(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateDefeats(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Statistics constructor = StatisticsManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE statistics SET defeats = %d WHERE uuid= '%s'", constructor.getDefeats(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateKills(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Statistics constructor = StatisticsManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE statistics SET kills = %d WHERE uuid= '%s'", constructor.getKills(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateDeaths(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Statistics constructor = StatisticsManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE statistics SET deaths = %d WHERE uuid= '%s'", constructor.getDeaths(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updateDungeons(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Statistics constructor = StatisticsManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE statistics SET dungeons = %d WHERE uuid= '%s'", constructor.getDungeons(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static void updatePrestige(Player player) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {
            Connection connection;
            PreparedStatement statement;
            try {
                Statistics constructor = StatisticsManager.users().get(player.getUniqueId());
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("UPDATE statistics SET prestige = %d WHERE uuid= '%s'", constructor.getPrestige(), player.getUniqueId()));
                statement.executeUpdate();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
