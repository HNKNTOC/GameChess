package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Вычисляет возможные ходы для шахматной фигурки Elephant.
 */
public class CommandMoveHorse extends CommandMoveChes {
    private static final Logger LOGGER = LogManager.getLogger(CommandMoveHorse.class);

    public CommandMoveHorse(Ches ches, GBoard gBoard) {
        super(ches, gBoard, true);
    }

    @Override
    protected void countValidCoordinates(int oldX, int oldY) {
        super.countValidCoordinates(oldX,oldY);

        addCoordinate(oldX-1,oldY+2);
        addCoordinate(oldX-1,oldY-2);

        addCoordinate(oldX+1,oldY+2);
        addCoordinate(oldX+1,oldY-2);

        addCoordinate(oldX-2,oldY+1);
        addCoordinate(oldX-2,oldY-1);

        addCoordinate(oldX+2,oldY+1);
        addCoordinate(oldX+2,oldY-1);
        LOGGER.debug("===============");
    }
}
