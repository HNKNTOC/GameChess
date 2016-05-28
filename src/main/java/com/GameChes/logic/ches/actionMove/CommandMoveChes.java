package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveAbstract;
import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;

import java.util.ArrayList;

/**
 * Реализация для перемешения GChess.
 * Данная команда перемещает GChess
 */
public class CommandMoveChes extends CommandMoveAbstract {

    /**
     * Имя параметра.
     * Колличество ходов.
     */
    public static final String NAME_PARAMETER_NUMBER_MOVE = "numberMove";

    public CommandMoveChes(Ches ches, GBoard gBoard) {
        super(ches, gBoard);
        ches.getDynamicValues().putParameterInt(NAME_PARAMETER_NUMBER_MOVE, 0);
    }

    @Override
    public Ches getObject() {
        return (Ches) super.getObject();
    }

    /**
     * Проверка может ли шахматная фигурка перейти на координаты x и y.
     *
     * @param x координата на которую нужно переместить шахматную фигурку.
     * @param y ордината на которую нужно переместить шахматную фигурку.
     * @return true только если шахматная фигурка может перейти на координаты x и y.
     */
    @Override
    protected boolean check(int x, int y) {
        for (Coordinate coord : getListPosition()) {
            if (coord.getX() == x & coord.getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает список координат на которые могут перейти шахматная фигурка.
     *
     * @return Список с координатами на которые может пойти шахматная фигурка.
     */
    public ArrayList<Coordinate> getListPosition() {
        ArrayList<Coordinate> coords = new ArrayList<>();
        for (Coordinate coord : getObject().getValidCoordinates(getBoard().getListGCell())) {
            if (checkMaxX(coord.getX()) & checkMaxY(coord.getY())) {
                coords.add(coord);
            }
        }
        return coords;
    }

    /**
     * Перемешение выполняется супер классом.
     * Выполняет метод incrementMove() при каждом перемешении.
     *
     * @param x    координата клетки в которую нужно передвинуть.
     * @param y    координата клетки в которую нужно передвинуть.
     * @param oldX координата клетки из которой нужно передвинуть gObject.
     * @param oldY координата клетки из которой нужно передвинуть gObject.
     */
    @Override
    protected void move(int x, int y, int oldX, int oldY) {
        super.move(x, y, oldX, oldY);
        incrementMove();
    }

    /**
     * Прибавляет 1 к параметру NUMBER_MOVE.
     * incrementMove() должен выполнятся при каждом перемещении.
     */
    private void incrementMove() {
        DynamicParameter dynamicValues = getObject().getDynamicValues();
        int parameterInt = dynamicValues.getParameterInt(NAME_PARAMETER_NUMBER_MOVE);
        parameterInt++;
        dynamicValues.putParameterInt(NAME_PARAMETER_NUMBER_MOVE, parameterInt);
    }
}
