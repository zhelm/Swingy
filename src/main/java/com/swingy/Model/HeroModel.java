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

    public void gainExperience(int amount) {
        // level*1000+(level − 1)^2*450
        // • Level 1 - 1000 XP
        // • Level 2 - 2450 XP
        // • Level 3 - 4800 XP
        // • Level 4 - 8050 XP
        // • Level 5 - 12200 XP
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

    public void moveNorth() {
        this.coordinates.moveYCoordinate(-1);
    }

    public void moveSouth() {
        this.coordinates.moveYCoordinate(1);
    }

    public void moveWest() {
        this.coordinates.moveXCoordinate(-1);
    }

    public void moveEast() {
        this.coordinates.moveXCoordinate(1);
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