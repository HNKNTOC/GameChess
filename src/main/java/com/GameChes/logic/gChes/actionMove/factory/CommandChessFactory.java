package com.GameChes.logic.gChes.actionMove.factory;

import com.GameChes.logic.gChes.actionMove.CommandChessMove;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Базовый класс фабрики для CommandChessMove.
 */
public interface CommandChessFactory {
    CommandChessMove createCommandChessMove(GBoard gBoard, GObject chess);
}
