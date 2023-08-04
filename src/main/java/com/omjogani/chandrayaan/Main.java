package com.omjogani.chandrayaan;

import com.omjogani.chandrayaan.controller.EarthController;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Commands> listOfCommands = new ArrayList<>(5);
        listOfCommands.add(Commands.FORWARD);
        listOfCommands.add(Commands.RIGHT);
        listOfCommands.add(Commands.UP);
        listOfCommands.add(Commands.BACKWARD);
        listOfCommands.add(Commands.LEFT);
        EarthController earthController = new EarthController(listOfCommands);
        earthController.handleLunar();
    }
}
