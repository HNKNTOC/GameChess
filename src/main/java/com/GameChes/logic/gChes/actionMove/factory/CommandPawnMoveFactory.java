package com.GameChes.logic.gChes.actionMove.factory;

import com.GameChes.logic.gChes.actionMove.CommandPawnMove;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Created by Nikita on 02.05.2016.
 */
public class CommandPawnMoveFactory implements CommandChessFactory {
    @Override
    public CommandPawnMove createCommandChessMove(GBoard gBoard, GObject chess) {
        return new CommandPawnMove(chess,gBoard);
    }
}
