package com.GameChes.logic.gChes.actionMove.factory;

import com.GameChes.logic.gChes.actionMove.CommandChesMove;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Базовый класс фабрики для CommandChesMove.
 */
public interface CommandChessFactory {
    CommandChesMove createCommandChessMove(GBoard gBoard, GObject chess);
}
