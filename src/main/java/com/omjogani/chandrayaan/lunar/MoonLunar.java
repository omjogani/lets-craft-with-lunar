package com.omjogani.chandrayaan.lunar;

import com.omjogani.chandrayaan.Directions;

//abstract class Lunar {
//    public abstract void move(Directions direction, int unit);
//    public abstract void rotateRight();
//    public abstract void rotateLeft();
//    public abstract void rotateUp();
//    public abstract void rotateDown();
//    public abstract void displayPosition();
//}


public class MoonLunar{
    private int xAxis, yAxis, zAxis;
    private Directions direction;

    public MoonLunar(int xAxis, int yAxis, int zAxis, Directions direction){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
        this.direction = direction;
    }


    public void forward(int unit) {
        if(direction == Directions.UP || direction == Directions.DOWN) {
            zAxis = zAxis + unit;
        } else if(direction == Directions.NORTH || direction == Directions.SOUTH) {
            yAxis = yAxis + unit;
        } else if(direction == Directions.EAST || direction == Directions.WEST) {
            xAxis = xAxis + unit;
        }
        displayPosition();
    }

    public void backward(int unit) {
        if(direction == Directions.UP || direction == Directions.DOWN) {
            zAxis = zAxis - unit;
        } else if(direction == Directions.NORTH || direction == Directions.SOUTH) {
            yAxis = yAxis - unit;
        } else if(direction == Directions.EAST || direction == Directions.WEST) {
            xAxis = xAxis - unit;
        }
        displayPosition();
    }



    public void rotateRight() {
        if(direction == Directions.NORTH) {
            direction = Directions.EAST;
        } else if (direction == Directions.EAST) {
            direction = Directions.SOUTH;
        } else if (direction == Directions.SOUTH) {
            direction = Directions.WEST;
        } else if (direction == Directions.WEST) {
            direction = Directions.NORTH;
        } else if(direction == Directions.UP) {
            direction = Directions.EAST;
        } else if(direction == Directions.DOWN) {
            direction = Directions.WEST;
        }
        displayPosition();
    }


    public void rotateLeft() {
        if(direction == Directions.NORTH) {
            direction = Directions.WEST;
        } else if (direction == Directions.WEST) {
            direction = Directions.SOUTH;
        } else if (direction == Directions.SOUTH) {
            direction = Directions.EAST;
        } else if (direction == Directions.EAST) {
            direction = Directions.NORTH;
        } else if(direction == Directions.UP) {
            direction = Directions.WEST;
        } else if(direction == Directions.DOWN) {
            direction = Directions.EAST;
        }
        displayPosition();
    }


    public void rotateUp() {
        direction = Directions.UP;
        displayPosition();
    }


    public void rotateDown() {
        direction = Directions.DOWN;
        displayPosition();
    }


    public void displayPosition() {
        System.out.println(xAxis + " " + yAxis + " " + zAxis + ": " + direction);
    }
}
