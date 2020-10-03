package com.swingy.Model.SwingyDatabase;

import java.sql.*;
import java.util.ArrayList;

import com.swingy.Model.HeroModel;

public abstract class SwingyDatabase {
    public static void createInitialTables() {
        Connection connection = null;
        try {
            // create a database connection

            String VillainTypes = "CREATE TABLE IF NOT EXISTS VillainTypes (\n" + "	id integer PRIMARY KEY,\n"
                    + "	Type text NOT NULL Unique,\n" + "	Hitpoints integer NOT NULL,\n"
                    + "	Attack integer NOT NULL\n" + ");";

            String CreatedHeroes = "CREATE TABLE IF NOT EXISTS CreatedHeroes (\n" + "	id integer PRIMARY KEY,\n"
                    + "	Name text NOT NULL,\n" + "	Type integer NOT NULL,\n" + "	Level integer NOT NULL,\n"
                    + "	Experience integer NOT NULL,\n" + "	Hitpoints integer NOT NULL,\n"
                    + "	Attack integer NOT NULL,\n" + "	Defence integer NOT NULL,\n" + "	Weapon integer NOT NULL,\n"
                    + "	Armor integer NOT NULL,\n" + "	Helm integer NOT NULL\n" + ");";

            String HeroTypes = "CREATE TABLE IF NOT EXISTS HeroTypes (\n" + "	id integer PRIMARY KEY,\n"
                    + "	Type text NOT NULL Unique ,\n" + "	Hitpoints integer NOT NULL,\n"
                    + "	Attack integer NOT NULL,\n" + "	Defence integer NOT NULL,\n" + "	Weapon integer NOT NULL,\n"
                    + "	Armor integer NOT NULL,\n" + "	Helm integer NOT NULL\n" + ");";

            String Villains = "INSERT or Ignore INTO VillainTypes(Type,Hitpoints,Attack) VALUES(?,?,?)";
            String Heroes = "INSERT or Ignore INTO HeroTypes(Type,Hitpoints,Attack,Defence,Weapon,Armor,Helm) VALUES(?,?,?,?,?,?,?)";

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                // create a new table
                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                stmt.execute(HeroTypes);
                stmt.execute(VillainTypes);
                stmt.execute(CreatedHeroes);

                PreparedStatement pstmtVillains = conn.prepareStatement(Villains);
                pstmtVillains.setString(1, "DarkMage");
                pstmtVillains.setInt(2, 100);
                pstmtVillains.setInt(3, 75);
                pstmtVillains.executeUpdate();
                pstmtVillains.setString(1, "Demon");
                pstmtVillains.setInt(2, 100);
                pstmtVillains.setInt(3, 75);
                pstmtVillains.executeUpdate();
                pstmtVillains.setString(1, "Orc");
                pstmtVillains.setInt(2, 100);
                pstmtVillains.setInt(3, 75);
                pstmtVillains.executeUpdate();

                PreparedStatement pstmtHeroes = conn.prepareStatement(Heroes);
                // Type,Hitpoints,Attack,Defence,Weapon,Armor,Helm
                pstmtHeroes.setString(1, "Assasin");
                pstmtHeroes.setInt(2, 500);
                pstmtHeroes.setInt(3, 60);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Joker");
                pstmtHeroes.setInt(2, 500);
                pstmtHeroes.setInt(3, 60);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Ironman");
                pstmtHeroes.setInt(2, 500);
                pstmtHeroes.setInt(3, 60);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Warrior");
                pstmtHeroes.setInt(2, 500);
                pstmtHeroes.setInt(3, 60);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Thief");
                pstmtHeroes.setInt(2, 500);
                pstmtHeroes.setInt(3, 60);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    public static void gainExperience(int Experienece, int HeroID) {
        Connection connection = null;
        try {
            String sql = "UPDATE CreatedHeroes SET Experience = ? " + "WHERE id = ?";

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // set the corresponding param
        pstmt.setInt(1, Experienece);
        pstmt.setInt(2, HeroID);
        // update
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void gainLevel(int HeroID, int Level) {
        Connection connection = null;
        try {
            String sql = "UPDATE CreatedHeroes SET Level = ? , " + "Experience = ? " + "WHERE id = ?";

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setInt(1, Level);
                pstmt.setInt(2, 0);
                pstmt.setInt(3, HeroID);
                // update
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static HeroModel getSelectedHero(int HeroID) {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                ResultSet rs = stmt.executeQuery("Select * from CreatedHeroes Where id = " + HeroID);
                if (rs.next()) {
                    String Name = rs.getString("Name");
                    int Level = rs.getInt("Level");
                    int Experience = rs.getInt("Experience");
                    int id = rs.getInt("id");
                    int Hitpoints = rs.getInt("Hitpoints");
                    int Attack = rs.getInt("Attack");
                    int Defence = rs.getInt("Defence");
                    int Weapon = rs.getInt("Weapon");
                    int Armor = rs.getInt("Armor");
                    int Helm = rs.getInt("Helm");
                    rs = stmt.executeQuery("Select * from HeroTypes Where id = " + rs.getInt("Type"));
                    rs.next();
                    String HeroType = rs.getString("Type");
                    // Should not do this but meh
                    return new HeroModel(Name, Level, id, Experience, Weapon, Armor, Helm, Hitpoints, Attack, Defence, HeroType);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public static ArrayList<String> getHeroTypes() {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.

                ResultSet rs = stmt.executeQuery("Select * from HeroTypes");
                ArrayList<String> HeroTypes = new ArrayList<String>();
                while (rs.next()) {
                    HeroTypes.add(rs.getInt("id") + ". " + rs.getString("Type") + " " + rs.getInt("Hitpoints") + " "
                            + rs.getInt("Attack") + " " + rs.getInt("Defence") + " " + rs.getInt("Weapon") + " "
                            + rs.getInt("Armor") + " " + rs.getInt("Helm"));
                }
                return HeroTypes;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public static ArrayList<String> getAllCreatedHeroes() {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.

                ResultSet rs = stmt.executeQuery("Select * from CreatedHeroes");
                ArrayList<String> ret = new ArrayList<String>();
                // Todo need to manually add everything to array or something
                while (rs.next()) {
                    ret.add(rs.getInt("id") + ". " + rs.getString("Name") + " " + getHeroTypeById(rs.getInt("Type"))
                            + " " + rs.getInt("Hitpoints") + " " + rs.getInt("Attack") + " " + rs.getInt("Defence")
                            + " " + rs.getInt("Weapon") + " " + rs.getInt("Armor") + " " + rs.getInt("Helm"));
                }
                return ret;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public static HeroModel createNewHero(int Type, String Name) {
        int maxId = 0;
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                ResultSet rs = stmt.executeQuery("Select * from HeroTypes Where id =" + Type);
                rs.next();
                String HeroType = rs.getString("Type");
                int id = rs.getInt("id");
                int Hitpoints = rs.getInt("Hitpoints");
                int Attack = rs.getInt("Attack");
                int Defence = rs.getInt("Defence");
                int Weapon = rs.getInt("Weapon");
                int Armor = rs.getInt("Armor");
                int Helm = rs.getInt("Helm");

                String newHero = "INSERT INTO CreatedHeroes(Name,Type,Level,Experience,Hitpoints,Attack,Defence,Weapon,Armor,Helm) VALUES(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstmtVillains = conn.prepareStatement(newHero);
                pstmtVillains.setString(1, Name);
                pstmtVillains.setInt(2, id);
                pstmtVillains.setInt(3, 0);
                pstmtVillains.setInt(4, 0);
                pstmtVillains.setInt(5, Hitpoints);
                pstmtVillains.setInt(6, Attack);
                pstmtVillains.setInt(7, Defence);
                pstmtVillains.setInt(8, Weapon);
                pstmtVillains.setInt(9, Armor);
                pstmtVillains.setInt(10, Helm);
                pstmtVillains.executeUpdate();

                rs = stmt.executeQuery("Select * from CreatedHeroes");
                while (rs.next()) {
                    maxId = rs.getInt("id");
                }
                return new HeroModel(Name, 0, maxId, 0, Weapon, Armor, Helm, Hitpoints, Attack, Defence, HeroType);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public static ArrayList<String[]> getVillainTypes() {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                ResultSet rs = stmt.executeQuery("Select * from VillainTypes");
                ArrayList<String[]> villainList = new ArrayList<String[]>();
                while(rs.next()) {
                    String[] Villain = new String[4];

                    Villain[0] = rs.getString("id"); 
                    Villain[1] = rs.getString("Type"); 
                    Villain[2] = rs.getString("Hitpoints"); 
                    Villain[3] = rs.getString("Attack");
                    
                    villainList.add(Villain);
                }
                return villainList;

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public static String getHeroTypeById(int id) {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                ResultSet rs = stmt.executeQuery("Select * from HeroTypes where id = " + id);
                rs.next();
                return rs.getString("Type");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public static void upgradeWeapon(int HeroID, int amount) {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                stmt.executeUpdate("UPDATE CreatedHeroes SET Weapon = " + amount + " where id =" + HeroID);
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void upgradeArmor(int HeroID, int amount) {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {

                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                stmt.executeUpdate("UPDATE CreatedHeroes SET Weapon = " + amount + " where id =" + HeroID);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void upgradeHelm(int HeroID, int amount) {
        Connection connection = null;
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
                    Statement stmt = conn.createStatement()) {
                stmt.setQueryTimeout(30); // set timeout to 30 sec.
                stmt.executeUpdate("UPDATE CreatedHeroes SET Weapon = " + amount + " where id =" + HeroID);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    // gethealth
    // getAttack
    // getDefence
    // getArmor
    // Blablablablablablablablabla
}
