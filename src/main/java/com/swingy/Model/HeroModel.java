package com.swingy.Model;

import java.util.ArrayList;

/**
 * HeroModel
 */
public abstract class HeroModel {

    private String Name;
    private int Level = 0;
    private int Experience = 0;
    private Coordinates coordinates = new Coordinates();
    
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

    public void gainLevel() {
        this.Level++;
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