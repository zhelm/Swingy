package com.swingy.Model;

import java.util.ArrayList;

import com.swingy.Interfaces.ICharacter;

/**
 * HeroModel
 */
public abstract class HeroModel implements ICharacter {

    private String Name;
    private int Level = 3;
    private int Experience = 0;

    public Coordinates coordinates = new Coordinates(getLevel());
    protected int Attack;
    protected int Defence;
    protected int HitPoints;
    protected ArrayList<String> Artifacts;
    
    public HeroModel(String Name) {
        this.Name = Name;
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
        this.Level++;
        this.updateCoordinates();
    }

    public abstract void Attack(Object Villain);
    public abstract void Run();
    public abstract void Move(String direction);




//     Hero name
// • Hero class
// • Level
// • Experience
// • Attack
// • Defense
// • Hit Points
    
}