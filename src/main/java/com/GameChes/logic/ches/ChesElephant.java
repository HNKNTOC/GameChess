package com.GameChes.logic.ches;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Created by Nikita on 07.05.2016.
 */
public class ChesElephant extends Ches {

    public ChesElephant() {

    }

    @Override
    public void countValidCoordinates(ListGCell<GCell> listGCell) {
        final int oldX = getX();
        final int oldY = getY();

        for (int i = 0; i < 10; i++) {
            int x = oldX;
            int y = oldY;
            x--;
            y--;
            if(!checkCoordinates(x,y,listGCell)) return;
            addCoordinates(x, y);
        }

        for (int i = 0; i < 10; i++) {
            int x = oldX;
            int y = oldY;
            x++;
            y--;
            if(!checkCoordinates(x,y,listGCell)) return;
            addCoordinates(x, y);
        }
        for (int i = 0; i < 10; i++) {
            int x = oldX;
            int y = oldY;
            x--;
            y++;
            if(!checkCoordinates(x,y,listGCell)) return;
            addCoordinates(x, y);
        }
        for (int i = 0; i < 10; i++) {
            int x = oldX;
            int y = oldY;
            x++;
            y++;
            if(!checkCoordinates(x,y,listGCell)) return;
            addCoordinates(x, y);
        }
    }

}
