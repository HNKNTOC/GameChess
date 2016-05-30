package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by Nikita on 30.05.2016.
 */
public class CommandMoveRook extends CommandMoveChes {
    private static final Logger LOGGER = LogManager.getLogger(CommandMoveRook.class);
    public CommandMoveRook(Ches ches, GBoard gBoard) {
        super(ches, gBoard, false);
    }

    @Override
    protected void countValidCoordinates(int oldX, int oldY) {
        super.countValidCoordinates(oldX, oldY);

        countRight(oldX, oldY);
        countUp(oldX, oldY);
        countDown(oldX, oldY);
        countLeft(oldX, oldY);
    }

    private void countRight(int oldX, int oldY) {
        LOGGER.debug("==Count Right==");
        for (int i = 0; i < 9; i++) {
            oldX++;
            if (!addCoordinate(oldX, oldY)) break;
        }
        LOGGER.debug("=======");
    }

    private void countLeft(int oldX, int oldY) {
        LOGGER.debug("==Count Left==");
        for (int i = 0; i < 9; i++) {
            oldX--;
            if (!addCoordinate(oldX, oldY)) break;
        }
        LOGGER.debug("=======");
    }

    private void countDown(int oldX, int oldY) {
        LOGGER.debug("==Count Down==");
        for (int i = 0; i < 9; i++) {
            oldY++;
            if (!addCoordinate(oldX, oldY)) break;
        }
        LOGGER.debug("=======");
    }

    private void countUp(int oldX, int oldY) {
        LOGGER.debug("==Count Up==");
        for (int i = 0; i < 9; i++) {
            oldY--;
            if (!addCoordinate(oldX, oldY)) break;
        }
        LOGGER.debug("=======");
    }
}
