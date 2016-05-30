package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;

/**
 * Created by Nikita on 30.05.2016.
 */
public class CommandMoveKing extends CommandMoveChes {
    public CommandMoveKing(Ches ches, GBoard gBoard) {
        super(ches, gBoard, false);
    }

    @Override
    protected void countValidCoordinates(int oldX, int oldY) {
        super.countValidCoordinates(oldX, oldY);
        addCoordinate(oldX+1, oldY);
        addCoordinate(oldX-1, oldY);
        addCoordinate(oldX, oldY+1);
        addCoordinate(oldX, oldY-1);

        addCoordinate(oldX-1, oldY-1);
        addCoordinate(oldX+1, oldY+1);

        addCoordinate(oldX-1, oldY+1);
        addCoordinate(oldX+1, oldY-1);
    }
}
