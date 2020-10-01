package com.swingy.View.Gui;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import javax.swing.*;

import com.swingy.Controller.GameController;
import com.swingy.Model.HeroModel;
import com.swingy.Model.SwingyDatabase.SwingyDatabase;
import com.swingy.View.Map;

public class GameGui extends JFrame implements ActionListener {

    /**
     *
     */
    ButtonGroup buttonGroup = new ButtonGroup();
    JTextField HeroName = new JTextField("Enter Text Here");
    private static final long serialVersionUID = 1131222723510980970L;
    static JFrame f;
    public String mapString;
    private Map map;
    private ActionListener gameControlleListener;
    public int i = 0;
    public JTextArea gameText = new JTextArea(" ", 0, 0);
    public LinkedList<JPanel> Pages = new LinkedList<JPanel>();
    public JButton West, North, East, South, Attack, Run;
    public static HeroModel Hero;
    public JLabel Health, AttackDamage, Defence, Name, Class, Level, Experience;
    private JButton Create = new JButton("Create");

    // JButton

    // label to display text
    static JLabel l, l1;

    JRadioButton assasinButton;
    JRadioButton warriorButton;
    JRadioButton jokerButton;
    JRadioButton thiefButton;
    JRadioButton ironmanButton;

    // default constructor
    public GameGui(Map map, ActionListener list) {
        this.mapString = updateMap(map);
        this.gameControlleListener = list;
    }

    public String updateMap(Map map) {
        this.map = map;
        String ret = "";
        if (map.Hero != null) {
            String[][] mapArray = this.map.getMap();
            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray[i].length; j++) {
                    if (!mapArray[i][j].equals("*")) {
                        ret = ret + mapArray[i][j] + " ";
                    } else {
                        ret = ret + mapArray[i][j] + "  ";
                    }
                }
                ret = ret + "\n";
            }
        }
        gameText.setText(ret);
        return ret;
    }

    // main class
    public void main(Map map) {
        f = new JFrame("textfield");

        // create a label to display text
        l = new JLabel("");
        l1 = new JLabel("");

        Pages.add(getCreatehero());
        f.add(getWelcome());

        // set the size of frame
        f.setSize(600, 500);
        f.setVisible(true);
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        System.out.println(s);
        if (HeroName != null) {
            GameController.name = HeroName.getText();
        }
        Pattern pattern = Pattern.compile("^[0-9]+\\n?$");
        Matcher matcher = pattern.matcher(String.valueOf(s.charAt(0)));
        if (matcher.find() && s.split(" ").length == 8) {
            Create.setText("Create");
            GameController.type = Integer.parseInt(String.valueOf(s.charAt(0)));
        } else if (s.equals("Next") || s.equals("Create") || s.equals("Select")) {
            if(s.equals("Create") || s.equals("Select")) {
                Pages.add(getGame());
            }
            updateMap(map);
            f.setContentPane(Pages.get(i++));
            f.revalidate();
            f.repaint();
        } else if ((s.equals("North") || s.equals("South") || s.equals("West") || s.equals("East"))
                && GameController.collision) {
                    Attack.setVisible(true);
                    Run.setVisible(true);
                    West.setVisible(false);
                    North.setVisible(false);
                    South.setVisible(false);
                    East.setVisible(false);
        } else if (s.equals("Attack") || s.equals("Run")) {
            West.setVisible(true);
            North.setVisible(true);
            South.setVisible(true);
            East.setVisible(true);
            Attack.setVisible(false);
            Run.setVisible(false);
            
        } else {
            GameController.selectedId = Character.getNumericValue(s.charAt(0));
            Create.setText("Select");
        }
    }

    private JPanel getWelcome() {
        JButton Next = new JButton("Next");
        JPanel Welcome = new JPanel();

        l.setText("Welcome");

        Next.addActionListener(this);

        Welcome.add(l);
        Welcome.add(Next);
        return Welcome;
    }

    private JPanel getCreatehero() {

        JPanel CreateHero = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        CreateHero.setLayout(new GridBagLayout());

        ArrayList<String> CreatedHeroes = SwingyDatabase.getAllCreatedHeroes();

        for (String hero : CreatedHeroes) {
            JRadioButton addition = new JRadioButton();
            addition.setText(hero);
            addition.addActionListener(this);
            buttonGroup.add(addition);
            CreateHero.add(addition, gbc);
        }

        JLabel basic = new JLabel("Please select a class: (Not OOP related at all.... OK maybe just a little bit ;) )");
        CreateHero.add(basic, gbc);

        ArrayList<String> HeroTypes = SwingyDatabase.getHeroTypes();
        for (String types : HeroTypes) {
            JRadioButton addition = new JRadioButton();
            addition.setText(types);
            addition.addActionListener(this);
            buttonGroup.add(addition);
            CreateHero.add(addition, gbc);
        }

        CreateHero.add(HeroName, gbc);
        CreateHero.add(Create, gbc);

        // Order matters
        // Updates data first then repaints
        Create.addActionListener(this);
        Create.addActionListener(this.gameControlleListener);

        return CreateHero;
    }

    private JPanel getGame() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        updateMap(map);
        gameText.setEditable(false);
        JPanel Game = new JPanel();

        Health = new JLabel("Health: " + Hero.getHitpoints());
        AttackDamage = new JLabel("Attack: " + Hero.getAttack());
        Defence = new JLabel("Defence: " + Hero.getDefence());
        Name = new JLabel("Name: " + Hero.getName());
        Class = new JLabel("Class: " + Hero.getType());
        Level = new JLabel("Level: " + Hero.getLevel());
        Experience = new JLabel("Experience: " + Hero.getExperience());
       

        West = new JButton("West");
        North = new JButton("North");
        South = new JButton("South");
        East = new JButton("East");

        Attack = new JButton("Attack");
        Run = new JButton("Run");

        North.addActionListener(this);
        East.addActionListener(this);
        West.addActionListener(this);
        South.addActionListener(this);
        Attack.addActionListener(gameControlleListener);
        Run.addActionListener(gameControlleListener);
        Attack.addActionListener(this);
        Run.addActionListener(this);
        West.addActionListener(gameControlleListener);
        North.addActionListener(gameControlleListener);
        East.addActionListener(gameControlleListener);
        South.addActionListener(gameControlleListener);

        Game.add(gameText, gbc);
        Game.add(West);
        Game.add(North);
        Game.add(East);
        Game.add(South);
        Game.add(Name);
        Game.add(Class);
        Game.add(Level);
        Game.add(Experience);
        Game.add(Health, gbc);
        Game.add(AttackDamage, gbc);
        Game.add(Defence, gbc);
        Game.add(Attack, gbc);
        Game.add(Run);

        Attack.setVisible(false);
        Run.setVisible(false);

        return Game;
    }
}