package com.swingy.Model;

import java.util.ArrayList;

/**
 * HeroModel
 */
public abstract class HeroModel {

    private String Name;
    private int Level = 0;
    private int Experience = 0;
    private Coordinates coordinates = new Coordinates(getLevel());
    
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
        System.out.println(this.Experience);
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

    public boolean moveNorth() {
        this.coordinates.moveYCoordinate(-1);
        System.out.println(this.coordinates.getMapSize());
        if(this.coordinates.getYCoordinate() < 0) {
            System.out.println("win");
            this.gainExperience();
            return true;
        }
        return false;
    }

    public boolean moveSouth() {
        this.coordinates.moveYCoordinate(1);
        if(this.coordinates.getYCoordinate() >= coordinates.getMapSize()) {
            System.out.println("win");
            this.gainExperience();
            return true;
        }
        return false;
    }

    public boolean moveWest() {
        this.coordinates.moveXCoordinate(-1);
        if(this.coordinates.getXCoordinate() < 0) {
            System.out.println("win");
            this.gainExperience();
            return true;
        }
        return false;
    }

    public boolean moveEast() {
        this.coordinates.moveXCoordinate(1);
        if(this.coordinates.getXCoordinate() >= coordinates.getMapSize()) {
            System.out.println("win");
            this.gainExperience();
            return true;
        }
        return false;
    }

    public abstract void Attack();
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