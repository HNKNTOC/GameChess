package com.GameChes.logic.gPanelChes;

import com.GameChes.logic.res.ImageNameChess;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.gPanel.GPanel;
import com.GameEngine.logic.gameComponents.gPanel.GPanelFactory;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCell;
import com.GameEngine.logic.gameComponents.gPanel.cell.GPanelCellInf;
import com.GameEngine.logic.resources.ImageName;
import com.GameEngine.logic.resources.manager.ResManager;

import javax.swing.*;

/**
 * Created by Nikita on 13.04.2016.
 */
public class GPanelChessFactory implements GPanelFactory<GPanelCell> {

    private ImageIcon image = ResManager.getResManager().getImageIcon(ImageName.NULL);

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    @Override
    public GPanelCell createGPanel() {
        GPanelCell panel = new GPanelCell();
        settingPanel(panel);
        return panel;
    }

    public GPanelCell createGPanelInf(GCell cell){
        GPanelCell panel = new GPanelCellInf(cell);
        settingPanel(panel);
        return panel;
    }

    private void settingPanel(GPanel panel){
        panel.setImageIcon(image);
    }

    /**
     * Устанавливает картинку для ChessCells белую или чёрную.
     * @param b False - черная клетка,True - белая клетка.
     */
    public void identifyColor(boolean b){
        if(b){
            image = ResManager.getResManager().getImageIcon(ImageNameChess.CHESS_WHITE);
        }else {
            image = ResManager.getResManager().getImageIcon(ImageNameChess.CHESS_BLACK);
        }
    }

}
