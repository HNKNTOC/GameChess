package com.GameChes.logic.ches;

import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

/**
 * Created by Nikita on 07.05.2016.
 */
public class ChesHorse extends Ches {
    public ChesHorse() {

    }

    /*@Override
    public void countValidCoordinates(ListGCell<GCell> listGCell) {
        int x = getX();
        int y = getY();

        addCoordinates(x-1,y+2);
        addCoordinates(x-1,y-2);

        addCoordinates(x+1,y+2);
        addCoordinates(x+1,y-2);

        addCoordinates(x-2,y+1);
        addCoordinates(x-2,y-1);

        addCoordinates(x+2,y+1);
        addCoordinates(x+2,y-1);
    }*/
}
