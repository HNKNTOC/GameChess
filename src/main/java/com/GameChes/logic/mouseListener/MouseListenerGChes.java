package com.GameChes.logic.mouseListener;

import com.GameChes.logic.gChes.actionMove.CommandChesMove;
import com.GameEngine.logic.action.command.ActionCommand;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveAbstract;
import com.GameEngine.logic.coordinate.Coordinate;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCell;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;


/**
 * Created by Nikita on 09.04.2016.
 */
public class MouseListenerGChes implements MouseListener {
    private static final Logger LOGGER = LogManager.getLogger(MouseListenerGChes.class);
    private GBoard gBoard;
    /**
     * Последний pressedGCell на который нажали.
     */
    private GCell pressedGCell;
    /**
     * Последний GObject на который нажали.
     */
    private GObject pressedGObject;
    /**
     * GObject который находится в pressedGCell.
     */
    private GObject thisGObject;

    private final ArrayList<GPanel> highlightedCells = new ArrayList<>();

    public MouseListenerGChes(GBoard gBoard) {
        this.gBoard = gBoard;
        LOGGER.info("Create "+toString());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Получает из компонента GCell и передаёт его clickedGCell();
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        LOGGER.debug("============Released============");
        LOGGER.debug("mouseReleased "+e.toString());
        GPanelCell panelCell = (GPanelCell) e.getComponent();
        DynamicParameter dynamicValues = panelCell.getDynamicValues();
        int x = Integer.parseInt(dynamicValues.getParameter("X"));
        int y = Integer.parseInt(dynamicValues.getParameter("Y"));
        GCell gCell = gBoard.getListGCell().get(x, y);
        clickedGCell(gCell);
        LOGGER.debug("===============================");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Обрабатывает клик на GCell
     *
     * @param gCell на который нажали.
     */
    private void clickedGCell(GCell gCell) {
        LOGGER.debug("Clicked on "+gCell.toString());
        pressedGCell(gCell);
        if (pressedGObject == null) {
            pressedGObject(thisGObject);
        } else {
            move();
        }
    }

    /**
     * Передвигает pressedGObject в pressedGCell.
     */
    private void move(){
        if(thisGObject!=null){
            clashGObject();
            return;
        }
        if (executeMoveCommand()) {
            reset();
        }else {
            pressedGObject(thisGObject);
        }
        highlightsMoveCell(pressedGObject);
    }

    /**
     * Метод обрабатывает движение pressedGObject на thisGObject.
     */
    private void clashGObject(){
        LOGGER.debug("clashGObject");
        pressedGObject(thisGObject);
    }

    /**
     * Выполняет команду движения для pressedGObject.
     * @return true если передвижение успешно.
     */
    private boolean executeMoveCommand(){
        ActionCommand command = pressedGObject.getReceiverAction().getActionCommand(0);
        command.setParameters(CommandMoveAbstract.NAME_PARAMETER_X, pressedGCell.getX() + "");
        command.setParameters(CommandMoveAbstract.NAME_PARAMETER_Y, pressedGCell.getY() + "");
        return command.execute();
    }

    private void pressedGObject(GObject object){
        pressedGObject = object;
        highlightsMoveCell(pressedGObject);
        LOGGER.debug("pressedGObject = "+pressedGObject);
    }

    private void pressedGCell(GCell gCell){
        pressedGCell = gCell;
        thisGObject = gCell.getGObject();
        LOGGER.debug("pressedGCell = "+pressedGCell+" thisGObject = "+thisGObject);
    }

    private void reset() {
        pressedGObject = null;
        pressedGCell = null;
    }

    /**
     * Подсвечивает клетки на которые может пойти gObject.
     * @param gObject ходы которого нужно подсветить.
     */
    private void highlightsMoveCell(GObject gObject) {
        LOGGER.debug("Add highlights "+ gObject);
        resetHighlights();
        if (gObject != null) {
            CommandChesMove command = (CommandChesMove) gObject.getReceiverAction().getActionCommand(0);
            List<Coordinate> listPosition = command.getListPosition();
            ListGCell<GCell> listGCell = gBoard.getListGCell();
            for (Coordinate coord : listPosition) {
                GPanelCell panel = listGCell.get(coord.getX(), coord.getY()).getGPanel();
                panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION, "1");
                panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION_COLOR, "255,0,0");
                panel.repaint();
                highlightedCells.add(panel);
            }
        }else {
            LOGGER.debug("gObject == null");
        }
    }

    /**
     * Убрать подсветку у всех подсвеченных клеток.
     */
    private void resetHighlights() {
        LOGGER.debug("resetHighlights");
        for (GPanel panel : highlightedCells) {
            panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION, "0");
            panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION_COLOR, "0,0,0");
            panel.repaint();
        }
        highlightedCells.clear();
    }
}
