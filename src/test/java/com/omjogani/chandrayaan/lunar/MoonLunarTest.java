package com.omjogani.chandrayaan.lunar;

import com.omjogani.chandrayaan.Commands;
import com.omjogani.chandrayaan.Directions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MoonLunarTest {
    ArrayList<Integer> boundaries;
    Lunar lunarTest;

    @BeforeEach
    void setUp() {
        boundaries = new ArrayList<Integer>();
        boundaries.add(3); // NORTH (0)
        boundaries.add(-3); // SOUTH(1)
        boundaries.add(3); // EAST  (2)
        boundaries.add(-3); // WEST (3)
        boundaries.add(3); // UP    (4)
        boundaries.add(-3); // DOWN (5)
        lunarTest = new MoonLunar(0,0,0, Directions.NORTH, boundaries);
    }

    @Test
    void checkLimitExceedTestCorrect() {
        assertTrue(lunarTest.checkLimitExceed(Directions.NORTH));
    }

    @Test
    void checkLimitExceedTestCorrectTwo() {
        lunarTest.forward(1);
        lunarTest.forward(1);
        assertTrue(lunarTest.checkLimitExceed(Directions.NORTH));
    }

    @Test
    void checkLimitExceedTestInCorrect() {
        lunarTest.forward(1);
        lunarTest.forward(1);
        lunarTest.forward(1);
        assertFalse(lunarTest.checkLimitExceed(Directions.NORTH));
    }

    @Test
    void checkForwardTrue() {
        assertNull(lunarTest.forward(1));
    }

    @Test
    void checkForwardTrueTwo() {
        lunarTest.forward(1);
        assertNull(lunarTest.forward(1));
    }

    @Test
    void checkForwardInCorrect() {
        lunarTest.forward(1);
        lunarTest.forward(1);
        lunarTest.forward(1);
        assertThrows(IllegalStateException.class,
                () -> {
                    lunarTest.forward(1);
                });
    }

    @Test
    void checkBackwardTrue() {
        assertNull(lunarTest.backward(1));
    }

    @Test
    void checkBackwardTrueTwo() {
        lunarTest.backward(1);
        assertNull(lunarTest.backward(1));
    }

    @Test
    void checkBackwardInCorrect() {
        lunarTest.backward(1);
        lunarTest.backward(1);
        lunarTest.backward(1);
        assertThrows(IllegalStateException.class,
                () -> {
                    lunarTest.forward(1);
                });
    }

    @Test
    void rotateRightGivesAnswerEast() {
        assertEquals(Directions.EAST, lunarTest.rotateRight());
    }

    @Test
    void rotateLeftGivesAnswerWest() {
        assertEquals(Directions.WEST, lunarTest.rotateLeft());
    }

    @Test
    void rotateUpGivesAnswerUp() {
        assertEquals(Directions.UP, lunarTest.rotateUp());
    }

    @Test
    void rotateDownGivesAnswerDown() {
        assertEquals(Directions.DOWN, lunarTest.rotateDown());
    }

    @Test
    void displayValueCorrect() {
        ArrayList<String> values  = new ArrayList<>();
        values.add("0");
        values.add("2");
        values.add("0");
        values.add("NORTH");
        lunarTest.forward(1);
        lunarTest.forward(1);
        assertEquals(values, lunarTest.displayPosition());
    }
}