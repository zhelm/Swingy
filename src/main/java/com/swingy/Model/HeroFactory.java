package com.swingy.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.swingy.Model.Hero.Assasin;
import com.swingy.Model.Hero.Ironman;
import com.swingy.Model.Hero.Joker;
import com.swingy.Model.Hero.Thief;
import com.swingy.Model.Hero.Warrior;

public abstract class HeroFactory {



    public static HeroModel getNewHero(String name, String type, int level) {
        HeroModel Hero = null;
        if(type.equals("Assasin")) {
            Hero = Assasin.getAssasin(name, level);
        } else if(type.equals("Warrior")) {
            Hero = Warrior.getWarrior(name, level);
        } else if(type.equals("Ironman")) {
            Hero = Ironman.getIronman(name, level);
        } else if(type.equals("Thief")) {
            Hero = Thief.getThief(name, level);
        } else if(type.equals("Joker")) {
            Hero = Joker.getJoker(name, level);
        }
        createHeroProfile(Hero);
        updateHeroProfile();
        return Hero;
    }

    public static void createHeroProfile(HeroModel Hero) {
        // Id Name Type lvl experience Weapon Armor Helm
        // ^[0-9]+ [a-z,A-Z,0-9]+ (Assasin|Warrior|Thief|Ironman|Joker) [0-9]+ [0-9]+
        // [0-9]+ [0-9]+ [0-9]+\n?$
        String[][] heroFile = updateHeroProfile();
        if(heroFile != null) {
            for (int i = 0; i < heroFile.length; i++) {
                if (Integer.parseInt(heroFile[i][0]) == Hero.getId()) {
                    heroFile[i][3] = Integer.toString(Hero.getLevel());
                    heroFile[i][4] = Integer.toString(Hero.getExperience());
                    heroFile[i][5] = Integer.toString(Hero.getWeapon());
                    heroFile[i][6] = Integer.toString(Hero.getArmor());
                    heroFile[i][7] = Integer.toString(Hero.getHelm());
                    // write everything to the file
                    updateFile(heroFile);
                    return;
                }
            }
        }
        String[][] newHero = new String[heroFile.length + 1][8];
        for (int i = 0; i < heroFile.length; i++) {
            newHero[i] = heroFile[i];
        }
        String[] heroStats = { Integer.toString(Hero.getId()), Hero.getName(), Hero.getClass().getSimpleName(),
                Integer.toString(Hero.getLevel()), Integer.toString(Hero.getExperience()),
                Integer.toString(Hero.getWeapon()), Integer.toString(Hero.getArmor()),
                Integer.toString(Hero.getHelm())};
        newHero[heroFile.length] = heroStats;
        updateFile(newHero);
        return;
        // read file. If id not there add it otherwise update
    }

    public static String[][] updateHeroProfile() {
        try {
            List<String> read = Collections.emptyList();
            read = Files.readAllLines(Paths.get("./src/main/java/com/swingy/Heroes/Heroes.txt"));
    
            String[][] breakHeroProfileStrings = new String[read.size()][8];
            String[] lines = new String[read.size()];
            lines = read.toArray(lines);
    
            for (int i = 0; i < lines.length; i++) {
                String[] test = lines[i].split(" ");
                for (int j = 0; j < test.length; j++) {
                    breakHeroProfileStrings[i][j] = test[j];
                }
            }
            return breakHeroProfileStrings;
        
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void updateFile(String[][] updateFile) {
        try {
            String rewriteTextLine = new String();
            String rewriteText = new String();
            FileWriter myWriter = new FileWriter("./src/main/java/com/swingy/Heroes/Heroes.txt");

            for (String[] strings : updateFile) {
                rewriteTextLine = "";
                for (String strings2 : strings) {
                    if(rewriteTextLine.length() == 0) {
                        rewriteTextLine = strings2;
                    } else {
                        rewriteTextLine = rewriteTextLine + " " + strings2; 
                    }
                }
                rewriteTextLine.trim();
                rewriteTextLine = rewriteTextLine + "\n";
                rewriteText = rewriteText + rewriteTextLine;
                }
                myWriter.write(rewriteText);
                myWriter.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
            
    }
}
