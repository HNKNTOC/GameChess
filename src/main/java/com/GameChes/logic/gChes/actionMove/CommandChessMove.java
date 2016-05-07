package com.GameChes.logic.gChes.actionMove;

import com.GameChes.logic.gChes.GChesParameters;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveAbstract;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 16.04.2016.
 */
public abstract class CommandChessMove extends CommandMoveAbstract {

    /**
     * Имя параметра.
     * Колличество ходов.
     */
    public static final String NAME_PARAMETER_NUMBER_MOVE = "numberMove";

    public CommandChessMove(GObject gObject,GBoard gBoard) {
        super(gObject, gBoard);
        if(gObject.getDynamicValues().getParameter(GChesParameters.ParametersName.TYPE)
                .equals(GChesParameters.ParametersValue.TYPE_GCHESS)) {
            this.gObject = gObject;
            this.gBoard = gBoard;
            gObject.getDynamicValues().putParameterInt(NAME_PARAMETER_NUMBER_MOVE,0);
        }else {
            System.out.print("Переданный gObject в CommandChessMove не евляется GChess!!!");
        }
    }

    /**
     * Проверка может ли шахматная фигурка перейти на координаты x и y.
     * @param x координата на которую нужно переместить шахматную фигурку.
     * @param y ордината на которую нужно переместить шахматную фигурку.
     * @return true только если шахматная фигурка может перейти на координаты x и y.
     */
    @Override
    protected boolean check(int x, int y) {
        for (Point point : getListPosition()) {
            if(point.getX()==x & point.getY()==y){
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает список координат на которые могут перейти шахматная фигурка.
     * @return Список с координатами на которые может пойти шахматная фигурка.
     */
    public ArrayList<Point> getListPosition(){
        ArrayList<Point> points = new ArrayList<>();
        for (Point point : calculatePoint()) {
            if(checkMaxX( (int) point.getX()) & checkMaxY((int) point.getY())){
                points.add(point);
            }
        }
        return points;
    }


    /**
     * Перемешение выполняется супер классом.
     * Выполняет метод incrementMove() при каждом перемешении.
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
     * Прибавляет 1 к параметру NAME_PARAMETER_NUMBER_MOVE.
     * incrementMove() должен выполнятся при каждом перемещении.
     */
    private void incrementMove(){
        DynamicParameter dynamicValues = gObject.getDynamicValues();
        int parameterInt = dynamicValues.getParameterInt(NAME_PARAMETER_NUMBER_MOVE);
        parameterInt++;
        dynamicValues.putParameterInt(NAME_PARAMETER_NUMBER_MOVE,parameterInt);
    }

    /**
     * Вычисляет все возможные координаты куда может пойти шахматная фигурка.
     * @return Список с координатами на которые может пойти шахматная фигурка.
     */
    protected abstract ArrayList<Point> calculatePoint();
}
