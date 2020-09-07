package com.swingy.Model;

public class Coordinates {
    
    private float x;
    private float y;
    private int mapsize;

    // This one is for the Hero
    public Coordinates(int Level) {
        mapsize = (Level-1)*5+10-(Level%2);  
        x = mapsize/2;
        y = x;
    }

    // This one is for the Villain
    public Coordinates(int level, float villainX, float villainY) {
        mapsize = (level-1)*5+10-(level%2);
        x = (mapsize)*(villainX);
        y = (mapsize)*(villainY); 

        if(x == mapsize) x--;
        if(y == mapsize) y--;
    }

    public int getXCoordinate(){
        return (int)this.x;
    }

    public int getYCoordinate() {
        return (int)this.y;
    }
    public int getMapSize() {
        return this.mapsize;
    }

    public void moveXCoordinate(int n) {
        this.x = this.x + n;
    }

    public void moveYCoordinate(int n) {
        this.y = this.y + n;
    }
    

}
