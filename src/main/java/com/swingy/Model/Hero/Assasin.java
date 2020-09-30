package com.swingy.Model.Hero;

import java.util.ArrayList;

import com.swingy.Model.HeroModel;
import com.swingy.Model.VillainModel;

public class Assasin extends HeroModel {

    public Assasin(String Name) {
        super(Name);
        this.HitPoints = 2000;
        this.Attack = 10;
        this.Defence = 2;
        this.Artifacts = new ArrayList<String>();
    }

    public Assasin(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        super(Name, level, id, Experience, Weapon, Armor, Helm);
        this.HitPoints = 200;
        this.Attack = 10;
        this.Defence = 2;
    }

    // String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm
    public static Assasin getNewAssasin(String name) {
        return new Assasin(name);
    }


    public static Assasin getAssasin(String Name, int level, int id, int Experience, int Weapon, int Armor, int Helm) {
        return new Assasin(Name, level, id, Experience, Weapon, Armor, Helm);
    }

    @Override
    public void Attack(Object Villain) {
        System.out.println("Hello world");
        VillainModel villain = (VillainModel)Villain;
        this.HitPoints = this.HitPoints - villain.getAttack();
        villain.recieveDamage(this.Attack);
        if(this.HitPoints <= 0) {
            // Lose
            System.out.println("Now this is a loss");
        } else if(!(villain.getHitpoints() <= 0)){
            // Attack again
            System.out.println("Needed to attack again");
            Attack(Villain);
        } else {
            System.out.println("This MOFO is dead now");
            // win and recieve reward
        }
    }

    @Override
    public void Run() {

    }

    @Override
    public void Move(String direction) {
        
    }

    
}
