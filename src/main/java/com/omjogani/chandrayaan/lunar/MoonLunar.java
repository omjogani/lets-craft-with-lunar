package com.omjogani.chandrayaan.lunar;

import com.omjogani.chandrayaan.Directions;

import java.util.ArrayList;

public class MoonLunar extends Lunar{
    private int xAxis, yAxis, zAxis;
    private Directions direction;
    ArrayList<Integer> boundaries;

    public MoonLunar(int xAxis, int yAxis, int zAxis, Directions direction, ArrayList<Integer> boundaries){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
        this.direction = direction;
        this.boundaries = boundaries;
        System.out.println("Initially");
        displayPosition();
    }

    public boolean checkLimitExceed() {
        if(direction == Directions.NORTH || direction == Directions.SOUTH) {
            return yAxis <= boundaries.get(0) && yAxis >= boundaries.get(1);
        } else if(direction == Directions.EAST || direction == Directions.WEST) {
            return xAxis <= boundaries.get(2) && xAxis >= boundaries.get(3);
        } else if(direction == Directions.UP || direction == Directions.DOWN) {
            return zAxis <= boundaries.get(4) && zAxis >= boundaries.get(5);
        } else {
            return false;
        }
    }

    @Override
    public void forward(int unit) {
        if(!checkLimitExceed()){

            throw new IllegalStateException("Lunar Forward Exceeded at the boundaries! " + direction);
        }
        if(direction == Directions.UP || direction == Directions.DOWN) {
            zAxis = zAxis + unit;
        } else if(direction == Directions.NORTH || direction == Directions.SOUTH) {
            yAxis = yAxis + unit;
        } else if(direction == Directions.EAST || direction == Directions.WEST) {
            xAxis = xAxis + unit;
        }
        displayPosition();
    }

    @Override
    public void backward(int unit) {
        if(!checkLimitExceed()){
            throw new IllegalStateException("Lunar Backward Exceeded reached at the boundaries! " + direction);
        }
        if(direction == Directions.UP || direction == Directions.DOWN) {
            zAxis = zAxis - unit;
        } else if(direction == Directions.NORTH || direction == Directions.SOUTH) {
            yAxis = yAxis - unit;
        } else if(direction == Directions.EAST || direction == Directions.WEST) {
            xAxis = xAxis - unit;
        }
        displayPosition();
    }


    @Override
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

    @Override
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

    @Override
    public void rotateUp() {
        direction = Directions.UP;
        displayPosition();
    }

    @Override
    public void rotateDown() {
        direction = Directions.DOWN;
        displayPosition();
    }

    @Override
    public void displayPosition() {
        System.out.println(xAxis + " " + yAxis + " " + zAxis + ": " + direction);
    }
}
