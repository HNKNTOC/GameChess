package com.GameChes.logic.ches;


import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

/**
 * Реализация Шахматной фигурки.
 */
public class Ches extends GObject {
    /**
     * Имя параметра.
     * Колличество ходов.
     */
    public static final String NUMBER_MOVE = "numberMove";
    /**
     * Имя параметра.
     * Цвет Ches 0 - черная 1 - белая.
     */
    public static final String COLOR_PAWN = "colorPawn";

    public Ches() {
        DynamicParameter dynamicValues = getDynamicValues();
        dynamicValues.putParameterInt(NUMBER_MOVE, 0);
        dynamicValues.putParameterInt(COLOR_PAWN, 0);
    }


    /**
     * Проверка может ли Ches передвинутся на кординаты.
     * @param x координата.
     * @param y координата.
     * @return false если Ches yне может передвинутся.
     */
    protected boolean checkCoordinates(int x,int y,ListGCell<GCell> listGCell){

        return listGCell.get(x,y).getGObject() != null;
    }
}
