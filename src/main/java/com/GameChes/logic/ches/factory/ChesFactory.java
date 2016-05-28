package com.GameChes.logic.ches.factory;

import com.GameChes.logic.ches.*;
import com.GameChes.logic.res.ImageNameChes;
import com.GameEngine.logic.action.command.gObject.ReceiverGObject;
import com.GameEngine.logic.resources.manager.ResManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * Фабрика для Ches.
 */
public class ChesFactory {
    private static final Logger LOGGER = LogManager.getLogger(ChesFactory.class);
    private static final ResManager resManager = ResManager.getResManager();
    private String colorPawn;
    /**
     * Пути до картинок.
     */
    private String imagePathPawn, imagePathQueen, imagePathRook,
            imagePathHorse, imagePathElephant, imagePathKing;

    /**
     * Создают фабрику с указанным цветом.
     * @param color false - черный, true - белый.
     */
    public ChesFactory(boolean color) {
        if (color) {
            setImagePawnWhite();
            colorPawn = "1";
        } else {
            setImagePawnBlack();
            colorPawn = "0";
        }
        LOGGER.info("Create "+toString());
    }

    private void setImagePawnWhite() {
        imagePathKing = ImageNameChes.CHESS_WHITE_KING;
        imagePathQueen = ImageNameChes.CHESS_WHITE_QUEEN;
        imagePathRook = ImageNameChes.CHESS_WHITE_ROOK;
        imagePathHorse = ImageNameChes.CHESS_WHITE_HORSE;
        imagePathElephant = ImageNameChes.CHESS_WHITE_ELEPHANT;
        imagePathPawn = ImageNameChes.CHESS_WHITE_PAWN;
    }

    private void setImagePawnBlack() {
        imagePathKing = ImageNameChes.CHESS_BLACK_KING;
        imagePathQueen = ImageNameChes.CHESS_BLACK_QUEEN;
        imagePathRook = ImageNameChes.CHESS_BLACK_ROOK;
        imagePathHorse = ImageNameChes.CHESS_BLACK_HORSE;
        imagePathElephant = ImageNameChes.CHESS_BLACK_ELEPHANT;
        imagePathPawn = ImageNameChes.CHESS_BLACK_PAWN;
    }


    private void settingChes(Ches ches, String imageName) {
        ReceiverGObject receiverAction = new ReceiverGObject();
        ches.getDynamicValues().putParameter(Ches.COLOR_PAWN, colorPawn);
        ches.setReceiverAction(receiverAction);
        ImageIcon imageIcon = resManager.getImageIcon(imageName);
        if (imageIcon == null) {
            LOGGER.warn("imageIcon == null");
            return;
        }
        ches.getGPanel().setImageIcon(imageIcon);
    }

    public ChesPawn createPawn() {
        LOGGER.debug("createPawn");
        ChesPawn gChesPawn = new ChesPawn();
        settingChes(gChesPawn, imagePathPawn);
        return gChesPawn;
    }

    public ChesRook createRook() {
        LOGGER.debug("createRook");
        ChesRook gChesRook = new ChesRook();
        settingChes(gChesRook, imagePathRook);
        return gChesRook;
    }

    public ChesHorse createHorse() {
        LOGGER.debug("createHorse");
        ChesHorse gChesHorse = new ChesHorse();
        settingChes(gChesHorse, imagePathHorse);
        return gChesHorse;
    }

    public ChesElephant createElephant() {
        LOGGER.debug("createElephant");
        ChesElephant gChesElephant = new ChesElephant();
        settingChes(gChesElephant, imagePathElephant);
        return gChesElephant;
    }

    public ChesQueen createQueen() {
        LOGGER.debug("createQueen");
        ChesQueen gChesQueen = new ChesQueen();
        settingChes(gChesQueen, imagePathQueen);
        return gChesQueen;
    }

    public ChesKing createKing() {
        LOGGER.debug("createKing");
        ChesKing gChesKing = new ChesKing();
        settingChes(gChesKing, imagePathKing);
        return gChesKing;
    }

    @Override
    public String toString() {
        return "ChesFactory{" +
                "colorPawn='" + colorPawn + '\'' +
                '}';
    }
}
