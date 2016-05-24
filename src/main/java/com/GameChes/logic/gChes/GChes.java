package com.GameChes.logic.gChes;


import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
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
    public static final String NUMBER_MOVE = "numberMove";
    /**
     * Имя параметра.
     * Цвет GChes 0 - черная 1 - белая.
     */
    public static final String COLOR_PAWN = "colorPawn";

    public GChes() {
        DynamicParameter dynamicValues = getDynamicValues();
        dynamicValues.putParameterInt(NUMBER_MOVE, 0);
        dynamicValues.putParameterInt(COLOR_PAWN, 0);
    }


    /**
     * Вычисляет все возможные координаты куда может пойти шахматная фигурка.
     *
     * @return Список с координатами на которые может пойти шахматная фигурка.
     */
    public abstract List<Coordinate> countValidCoordinates();

}
