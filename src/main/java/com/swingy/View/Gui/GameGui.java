package com.swingy.View.Gui;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;

import com.swingy.Controller.GameController;
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

    // JButton 
  
    // label to display text 
    static JLabel l, l1; 

  
    JRadioButton assasinButton; 
    JRadioButton warriorButton; 
    JRadioButton jokerButton; 
    JRadioButton thiefButton; 
    JRadioButton ironmanButton; 
  
    // default constructor 
    public GameGui(Map map, ActionListener list) 
    {
        this.mapString = updateMap(map);
        this.gameControlleListener = list;
    } 
  
    public String updateMap(Map map) {
        this.map = map;
        String ret = "";
        if(map.Hero != null) {
            String[][] mapArray = this.map.getMap();
            for (int i = 0; i < mapArray.length; i++) {
                for (int j = 0; j < mapArray[i].length; j++) {
                    if(!mapArray[i][j].equals("*")) {
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
    public void main(Map map) 
    {
        // create a object of the text class 
        // create a new frame to store text field and button 
        f = new JFrame("textfield");
  
        // create a label to display text
        l = new JLabel("");
        l1 = new JLabel("");
        
        // create a new buttons 
  
        // addActionListener to button 
  
        // create a text area, specifying the rows and columns 

       

  
       
        // // Welcome
        
        //     Welcome.add(Next);
        // // Create / Select Hero
        //     l1.setText("Please Select or Create a Hero");
        //     CreateHero.add(l1);
        // // Game
        // Game.add(jt); 
        // Game.add(West); 
        // Game.add(North); 
        // Game.add(East); 
        // Game.add(South); 
        // Game.add(jRadioButton1);
        

        // f.add(getGame());
        // f.add(getCreatehero());
        Pages.add(getCreatehero());
        Pages.add(getGame());
        f.add(getWelcome());

        // set the size of frame 
        f.setSize(600, 500); 
        f.setVisible(true);
    } 
  
    // if the button is pressed 
    public void actionPerformed(ActionEvent e) 
    {
        String s = e.getActionCommand();
        if(HeroName != null) {
            GameController.name = HeroName.getText();
        }
        if(e.getActionCommand() == "Assasin" || e.getActionCommand() == "Ironman" || e.getActionCommand() == "Thief" || e.getActionCommand() == "Warrior" || e.getActionCommand() == "Joker") {
            GameController.type = e.getActionCommand();
        }
        if (s.equals("Next") || s.equals("Create")) {
            updateMap(map);
            f.setContentPane(Pages.get(i++));
            f.revalidate();
            f.repaint();
        } else {
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
        
        
        assasinButton = new JRadioButton(); 
        warriorButton = new JRadioButton(); 
        thiefButton = new JRadioButton(); 
        jokerButton = new JRadioButton(); 
        ironmanButton = new JRadioButton(); 

        JLabel basic = new JLabel("Please select a class: (Not OOP related at all.... OK maybe just a little bit ;) )"); 

        assasinButton.setText("Assasin");
        ironmanButton.setText("Ironman");
        jokerButton.setText("Joker");
        thiefButton.setText("Thief");
        warriorButton.setText("Warrior");

        assasinButton.addActionListener(this);
        ironmanButton.addActionListener(this);
        thiefButton.addActionListener(this);
        jokerButton.addActionListener(this);
        warriorButton.addActionListener(this);

        JButton Create = new JButton("Create");
        JPanel CreateHero = new JPanel(); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        CreateHero.setLayout(new GridBagLayout());


        buttonGroup.add(assasinButton);
        buttonGroup.add(ironmanButton);
        buttonGroup.add(thiefButton);
        buttonGroup.add(jokerButton);
        buttonGroup.add(warriorButton);

        CreateHero.add(basic, gbc);

        CreateHero.add(assasinButton, gbc);
        CreateHero.add(ironmanButton, gbc);
        CreateHero.add(thiefButton, gbc);
        CreateHero.add(jokerButton, gbc);
        CreateHero.add(warriorButton, gbc);

        CreateHero.add(HeroName, gbc);
        CreateHero.add(Create, gbc);

        //Order matters
        Create.addActionListener(this.gameControlleListener);
        Create.addActionListener(this);

        return CreateHero;
    }
    
    private JPanel getGame() {
        JButton West, North, East, South;
        updateMap(map);
        gameText.setEditable(false);
        JPanel Game = new JPanel();
        
        West = new JButton("West");
        North = new JButton("North");
        South = new JButton("South");
        East = new JButton("East");

        West.addActionListener(gameControlleListener); 
        North.addActionListener(gameControlleListener); 
        East.addActionListener(gameControlleListener); 
        South.addActionListener(gameControlleListener); 

        Game.add(gameText); 
        Game.add(West); 
        Game.add(North); 
        Game.add(East); 
        Game.add(South); 
        
        return Game;
    }
} 