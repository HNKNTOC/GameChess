package com.GameChes.logic.gChes;

import com.GameEngine.logic.coordinate.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 07.05.2016.
 */
public class GChesHorse extends GChes {
    @Override
    public List<Coordinate> countValidCoordinates() {
        List<Coordinate> points = new ArrayList<>();
        int x = getX();
        int y = getY();

        points.add(new Coordinate(x+1,y-2));
        points.add(new Coordinate(x-1,y-2));
        points.add(new Coordinate(x+1,y+2));
        points.add(new Coordinate(x-1,y+2));

        return points;
    }
}
