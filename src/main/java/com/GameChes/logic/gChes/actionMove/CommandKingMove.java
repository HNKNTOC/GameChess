package com.GameChes.logic.gChes.actionMove;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 21.04.2016.
 */
public class CommandKingMove extends CommandChessMove {
    public CommandKingMove(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }

    @Override
    protected ArrayList<Point> calculatePoint() {
        ArrayList<Point> points = new ArrayList<>();
        final int y = gObject.getY();
        final int x = gObject.getX();
        points.add(new Point(x+1, y));
        points.add(new Point(x-1, y));
        points.add(new Point(x, y+1));
        points.add(new Point(x, y-1));

        points.add(new Point(x-1, y-1));
        points.add(new Point(x+1, y+1));

        points.add(new Point(x-1, y+1));
        points.add(new Point(x+1, y-1));
        return points;
    }
}
