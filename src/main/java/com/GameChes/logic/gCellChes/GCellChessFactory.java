package com.GameChes.logic.gCellChes;

import com.GameChes.logic.gPanelChes.GPanelChessFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellFactory;

import java.util.ArrayList;

/**
 * Created by Nikita on 20.02.2016.
 */
public class GCellChessFactory implements GCellFactory {

    /**
     * Фабрика которая будет создавать GPanelCell для GCell.
     */
    private GPanelChessFactory factory;

    public GCellChessFactory() {
        factory = new GPanelChessFactory();
    }

    public GCellChessFactory(GPanelChessFactory factory) {
        this.factory = factory;
    }

    public GPanelChessFactory getFactory() {
        return factory;
    }

    public void setFactory(GPanelChessFactory factory) {
        this.factory = factory;
    }

    /**
     * Создаёт Клетку для шахмотного поля.
     * @return ChessCells.
     */
    @Override
    public GCell createGCell() {
        GCell gCell = new GCellDefault();
        gCell.setGPanel(factory.createGPanel());
        return gCell;
    }

    /**
     * Создаёт ArrayList c ChessCells для шахмотного поля.
     * @param number количество клеток.
     * @return ChessCells.
     */
    @Override
    public ArrayList<GCell> createGCell(int number) {
        ArrayList<GCell> gCells = new ArrayList<>(number);
        for (int j = 0; j < number; j++) {
            gCells.add(createGCell());
        }
        return gCells;
    }
}
