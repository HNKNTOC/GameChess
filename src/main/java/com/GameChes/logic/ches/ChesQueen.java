package com.GameChes.logic.ches;

import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

import java.util.List;

/**
 * Created by Nikita on 07.05.2016.
 */
public class ChesQueen extends Ches {
    public ChesQueen() {
    }

/*    @Override
    public void countValidCoordinates(ListGCell<GCell> listGCell) {
        ChesElephant elephant = new ChesElephant();
        elephant.setX(getX());
        elephant.setY(getY());
        List<Coordinate> listPosition1 = elephant.getValidCoordinates(listGCell);

        ChesRook gChesRook = new ChesRook();
        gChesRook.setX(getX());
        gChesRook.setY(getY());
        List<Coordinate> listPosition2 = gChesRook.getValidCoordinates(listGCell);
        listPosition1.addAll(listPosition2);
        setValidCoordinates(listPosition1);
    }*/
}
