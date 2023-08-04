package com.omjogani.chandrayaan.controller;

import com.omjogani.chandrayaan.Directions;
import com.omjogani.chandrayaan.lunar.MoonLunar;


public class EarthController{
    public void handleLunar() {
        MoonLunar moon = new MoonLunar(0,0,0, Directions.NORTH);
        moon.forward(1);
        moon.rotateRight();
        moon.rotateUp();
        moon.backward(1);
        moon.rotateLeft();
//        moon.displayPosition();
    }
}
