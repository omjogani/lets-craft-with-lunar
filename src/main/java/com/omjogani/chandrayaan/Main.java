package com.omjogani.chandrayaan;

import com.omjogani.chandrayaan.controller.EarthController;

public class Main {
    public static void main(String[] args) {
        EarthController earthController = new EarthController();
        earthController.handleLunar();
    }
}
