package com.swingy.Model;

public class VillainModel {

    private String Name;
    
    protected int Attack;
    protected int Defence;
    protected int HitPoints;
    public Coordinates coordinates;

    public VillainModel(int level, float villainX, float villainY) {
        this.coordinates = new Coordinates(level, villainX, villainY);
    }

    public void moveVillain(int x, int y) {
        String Type = this.getClass().getSimpleName();
        // Todo add collision
        // System.out.println(x + "  " + y);
        // System.out.println(this.coordinates.getXCoordinate() + "  " + this.coordinates.getYCoordinate());
        
        if(Type.equals("DarkMage")) {
            if(this.coordinates.getYCoordinate() > x) {
                this.coordinates.moveNorth();
            }
            else if(this.coordinates.getXCoordinate() > y) {
                this.coordinates.moveWest();
            }
            else if (this.coordinates.getYCoordinate() < x) {
                this.coordinates.moveSouth();
            }
            else if(this.coordinates.getXCoordinate() < y) {
                this.coordinates.moveEast();
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
}
