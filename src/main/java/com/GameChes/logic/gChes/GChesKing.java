package com.GameChes.logic.gChes;

import com.GameEngine.logic.coordinate.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 07.05.2016.
 */
public class GChesKing extends GChes {
    @Override
    public List<Coordinate> countValidCoordinates() {
        List<Coordinate> points = new ArrayList<>();
        final int y = getY();
        final int x = getX();
        points.add(new Coordinate(x+1, y));
        points.add(new Coordinate(x-1, y));
        points.add(new Coordinate(x, y+1));
        points.add(new Coordinate(x, y-1));

        points.add(new Coordinate(x-1, y-1));
        points.add(new Coordinate(x+1, y+1));

        points.add(new Coordinate(x-1, y+1));
        points.add(new Coordinate(x+1, y-1));
        return points;
    }
}
