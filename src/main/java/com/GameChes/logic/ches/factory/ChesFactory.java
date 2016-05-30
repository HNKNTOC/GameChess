package com.GameChes.logic.ches.factory;

import com.GameChes.logic.ches.*;
import com.GameChes.logic.ches.actionMove.*;
import com.GameChes.logic.res.ImageNameChes;
import com.GameEngine.logic.action.command.gObject.ReceiverGObject;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.resources.ImageName;
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
    private final GBoard gBoard;
    /**
     * Пути до картинок.
     */
    private String imagePathPawn, imagePathQueen, imagePathRook,
            imagePathHorse, imagePathElephant, imagePathKing;

    /**
     * Создают фабрику с указанным цветом.
     * @param color false - черный, true - белый.
     * @param gBoard
     */
    public ChesFactory(boolean color, GBoard gBoard) {
        this.gBoard = gBoard;
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


    private void settingImage(Ches ches, String imageName) {
        ImageIcon imageIcon = resManager.getImageIcon(imageName);
        if (imageIcon == null) {
            LOGGER.warn("imageIcon == null");
            ches.getGPanel().setImageIcon(resManager.getImageIcon(ImageName.NULL));
            return;
        }
        ches.getGPanel().setImageIcon(imageIcon);
        return;
    }

    private Ches createChesEmpty(String imageName){
        Ches ches = new Ches();
        ches.getDynamicValues().putParameter(Ches.COLOR_PAWN, colorPawn);
        ches.setReceiverAction(new ReceiverGObject());
        settingImage(ches,imageName);
        return ches;
    }

    public Ches createPawn() {
        LOGGER.debug("createPawn");
        Ches ches = createChesEmpty(imagePathPawn);
        ches.getReceiverAction().setActionCommand(new CommandMovePawn(ches,gBoard),0);
        return ches;
    }

    public Ches createRook() {
        LOGGER.debug("createRook");
        Ches ches = createChesEmpty(imagePathRook);
        ches.getReceiverAction().setActionCommand(new CommandMoveRook(ches,gBoard),0);
        return ches;
    }

    public Ches createHorse() {
        LOGGER.debug("createHorse");
        Ches ches = createChesEmpty(imagePathHorse);
        ches.getReceiverAction().setActionCommand(new CommandMoveHorse(ches,gBoard),0);
        return ches;
    }

    public Ches createElephant() {
        LOGGER.debug("createElephant");
        Ches ches = createChesEmpty(imagePathElephant);
        ches.getReceiverAction().setActionCommand(new CommandMoveElephant(ches,gBoard),0);
        return ches;
    }

    public Ches createQueen() {
        LOGGER.debug("createQueen");
        Ches ches = createChesEmpty(imagePathQueen);
        ches.getReceiverAction().setActionCommand(new CommandMoveQueen(ches,gBoard),0);
        return ches;
    }

    public Ches createKing() {
        LOGGER.debug("createKing");
        Ches ches = createChesEmpty(imagePathKing);
        ches.getReceiverAction().setActionCommand(new CommandMoveKing(ches,gBoard),0);
        return ches;
    }

    @Override
    public String toString() {
        return "ChesFactory{" +
                "colorPawn='" + colorPawn + '\'' +
                '}';
    }
}
