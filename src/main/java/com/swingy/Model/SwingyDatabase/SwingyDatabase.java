package com.swingy.Model.SwingyDatabase;

import java.sql.*;

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
                pstmtVillains.setInt(3, 10);
                pstmtVillains.executeUpdate();
                pstmtVillains.setString(1, "Demon");
                pstmtVillains.setInt(2, 100);
                pstmtVillains.setInt(3, 10);
                pstmtVillains.executeUpdate();
                pstmtVillains.setString(1, "Orc");
                pstmtVillains.setInt(2, 100);
                pstmtVillains.setInt(3, 10);
                pstmtVillains.executeUpdate();

                PreparedStatement pstmtHeroes = conn.prepareStatement(Heroes);
                // Type,Hitpoints,Attack,Defence,Weapon,Armor,Helm
                pstmtHeroes.setString(1, "Assasin");
                pstmtHeroes.setInt(2, 300);
                pstmtHeroes.setInt(3, 20);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Joker");
                pstmtHeroes.setInt(2, 300);
                pstmtHeroes.setInt(3, 20);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Ironman");
                pstmtHeroes.setInt(2, 300);
                pstmtHeroes.setInt(3, 20);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Warrior");
                pstmtHeroes.setInt(2, 300);
                pstmtHeroes.setInt(3, 20);
                pstmtHeroes.setInt(4, 0);
                pstmtHeroes.setInt(5, 0);
                pstmtHeroes.setInt(6, 0);
                pstmtHeroes.setInt(7, 0);
                pstmtHeroes.executeUpdate();
                pstmtHeroes.setString(1, "Thief");
                pstmtHeroes.setInt(2, 300);
                pstmtHeroes.setInt(3, 20);
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

    public static void updateHero(){

    }

    public static void getSelectedHero(int HeroID){
        
    }

    public static void getHeroTypes(){
        
    }

    public static void getAllCreatedHeroes(){
        
    }
    
    public static void createNewHero(HeroModel Hero, String Name){

        Connection connection = null;
        try {

            // create a database connection
            
            // Select type from HeroTypes
            
            
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:Swingy.db");
            Statement stmt = conn.createStatement()) {
                ResultSet rs    = stmt.executeQuery("Select * from HeroTypes Where Type like 'Warrior'");
                while (rs.next()) {
                    // Type, Hitpoints, Attack, Defence, Weapon, Armor, Helm
                    System.out.println(rs.getInt("id") +  "\t" + 
                                       rs.getString("Type") + "\t");
                }
                    
                //     String newHero = "INSERT or Ignore INTO CreatedHeroes(Name,Type,Level,Experience,Hitpoints,Attack,Defence,Weapon,Armor,Helm) VALUES(?,?,?,?,?,?,?)";
                // // create a new table
                // stmt.setQueryTimeout(30); // set timeout to 30 sec.

                // PreparedStatement pstmtVillains = conn.prepareStatement(newHero);
                // pstmtVillains.setString(1, "DarkMage");
                // pstmtVillains.setInt(2, 100);
                // pstmtVillains.setInt(3, 10);
                // pstmtVillains.executeUpdate();
                // pstmtVillains.setString(1, "Demon");
                // pstmtVillains.setInt(2, 100);
                // pstmtVillains.setInt(3, 10);
                // pstmtVillains.executeUpdate();
                // pstmtVillains.setString(1, "Orc");
                // pstmtVillains.setInt(2, 100);
                // pstmtVillains.setInt(3, 10);
                // pstmtVillains.executeUpdate();

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

    public static void getVillainTypes(){
        
    }
}
