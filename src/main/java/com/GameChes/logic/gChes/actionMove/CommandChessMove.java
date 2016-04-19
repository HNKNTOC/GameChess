package com.GameChes.logic.gChes.actionMove;

import com.GameChes.logic.gChes.GChesParameters;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveAbstract;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Nikita on 16.04.2016.
 */
public abstract class CommandChessMove extends CommandMoveAbstract {

    public CommandChessMove(GObject gObject,GBoard gBoard) {
        super(gObject, gBoard);
        if(gObject.getDynamicValues().getParameter(GChesParameters.ParametersName.TYPE)
                .equals(GChesParameters.ParametersValue.TYPE_GCHESS)) {
            this.gObject = gObject;
            this.gBoard = gBoard;
        }else {
            System.out.print("Переданный gObject в CommandChessMove не евляется GChess!!!");
        }
    }

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
     * Вычисляет все возможные координаты куда может пойти шахматная фигурка.
     * @return Список с координатами на которые может пойти шахматная фигурка.
     */
    protected abstract ArrayList<Point> calculatePoint();
}
