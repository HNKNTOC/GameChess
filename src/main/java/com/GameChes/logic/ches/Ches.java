package com.GameChes.logic.ches;


import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация Шахматной фигурки.
 */
public abstract class Ches extends GObject {
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
    private List<Coordinate> validCoordinates = new ArrayList<>();

    public Ches() {
        DynamicParameter dynamicValues = getDynamicValues();
        dynamicValues.putParameterInt(NUMBER_MOVE, 0);
        dynamicValues.putParameterInt(COLOR_PAWN, 0);
    }

    public List<Coordinate> getValidCoordinates(ListGCell<GCell> listGCell){
        countValidCoordinates(listGCell);
        return validCoordinates;
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

    /**
     * Добавить кординату в validCoordinates.
     * @param x
     * @param y
     */
    protected void addCoordinates(int x, int y){
        validCoordinates.add(new Coordinate(x,y));
    }

    protected void setValidCoordinates(List<Coordinate> validCoordinates) {
        this.validCoordinates = validCoordinates;
    }

    /**
     * Вычисляет все возможные координаты куда может пойти шахматная фигурка.
     *
     * @param listGCell
     */
    public abstract void countValidCoordinates(ListGCell<GCell> listGCell);

}
