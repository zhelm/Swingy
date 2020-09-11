package com.swingy.Model;

import java.util.ArrayList;

public class VillainModel {

    private String Name;
    
    protected int Attack;
    protected int Defence;
    protected int HitPoints;
    public Coordinates coordinates;

    public VillainModel(int level, float villainX, float villainY) {
        this.coordinates = new Coordinates(level, villainX, villainY);
    }

    public void moveVillain(int x, int y, ArrayList<VillainModel> Villains) {
        String Type = this.getClass().getSimpleName();
        // Todo add collision

        if(Type.equals("DarkMage")) {
            if(this.coordinates.getYCoordinate() > x) {
                this.coordinates.moveNorth(Villains, -1);
            }
            else if(this.coordinates.getXCoordinate() > y) {
                this.coordinates.moveWest(Villains, -1);
            }
            else if (this.coordinates.getYCoordinate() < x) {
                this.coordinates.moveSouth(Villains, 1);
            }
            else if(this.coordinates.getXCoordinate() < y) {
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

   

    // private boolean collisionWestEast(ArrayList<VillainModel> Villains, int direction) {
    //     for (int i = 0; i < Villains.size(); i++) {
    //         if((this.coordinates.getXCoordinate() + direction) == Villains.get(i).coordinates.getXCoordinate()) {
    //             System.out.println("Collision detected in West/East direction");
    //         }
    //         return true;

    //     }
    // }
}
