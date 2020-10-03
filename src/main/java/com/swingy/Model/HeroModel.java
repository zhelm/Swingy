package com.swingy.Model;

import java.util.ArrayList;
import java.util.Random;

import javax.validation.constraints.NotNull;

import com.swingy.Controller.GameController;
import com.swingy.Interfaces.ICharacter;
import com.swingy.Model.SwingyDatabase.SwingyDatabase;

/**
 * HeroModel
 */
public class HeroModel implements ICharacter {
    @NotNull
    private String Name;
    @NotNull
    private String Type;
    @NotNull
    private int Level;
    @NotNull
    private int Experience;
    @NotNull
    private int heroId;
    @NotNull
    public Coordinates coordinates;
    @NotNull
    protected int Attack;
    @NotNull
    protected int Defence;
    @NotNull
    protected int HitPoints;
    @NotNull
    protected int Weapon;
    @NotNull
    protected int Armor;
    @NotNull
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

    public void gainExperience(int amount) {
        this.Experience = this.Experience + amount;
        SwingyDatabase.gainExperience(this.Experience, this.heroId);
        if(this.Experience >= (this.Level*1000 + (this.Level - 1)*(this.Level - 1)*450)) {
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
            if(GameController.isConsole) {
                System.out.println("Now this is a loss");
            }
            // lose game
        } else if(!(villain.getHitpoints() <= 0)){
            // Attack again
            if(GameController.isConsole) {
                System.out.println("Needed to attack again");
            }
            return Attack(Enemy);
        } else {
            if(GameController.isConsole) {
                System.out.println("The enemy has been defeated");
            }
            gainExperience(300);
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
        float test = rand.nextFloat();
        if(test >= 0.5) {
            return true;
        } else {
            return false;
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