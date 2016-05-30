package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;

/**
 * Created by Nikita on 30.05.2016.
 */
public class CommandMovePawn extends CommandMoveChes {
    public CommandMovePawn(Ches ches, GBoard gBoard) {
        super(ches, gBoard, false);
    }

    @Override
    protected void countValidCoordinates(int oldX, int oldY) {
        super.countValidCoordinates(oldX, oldY);
        Ches ches = getObject();
        int i = 1;
        int i1 = 2;

        if(ches.getDynamicValues().getParameterInt(Ches.COLOR_PAWN)==0) {
            i = -1;
            i1 = -2;
        }
        if (!addCoordinate(oldX, oldY - i)) {
            return;
        }
        if (ches.getDynamicValues().getParameterInt(NUMBER_MOVE)<=0) {
            addCoordinate(oldX, oldY - i1);
        }
    }
}
