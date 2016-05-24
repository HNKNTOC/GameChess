package com.GameChes.logic.gChes.factory;

import com.GameChes.logic.gChes.*;
import com.GameChes.logic.res.ImageNameChes;
import com.GameEngine.logic.action.command.gObject.ReceiverGObject;
import com.GameEngine.logic.resources.manager.ResManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * Created by Nikita on 17.04.2016.
 */
public class GChessFactory {
    private static final Logger LOGGER = LogManager.getLogger(GChessFactory.class);
    private static final ResManager resManager = ResManager.getResManager();
    private String colorPawn;

    public GChessFactory(boolean colorPawn) {
        if (colorPawn) {
            ImageNameChes.setImageWinter();
        }else {
            ImageNameChes.setImageBlack();
        }
    }

    private void settingChes(GChes gChes, String imageName) {
        ReceiverGObject receiverAction = new ReceiverGObject();
        gChes.getDynamicValues().putParameter(GChes.COLOR_PAWN,colorPawn);
        gChes.setReceiverAction(receiverAction);
        ImageIcon imageIcon = resManager.getImageIcon(imageName);
        if (imageIcon == null) {
            LOGGER.warn("imageIcon == null");
            return;
        }
        gChes.getGPanel().setImageIcon(imageIcon);
    }

    public GChesPawn createPawn() {
        LOGGER.debug("createPawn");
        GChesPawn gChesPawn = new GChesPawn();
        settingChes(gChesPawn, ImageNameChes.CHESS_PAWN);
        return gChesPawn;
    }

    public GChesRook createRook() {
        LOGGER.debug("createRook");
        GChesRook gChesRook = new GChesRook();
        settingChes(gChesRook,ImageNameChes.CHESS_ROOK);
        return gChesRook;
    }

    public GChesHorse createHorse() {
        LOGGER.debug("createHorse");
        GChesHorse gChesHorse = new GChesHorse();
        settingChes(gChesHorse,ImageNameChes.CHESS_HORSE);
        return gChesHorse;
    }

    public GChesElephant createElephant() {
        LOGGER.debug("createElephant");
        GChesElephant gChesElephant = new GChesElephant();
        settingChes(gChesElephant,ImageNameChes.CHESS_ELEPHANT);
        return gChesElephant;
    }

    public GChesQueen createQueen() {
        LOGGER.debug("createQueen");
        GChesQueen gChesQueen = new GChesQueen();
        settingChes(gChesQueen,ImageNameChes.CHESS_QUEEN);
        return gChesQueen;
    }

    public GChesKing createKing() {
        LOGGER.debug("createKing");
        GChesKing gChesKing = new GChesKing();
        settingChes(gChesKing,ImageNameChes.CHESS_KING);
        return gChesKing;
    }
}
