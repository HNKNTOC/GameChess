package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;

import java.util.List;

/**
 * Created by Nikita on 30.05.2016.
 */
public class CommandMoveQueen extends CommandMoveChes {

    private final CommandMoveElephant commandMoveElephant;
    private final CommandMoveRook commandMoveRook;

    public CommandMoveQueen(Ches ches, GBoard gBoard) {
        super(ches, gBoard, false);
        commandMoveElephant = new CommandMoveElephant(getObject(),getBoard());
        commandMoveRook = new CommandMoveRook(getObject(), getBoard());
    }

    @Override
    protected void countValidCoordinates(int oldX, int oldY) {
        super.countValidCoordinates(oldX, oldY);
        List<Coordinate> listPosition1 = commandMoveElephant.getListPosition();
        List<Coordinate> listPosition2 = commandMoveRook.getListPosition();
        listPosition1.addAll(listPosition2);
        for (Coordinate coordinate : listPosition1) {
            addCoordinate(coordinate.getX(),coordinate.getY());
        }
    }
}
