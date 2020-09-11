package com.swingy.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Coordinates {

    private float x;
    private float y;
    private int mapsize;

    // This one is for the Hero
    public Coordinates(int Level) {
        mapsize = (Level - 1) * 5 + 10 - (Level % 2);
        x = mapsize / 2;
        y = x;
    }

    // This one is for the Villain
    public Coordinates(int level, float villainX, float villainY) {
        mapsize = (level - 1) * 5 + 10 - (level % 2);
        x = villainX;
        y = villainY;

        if (x == mapsize)
            x--;
        if (y == mapsize)
            y--;
    }

    public int getXCoordinate() {
        return (int) this.x;
    }

    public int getYCoordinate() {
        return (int) this.y;
    }

    public int getMapSize() {
        return this.mapsize;
    }

    private void moveXCoordinate(int n) {
        this.x = this.x + n;
    }

    private void moveYCoordinate(int n) {
        this.y = this.y + n;
    }

    public boolean moveNorth(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving North");
        if(collisionNorthSouth(Villains, -amount)) {
            
        }
        this.moveYCoordinate(-amount);
        if(getYCoordinate() < 0) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    public boolean moveSouth(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving South");

        if(collisionNorthSouth(Villains, amount)) {
        
        }

        this.moveYCoordinate(amount);
        if(getYCoordinate() >= getMapSize()) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    public boolean moveWest(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving West");
        if(collisionNorthSouth(Villains, amount)) {
        
        }

        this.moveXCoordinate(amount);
        if(getXCoordinate() < 0) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    public boolean moveEast(ArrayList<VillainModel> Villains, int amount) {
        System.out.println("Moving East");
        if(collisionNorthSouth(Villains, amount)) {
        
        }

        this.moveXCoordinate(amount);
        if(getXCoordinate() >= getMapSize()) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    private boolean collisionNorthSouth(ArrayList<VillainModel> Villains, int direction) {
        System.out.println(this.getXCoordinate());
        System.out.println(this.getYCoordinate());
        for (int i = 0; i < Villains.size(); i++) {
            System.out.println(this);

            if((getYCoordinate() + direction) == Villains.get(i).coordinates.getYCoordinate() && getXCoordinate() == Villains.get(i).coordinates.getXCoordinate()) {
                System.out.println(Villains.get(i).coordinates.getYCoordinate());
                System.out.println("Collision detected in North/South direction");
            }
        }
        return true;
    }
    
    // private boolean collisionEastWest(ArrayList<VillainModel> Villains, int direction) {
    //     System.out.println(getYCoordinate() + direction);
        
    //     for (int i = 0; i < Villains.size(); i++) {
    //         if((getYCoordinate() + direction) == Villains.get(i).coordinates.getYCoordinate()) {
    //             System.out.println(Villains.get(i).coordinates.getYCoordinate());
    //             System.out.println("Collision detected in North/South direction");
    //         }
    //     }
    //     return true;
    // }

    //Hero uses this movement method
    public boolean moveDirection(String direction, ArrayList<VillainModel> Villains)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException {
        Method method;
        Class[] cArg = new Class[2];
        cArg[0] = Villains.getClass();
        System.out.println(cArg[0]);
        cArg[1] = int.class;

        method = this.getClass().getMethod("move" + direction, cArg);
        return (boolean)method.invoke(this, Villains, 1);
    }


}
