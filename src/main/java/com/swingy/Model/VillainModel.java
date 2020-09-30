package com.swingy.Model;

import java.util.ArrayList;

import com.swingy.Interfaces.ICharacter;

public abstract class VillainModel implements ICharacter {

    protected int Attack;
    protected int Defence;
    protected int HitPoints;
    public Coordinates coordinates;

    public VillainModel(String name, int level, float villainX, float villainY) {
        this.coordinates = new Coordinates(level, villainX, villainY);
    }

    // This is TOTALLY NOT SOLID
    public void moveVillain(int x, int y, ArrayList<VillainModel> Villains) {
        String Type = this.getClass().getSimpleName();

        //Already check if a collision happens here. Lets not do that here
        if(Type.equals("DarkMage")) {
            if(this.coordinates.getYCoordinate() > y && !checkHeroCollision(x, y, 0, -1)) {
                this.coordinates.moveNorth(Villains, 1);
            }
            else if(this.coordinates.getXCoordinate() > x && !checkHeroCollision(x, y, -1, 0)) {
                this.coordinates.moveWest(Villains, 1);
            }
            else if (this.coordinates.getYCoordinate() < y && !checkHeroCollision(x, y, 0, 1)) {
                this.coordinates.moveSouth(Villains, 1);
            }
            else if(this.coordinates.getXCoordinate() < x && !checkHeroCollision(x, y, 1, 0)) {
                this.coordinates.moveEast(Villains, 1);
            }
        }

        // if(Type.equals("Demon")) {
        //     if(this.coordinates.getXCoordinate() != x) {
        //         this.moveX(x, 2);
        //     } else {
        //         this.moveY(y, 2);
        //     }
        //     System.out.println("I am moving a Demon");
        // }

        // if(Type.equals("Orc")) {
        //     if(this.coordinates.getXCoordinate() != x) {
        //         this.moveX(x, 1);
        //     } else {
        //         this.moveY(y, 1);
        //     }
        //     System.out.println("I am moving an Orc");
        // }
    }

    private boolean checkHeroCollision(int HeroX, int HeroY, int amountX, int amountY) {
        if((this.coordinates.getXCoordinate() + amountX) == HeroX && (this.coordinates.getYCoordinate() + amountY) == HeroY) {
            //Ask what the user wants to do. Then either attack or let user run.
            System.out.println("Going to attack the Hero");
            return true;
        }
        return false;    
    }
   
    public abstract void Attack(Object Enemy);
    public abstract void Run();

    public int getHitpoints() {
        return this.HitPoints;
    }
    public int getDefence() {
        return this.Defence;
    }
    public int getAttack() {
        return this.Attack;
    }

    public void recieveDamage(int amount) {
        this.HitPoints = this.HitPoints - amount;
    }
}
