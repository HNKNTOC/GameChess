package com.GameChes.logic.mouseListener;

import com.GameChes.logic.gChes.GChes;
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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

/**
 * Created by Nikita on 09.04.2016.
 */
public class MouseListenerGChes implements MouseListener {
    private GBoard gBoard;
    private boolean clicked;
    private GCell pressedGCell;
    private GObject pressedGObject;

    private ArrayList<GPanel> backlightCells = new ArrayList<>();

    public MouseListenerGChes(GBoard gBoard) {
        this.gBoard = gBoard;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        GPanelCell panelCell = (GPanelCell) e.getComponent();
        DynamicParameter dynamicValues = panelCell.getDynamicValues();
        int x = Integer.parseInt(dynamicValues.getParameter("X"));
        int y = Integer.parseInt(dynamicValues.getParameter("Y"));
        GCell gCell = gBoard.getListGCell().get(x, y);
        clickedGCell(gCell);

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
        backlightCell((GChes) gCell.getGObject());

        pressedGCell = gCell;
        if (pressedGObject == null) {
            pressedGObject = gCell.getGObject();
        } else {
            ActionCommand command = pressedGObject.getReceiverAction().getActionCommand(0);
            command.setParameters(CommandMoveAbstract.NAME_PARAMETER_X, pressedGCell.getX() + "");
            command.setParameters(CommandMoveAbstract.NAME_PARAMETER_Y, pressedGCell.getY() + "");
            command.execute();
            reset();
        }
    }

    private void reset() {
        pressedGObject = null;
        pressedGCell = null;
    }

    private void backlightCell(GChes gChes) {
        resetBacklight();
        if (gChes != null) {
            CommandChesMove command = (CommandChesMove) gChes.getReceiverAction().getActionCommand(0);
            List<Coordinate> listPosition = command.getListPosition();
            ListGCell<GCell> listGCell = gBoard.getListGCell();
            for (Coordinate coord : listPosition) {
                GPanelCell panel = listGCell.get(coord.getX(), coord.getY()).getGPanel();
                panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION, "1");
                panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION_COLOR, "255,0,0");
                panel.repaint();
                backlightCells.add(panel);
            }
        }
    }

    private void resetBacklight() {
        for (GPanel panel : backlightCells) {
            panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION, "0");
            panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION_COLOR, "0,0,0");
            panel.repaint();
        }
    }
}
