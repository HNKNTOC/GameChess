package com.GameChes.logic.ches.actionMove;

import com.GameChes.logic.ches.Ches;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveAbstract;
import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import org.apache.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный класс для всех комманд передвижения.
 * Наследники должны переопределить метод countValidCoordinates().
 */
public abstract class CommandMoveChes extends CommandMoveAbstract {
    private static final org.apache.log4j.Logger LOGGER = LogManager.getLogger(CommandMoveChes.class);
    /**
     * Имя параметра.
     * Количество ходов.
     */
    public static final String NUMBER_MOVE = "numberMove";

    /**
     * Список координат на который может переместиться Ches.
     */
    private final List<Coordinate> validCoordinates;
    /**
     * Может ли ches проходить через другие ches.
     */
    private final boolean permeability;

    public CommandMoveChes(Ches ches, GBoard gBoard, boolean permeability) {
        super(ches, gBoard);
        this.permeability = permeability;
        ches.getDynamicValues().putParameterInt(NUMBER_MOVE, 0);
        validCoordinates = new ArrayList<>();
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
                LOGGER.debug("check coord = ("+x+";"+y+") true");
                return true;
            }
        }
        LOGGER.debug("check coord = ("+x+";"+y+") false");
        return false;
    }

    /**
     * Возвращает список координат на которые могут перейти шахматная фигурка.
     *
     * @return Список с координатами на которые может пойти шахматная фигурка.
     */
    public List<Coordinate> getListPosition() {
        LOGGER.debug("====getListPosition====");
        validCoordinates.clear();
        countValidCoordinates(getObject().getX(),getObject().getY());
        LOGGER.debug("================ return "+validCoordinates.toString());
        return validCoordinates;
    }

    /**
     * Вычисляет все возможные координаты куда может пойти шахматная фигурка.
     * И добавляет их через метод addCoordinate().
     *
     * @param oldX координата начальной клетки по x.
     * @param oldY координата начальной клетки по y.
     */
    protected void countValidCoordinates(final int oldX,final int oldY){
        LOGGER.debug("=====countValidCoordinates=====");
        LOGGER.debug("Start coord = ("+oldX+";"+oldY+")");
    }

    /**
     * Добавляет координату в validCoordinates.
     * Перед добавлением проверяет её.
     *
     * @param x координата клетки x.
     * @param y координата клетки y.
     * @return false если превышает x или y максимальное значение или
     * если есть в этой координате другой Ches.
     */
    protected boolean addCoordinate(int x, int y) {
        LOGGER.debug("new ("+x+";"+y+")");
        if(checkMaxCoordinate(x,y)){
            if(checkPermeability(x,y)){
                LOGGER.debug("addCoordinate coord = ("+x+";"+y+") true and add");
                validCoordinates.add(new Coordinate(x,y));
                return true;
            }
            LOGGER.debug("addCoordinate coord = ("+x+";"+y+") false and add");
            validCoordinates.add(new Coordinate(x,y));
            return false;
        }
        LOGGER.debug("addCoordinate coord = ("+x+";"+y+") false");
        return false;
    }

    /**
     * Проверка превышает ли x и y максимального значения.
     *
     * @param x координата клетки x.
     * @param y координата клетки y.
     * @return false если x или y превышает максимальное значения.
     */
    private boolean checkMaxCoordinate(int x, int y) {
        return checkMaxX(x) & checkMaxY(y);
    }

    /**
     * Проверяет есть ли на данной клетке GChes.
     * @param x координата клетки x.
     * @param y координата клетки y.
     * @return
     */
    private boolean checkPermeability(int x, int y) {
        if(!permeability){
            if(getBoard().getListGCell().get(x,y).getGObject()!=null){
                LOGGER.debug("checkPermeability coord = ("+x+";"+y+") false");
                return false;
            }
        }
        LOGGER.debug("checkPermeability coord = ("+x+";"+y+") true");
        return true;
    }

    /**
     * Перемещение выполняется супер классом.
     * Выполняет метод incrementMove() при каждом перемещении.
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
        int parameterInt = dynamicValues.getParameterInt(NUMBER_MOVE);
        parameterInt++;
        dynamicValues.putParameterInt(NUMBER_MOVE, parameterInt);
        LOGGER.debug("incrementMove NUMBER_MOVE = "+parameterInt);
    }
}
