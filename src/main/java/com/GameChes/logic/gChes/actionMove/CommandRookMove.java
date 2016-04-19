package com.GameChes.logic.gChes.actionMove;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 16.04.2016.
 */
public class CommandRookMove extends CommandChessMove {

    public CommandRookMove(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }

    @Override
    protected ArrayList<Point> calculatePoint() {
        ArrayList<Point> points = new ArrayList<>();

        final int x = gObject.getX();
        final int y = gObject.getY();

        int upY = y;
        int downY = y;
        int leftX = x;
        int rightX = x;
        for (int i = 0; i < 9; i++) {
            upY--;
            addPoint(x,upY,points);
            downY++;
            addPoint(x,downY,points);
            leftX--;
            addPoint(leftX,y,points);
            rightX++;
            addPoint(rightX,y,points);
        }
        return points;
    }

    private void addPoint(int x, int y, ArrayList<Point> points){
        points.add(new Point(x,y));
    }

}
