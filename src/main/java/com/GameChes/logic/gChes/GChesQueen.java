package com.GameChes.logic.gChes;

import com.GameEngine.logic.coordinate.Coordinate;

import java.util.List;

/**
 * Created by Nikita on 07.05.2016.
 */
public class GChesQueen extends GChes {
    @Override
    public List<Coordinate> countValidCoordinates() {
        GChesElephant elephant = new GChesElephant();
        elephant.setX(getX());
        elephant.setY(getY());
        List<Coordinate> listPosition1 = elephant.countValidCoordinates();

        GChesRook gChesRook = new GChesRook();
        gChesRook.setX(getX());
        gChesRook.setY(getY());
        List<Coordinate> listPosition2 = gChesRook.countValidCoordinates();
        listPosition1.addAll(listPosition2);
        return listPosition1;
    }
}
