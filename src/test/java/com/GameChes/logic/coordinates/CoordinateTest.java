package com.GameChes.logic.coordinates;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Тест для Coordinate.
 */
public class CoordinateTest {

    private Coordinate coordinate;
    private int x,y;

    @Before
    public void setUp() throws Exception {
        x = new Random().nextInt(1000);
        y = new Random().nextInt(1000);
        coordinate = new Coordinate(x,y);
    }

    @Test
    public void SetAndGetX() throws Exception {
        assertTrue(coordinate.getX()==x);
        int newX = new Random().nextInt(1000);
        coordinate.setX(newX);
        assertTrue(coordinate.getX()==newX);
    }

    @Test
    public void SetAndGetY() throws Exception {
        assertTrue(coordinate.getY()==y);
        int newY = new Random().nextInt(1000);
        coordinate.setY(newY);
        assertTrue(coordinate.getY()==newY);
    }


    @Test
    public void hashCodeAndEquals() throws Exception {
        Coordinate coordinateTrue = new Coordinate(x, y);
        assertTrue(coordinate.equals(coordinateTrue));
        assertTrue(coordinate.hashCode() == coordinateTrue.hashCode());

        Coordinate coordinateFalse1 = new Coordinate(x + 1, y);
        Coordinate coordinateFalse2 = new Coordinate(x, y + 1);

        assertFalse(this.coordinate.equals(coordinateFalse1));
        assertFalse(this.coordinate.equals(coordinateFalse2));
        assertFalse(this.coordinate.hashCode() == coordinateFalse1.hashCode());
        assertFalse(this.coordinate.hashCode() == coordinateFalse2.hashCode());
    }

}