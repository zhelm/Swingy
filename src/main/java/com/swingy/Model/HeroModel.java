package com.swingy.Model;

import java.util.ArrayList;

import com.swingy.Interfaces.ICharacter;

/**
 * HeroModel
 */
public class HeroModel implements ICharacter {

    private String Name;
    private String Type;
    private int Level;
    private int Experience;
    private int heroId;
    public static int id;
    public Coordinates coordinates;
    protected int Attack;
    protected int Defence;
    protected int HitPoints;
    protected int Weapon;
    protected int Armor;
    protected int Helm;
    
    protected ArrayList<String> Artifacts;
    
    public HeroModel(String Name) {
        this.Name = Name;
        this.Level = 0;
        this.Experience = 0;
        heroId = id;
        id++;
        this.coordinates = new Coordinates(getLevel());
    }

    public HeroModel(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        this.Name = Name;
        this.Level = level;
        this.Experience = Experience;
        this.heroId = id;
        this.Experience  = Experience;
        this.Weapon = Weapon;
        this.Armor = Armor;
        this.Helm = Helm;
        this.coordinates = new Coordinates(getLevel());
    }

    public String getName() {
        return this.Name;
    }

    public int getLevel() {
        return this.Level;
    }

    public void gainExperience() {
        this.Experience = this.Experience + this.Level*1000 + (this.Level - 1)*(this.Level - 1)*450;
        System.out.println(this.Experience);
        if(this.Experience >= 1000 || this.Experience >= 2450 || this.Experience >= 4800 || this.Experience >= 8050 || this.Experience >= 12200) {
            this.gainLevel();
            this.Experience = 0;
        } else {
            this.updateCoordinates();
        }
        HeroFactory.createHeroProfile(this);
        
    }

    public int getExperience() {
        return this.Experience;
    }

    public int getXCoordinate() {
        return this.coordinates.getXCoordinate();
    }

    public int getYCoordinate() {
        return this.coordinates.getYCoordinate();
    }

    private void updateCoordinates() {
        this.coordinates = new Coordinates(this.getLevel());
    }

    public void gainLevel() {
        HeroFactory.createHeroProfile(this);
        this.Level++;
        this.updateCoordinates();
    }

    public int getId(){
        return this.heroId;
    }

    public int getWeapon() {
        return this.Weapon;
    }

    public int getHelm() {
        return this.Helm;
    }

    public int getArmor() {
        return this.Armor;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    




//     Hero name
// • Hero class
// • Level
// • Experience
// • Attack
// • Defense
// • Hit Points
    
}