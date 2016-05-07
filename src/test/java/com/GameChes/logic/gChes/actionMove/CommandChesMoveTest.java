package com.GameChes.logic.gChes.actionMove;

import com.GameChes.logic.gCellChes.GCellChessFactory;
import com.GameChes.logic.gChes.GChes;
import com.GameChes.logic.gChes.GChesPawn;
import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.coordinate.CoordinatePars;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Nikita on 01.05.2016.
 */
@RunWith(Parameterized.class)
public class CommandChesMoveTest extends Assert {
    private static final int MAX_X = 8;
    private static final int MAX_Y = 8;
    private final CommandChesMove commandChesMove;
    private final List<Coordinate> coordListTrue;
    private final GChes gChes;
    private final GBoard gBoard;

    public CommandChesMoveTest(List<Object> data) {
        gChes = (GChes) data.get(0);
        gBoard = (GBoard) data.get(1);
        coordListTrue = (List) data.get(2);
        commandChesMove = new CommandChesMove(gChes,gBoard);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void check() throws Exception {
        for (Coordinate coord : coordListTrue) {
            int x = coord.getX();
            int y = coord.getY();
            assertTrue(commandChesMove.check(x, y));
            commandChesMove.move(x,y, gChes.getX(), gChes.getY());
        }
    }

    @Test
    public void move() throws Exception {

    }

    @Parameterized.Parameters
    public static List<Object> isEmptyData(){
        ArrayList<Object> returnList = new ArrayList<>();

        String[] coordListTrue = {"4,4","4,3","4,2","4,1","4,0"};
        returnList.add(CreateListData(new GChesPawn(),coordListTrue));
        return returnList;
    }

    /**
     * Данный метод создаёт моссив в котором хранятся данный нужные для провереи
     * наследников класса CommandChesMove.
     * Данные помешаются в следуюшем порядке.
     *  listDate[0] - GChes который который нужно переместить.
     *  listDate[1] - GBoard который был помещен в CommandChesMove при создании.
     *  listDate[2] - List<Point> listPointTrue координыты на которые GObject может перейти.
     * @param gChes фабрика котороя создаст CommandChesMove.
     * @param coordListTrue listPointTrue координыты на которые GObject может перейти.
     * @return лист с данных.
     */
    private static List<Object> CreateListData(GChes gChes, String[] coordListTrue){
        ArrayList<Object> listDate = new ArrayList<>();

        GBoard gBoard = new GBoard(new GCellChessFactory().createListGCell(MAX_X, MAX_Y));
        gBoard.getListGCell().get(4,6).setGObject(gChes);
        gChes.setX(4);
        gChes.setY(6);

        listDate.add(gChes);
        listDate.add(gBoard);
        List<Coordinate> pointsTrue = CoordinatePars.parsListCoordinate(Arrays.asList(coordListTrue));
        listDate.add(pointsTrue);
        return listDate;
    }


    private static int getRandom(){
        return new Random().nextInt(100);
    }

}