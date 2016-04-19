import com.GameChes.logic.gCellChes.GCellChessFactory;
import com.GameChes.logic.gChes.actionMove.CommandElephantMove;
import com.GameChes.logic.gChes.actionMove.CommandHorseMove;
import com.GameChes.logic.gChes.actionMove.CommandPawnMove;
import com.GameChes.logic.gChes.factory.GChessFactory;
import com.GameChes.logic.mouseListener.MouseListenerGChes;
import com.GameChes.logic.res.ImageNameChess;
import com.GameEngine.gui.Display;
import com.GameEngine.gui.JDisplay;
import com.GameEngine.logic.action.command.ActionCommand;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.boardComponents.gObject.GObject;
import com.GameEngine.logic.gameComponents.gPanel.GPanelDefaultFactory;
import com.GameEngine.logic.resources.ImageName;
import com.GameEngine.logic.resources.loader.image.ImageLoader;
import com.GameEngine.logic.resources.manager.ResManager;

import java.util.Iterator;

/**
 * Created by Nikita on 20.02.2016.
 */
public class Main {

    private static int y = 8;
    private static int x = 8;
    private static ResManager resManager = ResManager.getResManager();
    private static GBoard gBoard;

    public static void main(String[] args) {

        ResManager resManager = ResManager.getResManager();
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_BLACK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_WHITE));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_PAWN));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_ELEPHANT));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_HORSE));
        resManager.putImageIcon(ImageLoader.getImage(ImageName.NULL));


        GBoardFactory factoryGBoard = new GBoardFactoryDefault(new GPanelDefaultFactory());
        gBoard = factoryGBoard.createGBoard(x, y);

        placementGCell(gBoard.getListGCell());
        addPawn(gBoard.getListGCell());

        gBoard.getGPanel().setImageIcon(null);
        gBoard.updateGCell();

        Display display = new JDisplay();

        MouseListenerGChes l = new MouseListenerGChes(gBoard);
        for (GCell gCell : gBoard.getListGCell()) {
            gCell.getGPanel().addMouseListener(l);
        }


        display.showPanel(gBoard.getGPanel());
        display.start();
    }

    private static void addPawn(ListGCell<GCell> listGCell) {
        GChessFactory factory = new GChessFactory();

        int x = 0;
        for (int i = 0; i < 8; i++) {
            GObject chess = factory.createChess(
                    resManager.getImageIcon(ImageNameChess.CHESS_PAWN));
            chess.getReceiverAction().setActionCommand(new CommandPawnMove(chess,gBoard),0);
            chess.setX(x);
            chess.setY(6);
            listGCell.get(x,6).setGObject(chess);
            x++;
        }

        x = 0;
        for (int i = 0; i < 2; i++) {
            GObject elephant = factory.createChess(resManager.getImageIcon(ImageNameChess.CHESS_ELEPHANT));
            elephant.getReceiverAction().setActionCommand(new CommandElephantMove(elephant,gBoard),0);
            elephant.setX(x);
            elephant.setY(7);
            listGCell.get(x,7).setGObject(elephant);
            x = 7;
        }

        x = 1;
        for (int i = 0; i < 2; i++) {
            GObject Horse = factory.createChess(resManager.getImageIcon(ImageNameChess.CHESS_HORSE));
            Horse.getReceiverAction().setActionCommand(new CommandHorseMove(Horse,gBoard),0);
            Horse.setX(x);
            Horse.setY(7);
            listGCell.get(x,7).setGObject(Horse);
            x = 6;
        }

    }

    public static void placementGCell(ListGCell<GCell> listGCell) {
        GCellChessFactory factoryBlack = new GCellChessFactory();
        factoryBlack.getFactory().identifyColor(false);
        GCellChessFactory factoryWinter = new GCellChessFactory();
        factoryWinter.getFactory().identifyColor(true);

        Iterator<GCell> iteratorBlack = factoryBlack.createGCell(x * y / 2).iterator();
        Iterator<GCell> iteratorWhite = factoryWinter.createGCell(x * y / 2).iterator();


        for (int i = 0; i < y / 2; i++) {
            for (int j = 0; j < x / 2; j++) {
                listGCell.add(iteratorWhite.next());
                listGCell.add(iteratorBlack.next());
            }
            for (int j = 0; j < x / 2; j++) {
                listGCell.add(iteratorBlack.next());
                listGCell.add(iteratorWhite.next());
            }
        }
    }

}