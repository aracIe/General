package ru.aracle.general.mysql;

import org.bukkit.Bukkit;
import ru.aracle.general.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tables {
    public static void load() {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), Tables::player);
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), Tables::state);
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), Tables::statistics);
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), Tables::equipment);
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), Tables::inventory);
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), Tables::items);
    }

    public static void player() {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = Core.pool().getConnection();
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS player (uuid VARCHAR(36), name VARCHAR(20), fraction VARCHAR(20), skin VARCHAR(20), level INT(5), xp INT(7),  health INT(5),  arcana INT(5),  endurance INT(5), ip VARCHAR(20), status VARCHAR(7))");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void state() {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = Core.pool().getConnection();
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS state (uuid VARCHAR(36), health INT(5),  arcana INT(5),  endurance INT(5))");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void statistics() {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = Core.pool().getConnection();
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS statistics (uuid VARCHAR(36), wins INT(6), defeats INT(6), kills INT(6), deaths INT(6), dungeons INT(6), prestigeINT(6))");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void equipment() {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = Core.pool().getConnection();
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS equipment (uuid VARCHAR(36), main INT(7), other INT(7), first INT(7), second INT(7), third INT(7), armor INT(7))");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inventory() {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = Core.pool().getConnection();
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS inventory (uuid VARCHAR(36), id INT(7) NOT NULL AUTO_INCREMENT, iid VARCHAR(20), rarity VARCHAR(20), power INT(5), first INT(5), second INT(5), third INT(5))");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void items() {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = Core.pool().getConnection();
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS items (iid VARCHAR(20) , type VARCHAR(20), name VARCHAR(20), description VARCHAR(20), attack_speed INT(3), attack_damage INT(3), defence INT(3), health INT(4), arcana INT(4), endurance INT(4))");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
