package com.swingy.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.swingy.Model.HeroFactory;
import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainFactory;
import com.swingy.Model.VillainModel;
import com.swingy.View.Map;
import com.swingy.View.Gui.GameGui;

import java.awt.event.*;
import java.io.IOException;

public class GameController implements ActionListener {
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
    public static String type;
    // Gui
    public static int selectedId;

    public GameController() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, IOException {
            // ^[0-9]+ [a-z,A-Z,0-9]+ (Assasin|Warrior|Thief|Ironman|Joker) [0-9]+ [0-9]+ [0-9]+ [0-9]+ [0-9]+\n?$
            // file validation and select herolist
        this.setLargestId();

        List<String> read = Collections.emptyList();
        read = Files.readAllLines(Paths.get("./src/main/java/com/swingy/Heroes/Heroes.txt"));

        String[] lines = new String[read.size()];
        lines = read.toArray(lines);

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
            Pattern pattern = Pattern.compile("^[0-9]+ [a-z,A-Z,0-9]+ (Assasin|Warrior|Thief|Ironman|Joker) [0-9]+ [0-9]+ [0-9]+ [0-9]+ [0-9]+\\n?$");
            Matcher matcher = pattern.matcher(lines[i]);
            boolean matchFound = matcher.find();
            // if(!matchFound) {
            //     System.err.println("ERROR: File has incorrect content");
            //     return ;
            // }
        }

        map = new Map(Hero, Villains);
        gui = new GameGui(map, this);
        gui.main(map);

        String line;
        // displayMap();

        // Create Hero
        // Play game
        System.out.println("Would you like to select or create a new hero?");
        while (!(line = scanner.nextLine()).equals("Exit")) {
            if(line.equals("Select") && i == 0) {
                selectHeroConsole();
                i++;
            } else if(line.equals("Create") && i == 0) {
                createHeroConsole();
                i++;
                System.out.println("Are you ready?");
            } else if(line.equals("Yes") && i == 1) {
                map.getMap();
                i++;
            } else if(i > 1) {
                updateView(line);
                i++;
            } else {
                System.out.println("Invalid command!!");
            }
        }
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
                map = new Map(Hero, Villains);
            } else if (Villain != null && !Hero.coordinates.isWin()) {
                Hero.Attack(Villain);
                System.out.println(Villains.remove((VillainModel)Villain));
            } else {
                VillainController.moveVillains(Villains, Hero);
            }
            updateMap();
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

    // Create/Select Hero
   
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getActionCommand() == "North" || e.getActionCommand() == "South" || e.getActionCommand() == "East" || e.getActionCommand() == "West")
                updateView(e.getActionCommand());
            if(e.getActionCommand() == "Create") {
                Hero = HeroFactory.getNewHero(name, type);
                // TODO Put this in Hero factory
                
                getVillains();
                map = new Map(Hero, Villains);
                updateMap();
            }
            if(e.getActionCommand() == "Select") {
                selectHeroGui();
                getVillains();
                map = new Map(Hero, Villains);
                updateMap();
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    private boolean createHeroConsole() {
        String line;
        System.out.println("Give your hero a name: ");
        while (!(line = scanner.nextLine()).equals("Exit")) {
                if(line.length() != 0) {
                    name = line;
                    break;
                } else {
                System.out.println("Invalid Command!!!");
            }
        }

        System.out.println("Please select a class: ");
        System.out.println("Assasin");
        System.out.println("Thief");
        System.out.println("Joker");
        System.out.println("Warrior");
        System.out.println("Ironman");

        while (!(line = scanner.nextLine()).equals("Exit")) {
            if(line.equals("Assasin") || line.equals("Thief") || line.equals("Warrior") || line.equals("Joker") || line.equals("Ironman")) {
                Hero = HeroFactory.getNewHero(name, line);
                getVillains();
                map = new Map(Hero, Villains);
                return true;
            } else {
                System.out.println("Invalid Command!!!");
            }
        }
        scanner.close();
        return false;
    }

    // Could have made this work for both Gui or Console
    private void selectHeroConsole() {
        String line;
        String[][] Heroes = HeroFactory.updateHeroProfile(); 

        for (String[] strings : Heroes) {
            System.out.println(strings[0] + ". " + strings[2] + " " + strings[1]);
        }

        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equals("Exit")) {
            Pattern pattern = Pattern.compile("^[0-9]+\\n?$");
            Matcher matcher = pattern.matcher(line);
            if(matcher.find()) {
                for (String[] strings : Heroes) {
                    if(Integer.parseInt(strings[0]) == Integer.parseInt(line.trim())) {
                        this.Hero = HeroFactory.getHero( strings[1], strings[2], Integer.parseInt(strings[3]), Integer.parseInt(line.trim()),Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), Integer.parseInt(strings[6]),Integer.parseInt(strings[7]));
                        getVillains();
                        map = new Map(Hero, Villains);
                        return;
                    }
                }
            } else {
                System.out.println("Invalid command. please only use a number: ");
            }
        }
        scanner.close();
    }

    private void selectHeroGui() {
        String[][] Heroes = HeroFactory.updateHeroProfile(); 
        for (String[] strings : Heroes) {
            System.out.println(selectedId);
            if(Integer.parseInt(strings[0]) == selectedId) {
                this.Hero = HeroFactory.getHero(strings[1], strings[2], Integer.parseInt(strings[3]), selectedId,Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), Integer.parseInt(strings[6]),Integer.parseInt(strings[7]));
                return;
            }
        }
    }
    
    private void setLargestId() {
        String[][] foo = HeroFactory.updateHeroProfile();
        HeroModel.id = 0;
        for (int i = 0; i < foo.length; i++) {
            if(HeroModel.id <= Integer.parseInt(foo[i][0])) {
                HeroModel.id = Integer.parseInt(foo[i][0]) + 1;
            }
        }
    }

    // Update Hero(Model)
    // Movement
    // Update position(View)

}