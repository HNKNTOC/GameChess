package com.GameChes.logic.coordinates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Хранит в Себе координаты x и y.
 */
public class Coordinate {
    private int x;
    private int y;
    private static final Logger LOGGER = LogManager.getLogger(Coordinate.class);

    public Coordinate(int x, int y) {
        LOGGER.debug("Create x=" + x + " y=" + y);
        this.x = x;
        this.y = y;
    }

    public Coordinate() {
        LOGGER.debug("Create");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        LOGGER.debug("setX x=" + x);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        LOGGER.debug("setY y=" + y);
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        return x == that.x && y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
