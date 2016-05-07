package com.GameChes.logic.gChes.factory;

import com.GameChes.logic.gChes.*;
import com.GameEngine.logic.action.command.gObject.ReceiverGObject;

import javax.swing.*;

/**
 * Created by Nikita on 17.04.2016.
 */
public class GChessFactory {

    private void settingChes(GChes gChes, ImageIcon icon){
        gChes.setReceiverAction(new ReceiverGObject());
        gChes.getGPanel().setImageIcon(icon);
    }

    public GChesPawn createPawn(ImageIcon imageIcon){
        GChesPawn gChesPawn = new GChesPawn();
        settingChes(gChesPawn,imageIcon);
        return gChesPawn;
    }

    public GChesRook createRook(ImageIcon imageIcon) {
        GChesRook gChesRook = new GChesRook();
        settingChes(gChesRook,imageIcon);
        return gChesRook;
    }

    public GChesHorse createHorse(ImageIcon imageIcon) {
        GChesHorse gChesHorse = new GChesHorse();
        settingChes(gChesHorse,imageIcon);
        return gChesHorse;
    }

    public GChesElephant createElephant(ImageIcon imageIcon) {
        GChesElephant gChesElephant = new GChesElephant();
        settingChes(gChesElephant,imageIcon);
        return gChesElephant;
    }

    public GChesQueen createQueen(ImageIcon imageIcon) {
        GChesQueen gChesQueen = new GChesQueen();
        settingChes(gChesQueen,imageIcon);
        return gChesQueen;
    }

    public GChesKing createKing(ImageIcon imageIcon) {
        GChesKing gChesKing = new GChesKing();
        settingChes(gChesKing,imageIcon);
        return gChesKing;
    }
}
