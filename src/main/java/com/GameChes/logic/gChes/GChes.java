package com.GameChes.logic.gChes;


import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.util.List;

/**
 * Реализация Шахматной фигурки.
 */
public abstract class GChes extends GObject {
    /**
     * Имя параметра.
     * Колличество ходов.
     */
    public static final String NAME_PARAMETER_NUMBER_MOVE = "numberMove";

    public GChes() {
        getDynamicValues().putParameterInt(NAME_PARAMETER_NUMBER_MOVE, 0);
    }



    /**
     * Вычисляет все возможные координаты куда может пойти шахматная фигурка.
     *
     * @return Список с координатами на которые может пойти шахматная фигурка.
     */
    public abstract List<Coordinate> countValidCoordinates();

}
