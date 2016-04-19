package com.GameChes.logic.gChes.actionMove;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 20.04.2016.
 */
public class CommandElephantMove extends CommandChessMove {

    public CommandElephantMove(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }

    @Override
    protected ArrayList<Point> calculatePoint() {
        ArrayList<Point> points = new ArrayList<>();
        final int oldX = gObject.getX();
        final int oldY = gObject.getY();

        int upLeftX = oldX;
        int upLeftY = oldY;

        int upRightX = oldX;

        int downRightX = oldX;

        int downLeftX = oldX;
        int downLeftY = oldY;

        for (int i = 0; i < 10; i++) {
            upLeftX--;
            upLeftY--;
            points.add(new Point(upLeftX,upLeftY));
            upRightX++;
            points.add(new Point(upRightX,upLeftY));
            downLeftX--;
            downLeftY++;
            points.add(new Point(downLeftX,downLeftY));
            downRightX++;
            points.add(new Point(downRightX,downLeftY));
        }
        return points;
    }
}
