package com.GameChes.logic.gChes.actionMove;

import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 21.04.2016.
 */
public class CommandQueenMove extends CommandChessMove {
    public CommandQueenMove(GObject gObject, GBoard gBoard) {
        super(gObject, gBoard);
    }

    @Override
    protected ArrayList<Point> calculatePoint() {
        ArrayList<Point> listPosition1 = new CommandElephantMove(gObject, gBoard).getListPosition();
        ArrayList<Point> listPosition2 = new CommandRookMove(gObject, gBoard).getListPosition();
        listPosition1.addAll(listPosition2);
        return listPosition1;
    }
}
