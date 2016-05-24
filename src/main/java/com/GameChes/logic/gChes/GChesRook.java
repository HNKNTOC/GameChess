package com.GameChes.logic.gChes;

import com.GameEngine.logic.coordinate.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 07.05.2016.
 */
public class GChesRook extends GChes {
    public GChesRook() {
    }

    @Override
    public List<Coordinate> countValidCoordinates() {
        List<Coordinate> points = new ArrayList<>();

        final int x = getX();
        final int y = getY();

        int upY = y;
        int downY = y;
        int leftX = x;
        int rightX = x;
        for (int i = 0; i < 9; i++) {
            upY--;
            addCoordinates(x, upY, points);
            downY++;
            addCoordinates(x, downY, points);
            leftX--;
            addCoordinates(leftX, y, points);
            rightX++;
            addCoordinates(rightX, y, points);
        }
        return points;
    }

    private void addCoordinates(int x, int y, List<Coordinate> points){
        points.add(new Coordinate(x,y));
    }
}
