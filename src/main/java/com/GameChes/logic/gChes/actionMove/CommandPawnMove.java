package com.GameChes.logic.gChes.actionMove;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 09.04.2016.
 */
public class CommandPawnMove extends CommandChessMove {

    public CommandPawnMove(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }


    @Override
    protected ArrayList<Point> calculatePoint() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(gObject.getX(), gObject.getY() - 1));
        if (gObject.getDynamicValues().getParameterInt(NAME_PARAMETER_NUMBER_MOVE)<=0) {
            points.add(new Point(gObject.getX(), gObject.getY() - 2));
        }
        return points;
    }
}
