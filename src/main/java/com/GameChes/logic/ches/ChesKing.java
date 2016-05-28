package com.GameChes.logic.ches;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Created by Nikita on 07.05.2016.
 */
public class ChesKing extends Ches {
    public ChesKing() {

    }

    @Override
    public void countValidCoordinates(ListGCell<GCell> listGCell) {
        final int y = getY();
        final int x = getX();
        addCoordinates(x+1, y);
        addCoordinates(x-1, y);
        addCoordinates(x, y+1);
        addCoordinates(x, y-1);

        addCoordinates(x-1, y-1);
        addCoordinates(x+1, y+1);

        addCoordinates(x-1, y+1);
        addCoordinates(x+1, y-1);
    }
}
