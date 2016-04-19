package com.GameChes.logic.gChes.actionMove.factory;

import com.GameChes.logic.gChes.actionMove.CommandChessMove;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Created by Nikita on 17.04.2016.
 */
public interface CommandChessFactory {
    CommandChessMove createCommandChessMove(GBoard gBoard, GObject chess);
}
