package com.GameChes.logic.gChes;

import com.GameEngine.logic.coordinate.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 07.05.2016.
 */
public class GChesElephant extends GChes {

    public GChesElephant() {

    }

    @Override
    public List<Coordinate> countValidCoordinates() {
        List<Coordinate> points = new ArrayList<>();
        final int oldX = getX();
        final int oldY = getY();

        int upLeftX = oldX;
        int upLeftY = oldY;

        int upRightX = oldX;

        int downRightX = oldX;

        int downLeftX = oldX;
        int downLeftY = oldY;

        for (int i = 0; i < 10; i++) {
            upLeftX--;
            upLeftY--;
            points.add(new Coordinate(upLeftX,upLeftY));
            upRightX++;
            points.add(new Coordinate(upRightX,upLeftY));
            downLeftX--;
            downLeftY++;
            points.add(new Coordinate(downLeftX,downLeftY));
            downRightX++;
            points.add(new Coordinate(downRightX,downLeftY));
        }
        return points;
    }
}
