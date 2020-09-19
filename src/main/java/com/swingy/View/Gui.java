package com.swingy.View;
import java.awt.event.*;
import java.awt.*; 
import javax.swing.*; 
import com.swingy.View.Map;


public class Gui extends JFrame { 
  
    static JFrame f; 
    public String mapString;
    private Map map;
  
    // JButton 
    static JButton b, b1, b2, b3; 
  
    // label to display text 
    static JLabel l, l1; 
  
    // text area 
    public static JTextArea jt; 
  
    // default constructor 
    public Gui(Map map) 
    {
        this.mapString = updateMap(map);
    } 
  
    public String updateMap(Map map) {
        this.map = map;
        String[][] mapArray = this.map.getMap();
        String ret = "";
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
        if(jt != null)
            jt.setText(ret);
        return ret;
    }

    // main class 
    public void main(Map map, ActionListener list) 
    {
        // create a object of the text class 
        Gui te = new Gui(map); 

        // create a new frame to store text field and button 
        f = new JFrame("textfield"); 
  
        // create a label to display text
        l = new JLabel("");
        l1 = new JLabel("");
        // create a new buttons 
        b = new JButton("West"); 
        b1 = new JButton("North"); 
        b2 = new JButton("East"); 
        b3 = new JButton("South"); 
  
  
        // addActionListener to button 
        b.addActionListener(list); 
        b1.addActionListener(list); 
        b2.addActionListener(list); 
        b3.addActionListener(list); 
  
        // create a text area, specifying the rows and columns 
        jt = new JTextArea(te.mapString, map.mapSize, map.mapSize);
        jt.setEditable(false);
  
        JPanel p = new JPanel(); 
  
        // add the text area and button to panel 
        p.add(jt); 
        p.add(b); 
        p.add(b1); 
        p.add(b2); 
        p.add(b3); 
        p.add(l); 
        p.add(l1); 
  
        f.add(p); 
        // set the size of frame 
        f.setSize(300, 300); 
  
        f.show(); 
    } 
  
    // if the button is pressed 
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("Ahh I see what you did there");
        String s = e.getActionCommand(); 
        if (s.equals("North")) { 
            // set the text of the label to the text of the field 
            l.setText(jt.getText() + ", "); 
            l1.setText(jt.getLineCount() + " lines"); 
        } 
        else if (s.equals("West")) { 
  
            // set bold font 
            Font f = new Font("Serif", Font.BOLD, 15); 
            jt.setFont(f); 
        } 
        else if (s.equals("South")) { 
            // set italic font 
            Font f = new Font("Serif", Font.ITALIC, 15); 
            jt.setFont(f); 
        } 
        else if (s.equals("East")) { 
            // set plain font 
            Font f = new Font("Serif", Font.PLAIN, 15); 
            jt.setFont(f); 
        } 
    } 
} 