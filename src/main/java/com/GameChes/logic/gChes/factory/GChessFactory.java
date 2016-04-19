package com.GameChes.logic.gChes.factory;

import com.GameChes.logic.gChes.GChesParameters;
import com.GameEngine.logic.action.command.gObject.ReceiverGObject;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Nikita on 17.04.2016.
 */
public class GChessFactory {

    public GObject createChess(ImageIcon icon){
        GObject chess = new GObject();
        chess.getDynamicValues().putParameter(GChesParameters.ParametersName.TYPE,
                GChesParameters.ParametersValue.TYPE_GCHESS);
        chess.setReceiverAction(new ReceiverGObject());
        chess.getGPanel().setImageIcon(icon);
        return chess;
    }

    ArrayList<GObject> createChess(int number,ImageIcon icon){
        ArrayList<GObject> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(createChess(icon));
        }
        return list;
    }
}
