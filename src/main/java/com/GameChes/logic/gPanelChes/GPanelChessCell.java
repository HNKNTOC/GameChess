package com.GameChes.logic.gPanelChes;

import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCell;

import java.awt.*;

/**
 * Created by Nikita on 16.04.2016.
 */
public class GPanelChessCell extends GPanelCell {

    public GPanelChessCell() {
        getDynamicValues().putParameter("Color","0");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (parsingColor()) {
            g.setColor(Color.red);
            g.drawOval((getWidth()/2)-5,(getHeight()/2)-5,10,10);
        }
    }
    private boolean parsingColor() {
        String color = getDynamicValues().getParameter("Color");
        if (color == null) {
            return false;
        }
        int i = Integer.parseInt(color);
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }
}
