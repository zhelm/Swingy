package com.swingy.Model;

import java.util.ArrayList;
import java.util.Random;

import com.swingy.Interfaces.ICharacter;
import com.swingy.Model.SwingyDatabase.SwingyDatabase;

/**
 * HeroModel
 */
public class HeroModel implements ICharacter {

    private String Name;
    private String Type;
    private int Level;
    private int Experience;
    private int heroId;
    public Coordinates coordinates;
    protected int Attack;
    protected int Defence;
    protected int HitPoints;
    protected int Weapon;
    protected int Armor;
    protected int Helm;
    
    protected ArrayList<String> Artifacts;

    public HeroModel(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm, int HitPoints, int Attack, int Defence, String Type) {
        this.Name = Name;
        this.Level = level;
        this.Experience = Experience;
        this.heroId = id;
        this.Experience  = Experience;
        this.Weapon = Weapon;
        this.Armor = Armor;
        this.Helm = Helm;
        this.coordinates = new Coordinates(getLevel());
        this.Type = Type;
        this.HitPoints = HitPoints + Helm;
        this.Attack = Attack + Weapon;
        this.Armor = Armor + Armor;
    }

    public int getHitpoints() {
        return this.HitPoints + this.Helm;
    }

    public int getAttack() {
        return this.Weapon + this.Attack;
    }

    public int getDefence() {
        return this.Defence + this.Armor;
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
        SwingyDatabase.gainExperience(this.Experience, this.heroId);
        if(this.Experience >= 1000 || this.Experience >= 2450 || this.Experience >= 4800 || this.Experience >= 8050 || this.Experience >= 12200) {
            this.gainLevel();
            this.Experience = 0;
        } else {
            this.updateCoordinates();
        }
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
        this.Level++;
        SwingyDatabase.gainLevel(this.heroId, this.Level);;
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

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public boolean Attack(Object Enemy) {
        VillainModel villain = (VillainModel)Enemy;
        this.HitPoints = this.getHitpoints() - (villain.getAttack() - this.getArmor());
        villain.recieveDamage(this.getAttack());
        if(this.HitPoints <= 0) {
            // Lose
            System.out.println("Now this is a loss");
        } else if(!(villain.getHitpoints() <= 0)){
            // Attack again
            System.out.println("Needed to attack again");
            return Attack(Enemy);
        } else {
            System.out.println("This MOFO is dead now");
            Random rand = new Random();
            float chance = rand.nextFloat();
            if(chance > 0.80) {
                // Get great reward
                SwingyDatabase.upgradeArmor(this.heroId, (this.Armor = this.Armor + 25));
                SwingyDatabase.upgradeWeapon(this.heroId, (this.Weapon = this.Weapon + 25));
                SwingyDatabase.upgradeHelm(this.heroId, (this.Helm = this.Helm + 25));
            } else if(chance > 0.60) {
                // Get medium reward
                SwingyDatabase.upgradeArmor(this.heroId, (this.Armor = this.Armor + 25));
                SwingyDatabase.upgradeHelm(this.heroId, (this.Helm = this.Helm + 25));
            } else {
                // get basic reward
                SwingyDatabase.upgradeArmor(this.heroId, (this.Helm = this.Helm + 25));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean Run(Object Enemy) {
        Random rand = new Random();
        if(rand.nextFloat() >= 0.5) {
            return true;
        } else {
            return Attack(Enemy);
        }
    }

    




//     Hero name
// • Hero class
// • Level
// • Experience
// • Attack
// • Defense
// • Hit Points
    
}