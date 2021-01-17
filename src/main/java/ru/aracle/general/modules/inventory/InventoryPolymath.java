package ru.aracle.general.modules.inventory;

import org.bukkit.*;
import org.bukkit.entity.Player;
import ru.aracle.general.Core;
import ru.aracle.general.modules.items.Item;
import ru.aracle.general.modules.items.ItemsManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class InventoryPolymath {
    public static void create(Player player, String iid) {
        Bukkit.getScheduler().runTaskAsynchronously(Core.instance(), () -> {

            Connection connection;
            PreparedStatement statement;
            try {
                connection = Core.pool().getConnection();
                statement = connection.prepareStatement(String.format("SELECT type, name, description, attack_speed, element, fraction, attack_damage, defence, health, arcana, endurance FROM items WHERE iid = '%s'", iid));
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()){
                    ItemsManager.items().put(iid, new Item.Constructor()
                            .iid(iid)
                            .type(resultSet.getString("type"))
                            .name(resultSet.getString("name"))
                            .description(resultSet.getString("description"))
                            .attack_speed(resultSet.getString("attack_speed"))
                            .element(resultSet.getString("element"))
                            .fraction(resultSet.getString("fraction"))
                            .attack_damage(resultSet.getInt("attack_damage"))
                            .defence(resultSet.getInt("defence"))
                            .health(resultSet.getInt("health"))
                            .arcana(resultSet.getInt("arcana"))
                            .endurance(resultSet.getInt("endurance"))
                            .construct());
                }
                statement.close();
                connection.close();
            }
            catch (SQLException e) { e.printStackTrace(); }

            Random randomRarity = new Random();
            int numberRR = randomRarity.nextInt(100);
            String rarity;
            if (numberRR <= 2) { rarity = "Artefact"; }
            else if (numberRR <= 6) { rarity = "Legendary"; }
            else if (numberRR <= 14) { rarity = "Epic"; }
            else if (numberRR <= 36) { rarity = "Rare"; }
            else { rarity = "Common"; }

            Random randomPower = new Random();
            int number = randomRarity.nextInt(10);
            int power;
            if (rarity.equals("Artefact")) { power = number + number + 30; }
            else if (rarity.equals("Legendary")) { power = number + number + 20; }
            else if (rarity.equals("Epic")) { power = number + number + 10; }
            else if (rarity.equals("Rare")) { power = number + number + 5; }
            else { power = number + 5; }

            int level;
            if (rarity.equals("Artefact")) { level = number + number + number + 30; }
            else if (rarity.equals("Legendary")) { level = number + number + number + 20; }
            else if (rarity.equals("Epic")) { level = number + number + 10; }
            else if (rarity.equals("Rare")) { level = number + number; }
            else { level = number; }

            Item constructor = ItemsManager.items().get(iid);
            int attack_damage;
            int defence;
            int health;
            int arcana;
            int endurance;

            if (constructor.getType().equals("sword") ||
                    constructor.getType().equals("dagger") ||
                    constructor.getType().equals("broadsword") ||
                    constructor.getType().equals("bow") ||
                    constructor.getType().equals("crossbow") ||
                    constructor.getType().equals("staff"))
            {
                    attack_damage = constructor.getAttack_damage() + power + number;
                    defence = 0;
                    if (constructor.getHealth() == 0) { health = 0; } else { health = constructor.getHealth() + power; }
                    if (constructor.getArcana() == 0) { arcana = 0; } else { arcana = constructor.getArcana() + power; }
                    if (constructor.getEndurance() == 0) { endurance = 0; } else { endurance = constructor.getEndurance() + power; }
            }
            else if (constructor.getType().equals("armor")) {
                    attack_damage = 0;
                    defence = constructor.getDefence() + power;
                    if (constructor.getHealth() == 0) { health = 0; } else { health = constructor.getHealth() + power; }
                    if (constructor.getArcana() == 0) { arcana = 0; } else { arcana = constructor.getArcana() + power; }
                    if (constructor.getEndurance() == 0) { endurance = 0; } else { endurance = constructor.getEndurance() + power; }
            }
            else {
                attack_damage = 0;
                defence = 0;
                health = 0;
                arcana = 0;
                endurance = 0;
            }

            InventoryManager.inventories().put(player.getUniqueId(), new Inventory.Constructor()
                    .uuid(player.getUniqueId().toString())
                    .iid(iid)
                    .rarity(rarity)
                    .power(power)
                    .fraction(constructor.getFraction())
                    .level(level)
                    .first(1)
                    .second(2)
                    .third(3)
                    .attack_damage(attack_damage)
                    .defence(defence)
                    .health(health)
                    .arcana(arcana)
                    .endurance(endurance)
                    .construct());
        });
    }
}
