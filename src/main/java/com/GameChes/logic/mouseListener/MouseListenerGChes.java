package com.GameChes.logic.mouseListener;

import com.GameChes.logic.gChes.actionMove.CommandChessMove;
import com.GameEngine.logic.action.command.ActionCommand;
import com.GameEngine.logic.action.command.gObject.command.CommandMoveAbstract;
import com.GameEngine.logic.dynamicValues.DynamicParameter;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCell;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
        DynamicParameter<String, String> dynamicValues = panelCell.getDynamicValues();
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
     * @param gCell на который нажали.
     */
    private void clickedGCell(GCell gCell){
        backlightCell(gCell.getGObject());

        pressedGCell = gCell;
        if(pressedGObject == null){
            pressedGObject = gCell.getGObject();
        }else {
            ActionCommand command = pressedGObject.getReceiverAction().getActionCommand(0);
            command.setParameters(CommandMoveAbstract.NAME_PARAMETER_X,pressedGCell.getX()+"");
            command.setParameters(CommandMoveAbstract.NAME_PARAMETER_Y,pressedGCell.getY()+"");
            command.execute();
            reset();
        }
    }

    private void reset(){
        pressedGObject = null;
        pressedGCell = null;
    }

    private void backlightCell(GObject object){
        resetBacklight();
        if(object!=null){
            CommandChessMove command = (CommandChessMove) object.getReceiverAction().getActionCommand(0);
            ArrayList<Point> listPosition = command.getListPosition();
            ListGCell<GCell> listGCell = gBoard.getListGCell();
            for (Point point : listPosition) {
                GPanelCell panel = listGCell.get((int) point.getX(), (int) point.getY()).getGPanel();
                panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION,"1");
                panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION_COLOR,"255,0,0");
                panel.repaint();
                backlightCells.add(panel);
            }
        }
    }

    private void resetBacklight(){
        for (GPanel panel : backlightCells) {
            panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION,"0");
            panel.getDynamicValues().putParameter(GPanelCell.PARAMETER_NAME_SELECTION_COLOR,"0,0,0");
            panel.repaint();
        }
    }
}
