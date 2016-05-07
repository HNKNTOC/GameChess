package com.GameChes.logic.gChes.actionMove;

import com.GameChes.logic.coordinates.Coordinate;
import com.GameChes.logic.coordinates.CoordinatePars;
import com.GameChes.logic.gCellChes.GCellChessFactory;
import com.GameChes.logic.gChes.actionMove.factory.CommandChessFactory;
import com.GameChes.logic.gChes.actionMove.factory.CommandPawnMoveFactory;
import com.GameChes.logic.gChes.factory.GChessFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Nikita on 01.05.2016.
 */
@RunWith(Parameterized.class)
public class CommandChessMoveTest extends Assert {
    private static final int MAX_X = 8;
    private static final int MAX_Y = 8;
    private final CommandChessMove commandChessMove;
    private final List<Point> coordListTrue;
    private final GObject gObject;
    private final GBoard gBoard;

    public CommandChessMoveTest(List<Object> data) {
        this.commandChessMove = (CommandChessMove) data.get(0);
        gObject = (GObject) data.get(1);
        gBoard = (GBoard) data.get(2);
        coordListTrue = (List) data.get(3);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void check() throws Exception {
        for (Point point : coordListTrue) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            assertTrue(commandChessMove.check(x, y));
            commandChessMove.move(x,y,gObject.getX(),gObject.getY());
        }
    }

    @Test
    public void move() throws Exception {

    }

    @Parameterized.Parameters
    public static List<Object> isEmptyData(){
        ArrayList<Object> returnList = new ArrayList<>();

        String[] coordListTrue = {"4,4","4,3","4,2","4,1","4,0"};
        returnList.add(CreateListData(new CommandPawnMoveFactory(),coordListTrue));
        return returnList;
    }

    /**
     * Данный метод создаёт моссив в котором хранятся данный нужные для провереи
     * наследников класса CommandChessMove.
     * Данные помешаются в следуюшем порядке.
     *  listDate[0] - Обьект который реалезует CommandChessMove.
     *  listDate[1] - GObject который был помещен в CommandChessMove при создании.
     *  listDate[2] - GBoard который был помещен в CommandChessMove при создании.
     *  listDate[3] - List<Point> listPointTrue координыты на которые GObject может перейти.
     * @param factoryCommand фабрика котороя создаст CommandChessMove.
     * @param coordListTrue listPointTrue координыты на которые GObject может перейти.
     * @return лист с данных.
     */
    private static List<Object> CreateListData(CommandChessFactory factoryCommand, String[] coordListTrue){
        GChessFactory factory = new GChessFactory();

        ArrayList<Object> listDate = new ArrayList<>();

        GObject chess = factory.createChess(null);
        GBoard gBoard = new GBoard(new GCellChessFactory().createListGCell(MAX_X, MAX_Y));
        gBoard.getListGCell().get(4,6).setGObject(chess);
        chess.setX(4);
        chess.setY(6);

        listDate.add(factoryCommand.createCommandChessMove(gBoard,chess));
        listDate.add(chess);
        listDate.add(gBoard);
        List<Coordinate> pointsTrue = CoordinatePars.parsListPoint(Arrays.asList(coordListTrue));
        listDate.add(pointsTrue);
        return listDate;
    }


    private static int getRandom(){
        return new Random().nextInt(100);
    }

}