package com.GameChes.logic.coordinates;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Тест для CoordinatePars.
 */
public class CoordinateParsTest {

    private int x;
    private int y;

    @Before
    public void setUp() throws Exception {
        x = new Random().nextInt(1000);
        y = new Random().nextInt(1000);
    }

    @Test
    public void parsPoint() throws Exception {
        Coordinate coord = CoordinatePars.parsPoint(x + "," + y);
        assertNotNull(coord);
        assertTrue(coord.equals(new Coordinate(x,y)));
    }

    @Test
    public void parsPoint1() throws Exception {
        Coordinate coord = CoordinatePars.parsPoint(x + ";" + y,";");
        assertNotNull(coord);
        assertTrue(coord.equals(new Coordinate(x,y)));
    }

    @Test
    public void parsPointNull() throws Exception {
        Coordinate coord1 = CoordinatePars.parsPoint("test text");
        Coordinate coord2 = CoordinatePars.parsPoint("23 32");
        Coordinate coord3 = CoordinatePars.parsPoint("23;32");
        assertNull(coord1);
        assertNull(coord2);
        assertNull(coord3);
    }

}