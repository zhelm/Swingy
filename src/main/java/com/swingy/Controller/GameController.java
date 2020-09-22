package com.swingy.Controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import com.swingy.Model.HeroFactory;
import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainFactory;
import com.swingy.Model.VillainModel;
import com.swingy.View.Map;
import com.swingy.View.Gui.GameGui;

import java.awt.event.*;

public class GameController implements ActionListener {

    VillainModel Villain;
    Method method;
    private ArrayList<VillainModel> Villains = new ArrayList<VillainModel>();

    GameGui gui;
    Map map;
    HeroModel Hero;
    Boolean isConsole = false;

    // Hero Creation
    public static String name;
    public static String type;

    public GameController() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        this.getNewHero();
        this.getVillains();

        map = new Map(Hero, Villains);
        gui = new GameGui(map, this);
        gui.main(map);

        String line;
        Scanner scanner = new Scanner(System.in);
        // displayMap();
        while (!(line = scanner.nextLine()).equals("Exit")) {
            System.out.println("Say something");
            updateView(line);
            scanner.close();

        }

        // if (!line.equals("North") && !line.equals("West") && !line.equals("East") &&
        // !line.equals("South")
        // && !line.equals("")) {
        // System.out.println("Please enter a correct message and not: " + line);
        // } else {
        // System.out.println(Hero.coordinates.getXCoordinate() + " " +
        // Hero.coordinates.getYCoordinate());
        // Villain = Hero.coordinates.moveDirection(line, Villains);
        // if(Villain == null && Hero.coordinates.isWin()) {
        // Hero.gainExperience();
        // this.getVillains();
        // map = new Map(Hero, Villains);
        // } else if (Villain != null && !Hero.coordinates.isWin()) {
        // System.out.println("I wanna fight now. What did you look at. Go look at your
        // sister");
        // Hero.Attack(Villain);
        // } else {
        // VillainController.moveVillains(Villains, Hero);
        // }
        // displayMap();
        // }
        // }
        // scanner.close();
    }

    private void updateView(String line) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        if (!line.equals("North") && !line.equals("West") && !line.equals("East") && !line.equals("South")
                && !line.equals("")) {
            System.out.println("Please enter a correct message and not: " + line);
        } else {
            System.out.println(Hero.coordinates.getXCoordinate() + " " + Hero.coordinates.getYCoordinate());
            Villain = Hero.coordinates.moveDirection(line, Villains);
            if (Villain == null && Hero.coordinates.isWin()) {
                Hero.gainExperience();
                System.out.println("Getting new villains");
                this.getVillains();
                map = new Map(Hero, Villains);
            } else if (Villain != null && !Hero.coordinates.isWin()) {
                System.out.println("I wanna fight now. What did you look at. Go look at your sister");
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

    public void getNewHero() {
        this.Hero = HeroFactory.getNewHero("null");
    }

    public void getVillains() {
        this.Villains = VillainFactory.getVillains(Hero.getLevel());
    }

    // Create/Select Hero
    public void displayMap() {
        map.getMap();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getActionCommand() == "North" || e.getActionCommand() == "South" || e.getActionCommand() == "East" || e.getActionCommand() == "West")
                updateView(e.getActionCommand());
                if(e.getActionCommand() == "Create") {
                    
                }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
                | SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    // Update Hero(Model)
    // Movement
    // Update position(View)

}