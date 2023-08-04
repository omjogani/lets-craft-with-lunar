package com.omjogani.chandrayaan.controller;

import com.omjogani.chandrayaan.Commands;
import com.omjogani.chandrayaan.Directions;
import com.omjogani.chandrayaan.lunar.MoonLunar;
import com.omjogani.chandrayaan.lunar.Lunar;

import java.util.ArrayList;
import java.util.Arrays;

public class EarthController{
    ArrayList<Commands> listOfCommands;

    public EarthController(ArrayList<Commands> listOfCommands) {
        this.listOfCommands = listOfCommands;
    }

    public void handleLunar() {
        ArrayList<Integer> boundaries = new ArrayList<>();
        boundaries.add(3); // NORTH (0)
        boundaries.add(-3); // SOUTH (1)
        boundaries.add(3); // EAST  (2)
        boundaries.add(-3); // WEST  (3)
        boundaries.add(3); // UP    (4)
        boundaries.add(-3); // DOWN  (5)
        Lunar moon = new MoonLunar(0,0,0, Directions.NORTH, boundaries);
        for(Commands command : listOfCommands){
            if(command == Commands.FORWARD) {
                moon.forward(1);
            } else if (command == Commands.BACKWARD) {
                moon.backward(1);
            } else if(command == Commands.UP) {
                moon.rotateUp();
            } else if(command == Commands.DOWN) {
                moon.rotateDown();
            } else if(command == Commands.LEFT) {
                moon.rotateLeft();
            } else if(command == Commands.RIGHT) {
                moon.rotateRight();
            }
        }
    }
}
