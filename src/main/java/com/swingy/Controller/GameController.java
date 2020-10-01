package com.swingy.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.swingy.Model.HeroFactory;
import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainFactory;
import com.swingy.Model.VillainModel;
import com.swingy.Model.SwingyDatabase.SwingyDatabase;
import com.swingy.View.Map;
import com.swingy.View.Gui.GameGui;

import java.awt.event.*;
import java.io.IOException;

public class GameController implements ActionListener {
    public static boolean collision = false;
    public static int option = 0;
    // Hero names with spaces
    VillainModel Villain;
    Method method;
    private ArrayList<VillainModel> Villains = new ArrayList<VillainModel>();

    GameGui gui;
    Map map;
    HeroModel Hero;
    Boolean isConsole = false;
    Scanner scanner = new Scanner(System.in);

    int i = 0;
    // Hero Creation and selection
    // Console
    public static String name;
    public static int type;
    // Gui
    public static int selectedId;

    public GameController() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, IOException, SQLException {
        map = Map.thisMap();
        map.Villains = Villains;

        gui = new GameGui(map, this);
        gui.main(map);

        String line;
        // displayMap();

        // Create Hero
        // Play game
        System.out.println("Would you like to select or create a new hero?");
        // while (!(line = scanner.nextLine()).equals("Exit")) {
        //     if ((line.equals("Attack") || line.equals("Run")) && collision) {
        //         simulation(line);
        //     } else if (line.equals("Select") && i == 0) {
        //         selectHeroConsole(scanner);
        //         i++;
        //     } else if (line.equals("Create") && i == 0) {
        //         createHeroConsole();
        //         i++;
        //         System.out.println("Are you ready?");
        //     } else if (line.equals("Yes") && i == 1) {
        //         map.getMap();
        //         i++;
        //     } else if (i > 1) {
        //         updateView(line);
        //         i++;
        //     } else {
        //         System.out.println("Invalid command!!");
        //     }
        // }
        scanner.close();
    }

    private void updateView(String line) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        if (!line.equals("North") && !line.equals("West") && !line.equals("East") && !line.equals("South")
                && !line.equals("")) {
        } else {
            Villain = Hero.coordinates.moveDirection(line, Villains);
            if (Villain == null && Hero.coordinates.isWin()) {
                Hero.gainExperience();
                this.getVillains();
                setMap();
            } else if (Villain != null && !Hero.coordinates.isWin()) {
                System.out.println("Do you want to attack the enemy or do you want to run?");
                collision = true;
            } else {
                VillainController.moveVillains(Villains, Hero);
                updateMap();
            }
        }
    }

    public void simulation(String line) {
        if(collision == false) {
            return;
        }
        if (line.equals("Attack")) {
            // Todo set villain to null;
            if (!Hero.Attack(Villain) || option == 1) {
                System.out.println("You have lost and your heroes remains have been disposed of");
                collision = false;
                return;
            } else {
                System.out.println(Villains.remove((VillainModel) Villain));
                updateMap();
                collision = false;
            }
        } else if (line.equals("Run") || option == 2) {
            if (!Hero.Run(Villain)) {
                System.out.println("You have lost and your heroes remains have been disposed of");
                collision = false;
                return;
            } else {
                System.out.println(Villains.remove((VillainModel) Villain));
                updateMap();
                collision = false;
            }
        } else {
            System.out.println("Please try again.");
        }
    }

    private void updateMap() {
        if (!isConsole) {
            this.gui.updateMap(map);
        }
    }

    public void getVillains() {
        this.Villains = VillainFactory.getVillains(Hero.getLevel());
    }

    private void setMap() {
        map.Hero = Hero;
        map.Villains = Villains;
    }

    // Create/Select Hero

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand() == "North" || e.getActionCommand() == "South" || e.getActionCommand() == "East"
                    || e.getActionCommand() == "West")
                updateView(e.getActionCommand());
            if (e.getActionCommand() == "Create") {
                Hero = HeroFactory.getNewHero(name, type);
                GameGui.Hero = Hero;
                // TODO Put this in Hero factory

                getVillains();
                setMap();
                updateMap();
            }
            if (e.getActionCommand() == "Select") {
                selectHeroGui();
                getVillains();
                setMap();
                updateMap();
            }
            if (e.getActionCommand().equals("Attack") || e.getActionCommand().equals("Run")) {
                simulation(e.getActionCommand());
                gui.Health.setText("Health: " + Hero.getHitpoints());
                gui.AttackDamage.setText("Attack: " + Hero.getAttack());
                gui.Defence.setText("Defence: " + Hero.getDefence());
                gui.Name.setText("Name: " + Hero.getName());
                gui.Class.setText("Class: " + Hero.getType());
                gui.Level.setText("Level: " + Hero.getLevel());
                gui.Experience.setText("Experience: " + Hero.getExperience());
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e1) {
            e1.printStackTrace();
        }
    }

    private boolean createHeroConsole() {
        String line;
        System.out.println("Give your hero a name: ");
        while (!(line = scanner.nextLine()).equals("Exit")) {
            if (line.length() != 0) {
                name = line;
                break;
            } else {
                System.out.println("Invalid Command!!!");
            }
        }
        System.out.println("Please select a class(Pick a number): ");
        for (String string : SwingyDatabase.getHeroTypes()) {
            System.out.println(string);
        }

        while (!(line = scanner.nextLine()).equals("Exit")) {
            Pattern pattern = Pattern.compile("^[0-9]+\\n?$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                Hero = HeroFactory.getNewHero(name, Integer.parseInt(line));
                getVillains();
                setMap();
                return true;
            } else {
                System.out.println("Invalid Command!!!");
            }
        }
        scanner.close();
        return false;
    }

    // Could have made this work for both Gui or Console
    private void selectHeroConsole(Scanner scanner) throws SQLException {
        String line;
        // This will display all heroTypes
        ArrayList<String> CreatedHeroes = SwingyDatabase.getAllCreatedHeroes();
        for (String string : CreatedHeroes) {
            System.out.println(string);
        }
        while (!(line = scanner.nextLine()).equals("Exit")) {
            Pattern pattern = Pattern.compile("^[0-9]+\\n?$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if ((this.Hero = SwingyDatabase.getSelectedHero(Integer.parseInt(line))) != null) {
                    System.out.println("hero has been selected");
                    this.Hero = SwingyDatabase.getSelectedHero(Integer.parseInt(line));
                    getVillains();
                    setMap();
                    // Maybe put this in HeroFactory
                    return;
                } else {
                    System.out.println("That Hero does not exist yet. Please try again");
                }
            } else {
                System.out.println("Invalid command. please only use a number: ");
            }
        }
        scanner.close();
    }

    private void selectHeroGui() {
        if ((this.Hero = SwingyDatabase.getSelectedHero(selectedId)) != null) {
            GameGui.Hero = Hero;
            return;
        }
    }
}