package com.GameChes.logic.gCellChes;

import com.GameChes.logic.gPanelChes.GPanelChessFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCellFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.HashMapPanelGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;

import java.util.ArrayList;
import java.util.Iterator;

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
        gCell.setGPanel(factory.createGPanelInf(gCell));
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

    public ListGCell<GCell> createListGCell(int maxX, int maxY){
        ListGCell<GCell> listGCell = new HashMapPanelGCell(maxX, maxY);
        GCellChessFactory factoryBlack = new GCellChessFactory();
        factoryBlack.getFactory().identifyColor(false);
        GCellChessFactory factoryWinter = new GCellChessFactory();
        factoryWinter.getFactory().identifyColor(true);

        Iterator<GCell> iteratorBlack = factoryBlack.createGCell(maxX * maxY / 2).iterator();
        Iterator<GCell> iteratorWhite = factoryWinter.createGCell(maxX * maxY / 2).iterator();


        for (int i = 0; i < maxY / 2; i++) {
            for (int j = 0; j < maxX / 2; j++) {
                listGCell.add(iteratorWhite.next());
                listGCell.add(iteratorBlack.next());
            }
            for (int j = 0; j < maxX / 2; j++) {
                listGCell.add(iteratorBlack.next());
                listGCell.add(iteratorWhite.next());
            }
        }
        return listGCell;
    }

}
