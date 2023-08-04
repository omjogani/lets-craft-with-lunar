package com.omjogani.chandrayaan.lunar;

import com.omjogani.chandrayaan.Directions;

import java.util.ArrayList;

public abstract class Lunar {
    public abstract boolean checkLimitExceed(Directions direction);
    public abstract Object forward(int unit);
    public abstract Object backward(int unit);
    public abstract Directions rotateRight();
    public abstract Directions rotateLeft();
    public abstract Directions rotateUp();
    public abstract Directions rotateDown();
    public abstract ArrayList<String> displayPosition();
}
