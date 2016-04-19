package com.GameChes.logic.gChes.actionMove;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 20.04.2016.
 */
public class CommandHorseMove extends CommandChessMove {

    public CommandHorseMove(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }

    @Override
    protected ArrayList<Point> calculatePoint() {
        int x = gObject.getX();
        int y = gObject.getY();
        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(x+1,y-2));
        points.add(new Point(x-1,y-2));
        points.add(new Point(x+1,y+2));
        points.add(new Point(x-1,y+2));

        return points;
    }
}
