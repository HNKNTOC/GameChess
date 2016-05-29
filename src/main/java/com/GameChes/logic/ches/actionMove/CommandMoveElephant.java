package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import org.apache.log4j.LogManager;

/**
 * Вычисляет возможные ходы для шахматной фигурки Elephant.
 */
public class CommandMoveElephant extends CommandMoveChes {
    private static final org.apache.log4j.Logger LOGGER = LogManager.getLogger(CommandMoveChes.class);
    public CommandMoveElephant(Ches ches, GBoard gBoard) {
        super(ches, gBoard, false);
    }

    @Override
    protected void countValidCoordinates() {
        LOGGER.debug("=====countValidCoordinates=====");
        final int oldX = object.getX();
        final int oldY = object.getY();
        LOGGER.debug("Start coord = ("+oldX+";"+oldY+")");

        countLeftUp(oldX, oldY);
        countRightUp(oldX, oldY);
        countLeftDown(oldX, oldY);
        countRightDown(oldX, oldY);
        LOGGER.debug("===============");
    }

    private void countRightDown(int x, int y) {
        LOGGER.debug("==Count right down==");
        for (int i = 0; i < 10; i++) {
            x++;
            y++;
            LOGGER.debug("new ("+x+";"+y+")");
            if (!addCoordinate(x, y)){ LOGGER.debug("break"); break;}
        }
        LOGGER.debug("=========");
    }

    private void countLeftDown(int x, int y) {
        LOGGER.debug("==Count left down==");
        for (int i = 0; i < 10; i++) {
            x--;
            y++;
            LOGGER.debug("new ("+x+";"+y+")");
            if (!addCoordinate(x, y)){ LOGGER.debug("break"); break;}
        }
        LOGGER.debug("=========");
    }

    private void countRightUp(int x, int y) {
        LOGGER.debug("==Count right up==");
        for (int i = 0; i < 10; i++) {
            x++;
            y--;
            LOGGER.debug("new ("+x+";"+y+")");
            if (!addCoordinate(x, y)){ LOGGER.debug("break"); break;}
        }
        LOGGER.debug("=========");
    }

    private void countLeftUp(int x, int y) {
        LOGGER.debug("==Count left up==");
        for (int i = 0; i < 10; i++) {
            x--;
            y--;
            LOGGER.debug("new ("+x+";"+y+")");
            if (!addCoordinate(x, y)){ LOGGER.debug("break"); break;}
        }
        LOGGER.debug("=========");
    }
}
