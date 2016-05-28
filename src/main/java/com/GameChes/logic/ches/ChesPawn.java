package com.GameChes.logic.ches;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Реализация для Pawn.
 */
public class ChesPawn extends Ches {

    public ChesPawn() {

    }

    @Override
    public void countValidCoordinates(ListGCell<GCell> listGCell) {
        addCoordinates(getX(), getY() - 1);
        if (getDynamicValues().getParameterInt(NUMBER_MOVE)<=0) {
            addCoordinates(getX(), getY() - 2);
        }
    }
}
