package com.swingy.Model;

public class Coordinates {
    
    private int x;
    private int y;
    public Coordinates(int Level) {
        x = ((Level-1)*5+10-(Level%2))/2;
        y = x;
    }

    public int getXCoordinate(){
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public void moveXCoordinate(int n) {
        this.x = this.x + n;
    }

    public void moveYCoordinate(int n) {
        this.y = this.y + n;
    }

}
