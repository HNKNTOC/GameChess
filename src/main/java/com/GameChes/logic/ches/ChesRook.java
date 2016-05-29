package com.GameChes.logic.ches;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Created by Nikita on 07.05.2016.
 */
public class ChesRook extends Ches {
    public ChesRook() {
    }

/*    @Override
    public void countValidCoordinates(ListGCell<GCell> listGCell) {
        final int x = getX();
        final int y = getY();

        int upY = y;
        int downY = y;
        int leftX = x;
        int rightX = x;
        for (int i = 0; i < 9; i++) {
            upY--;
            addCoordinates(x, upY);
            downY++;
            addCoordinates(x, downY);
            leftX--;
            addCoordinates(leftX, y);
            rightX++;
            addCoordinates(rightX, y);
        }
    }*/
}
