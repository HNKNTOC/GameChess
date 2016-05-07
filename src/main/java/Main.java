import com.GameChes.logic.gCellChes.GCellChessFactory;
import com.GameChes.logic.gChes.GChes;
import com.GameChes.logic.gChes.actionMove.*;
import com.GameChes.logic.gChes.factory.GChessFactory;
import com.GameChes.logic.mouseListener.MouseListenerGChes;
import com.GameChes.logic.res.ImageNameChess;
import com.GameEngine.gui.Display;
import com.GameEngine.gui.JDisplay;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoard;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactory;
import com.GameEngine.logic.gameComponents.boardComponents.gBoard.GBoardFactoryDefault;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.GCell;
import com.GameEngine.logic.gameComponents.boardComponents.gCell.list.ListGCell;
import com.GameEngine.logic.gameComponents.gPanel.GPanelDefaultFactory;
import com.GameEngine.logic.resources.ImageName;
import com.GameEngine.logic.resources.loader.image.ImageLoader;
import com.GameEngine.logic.resources.manager.ResManager;

/**
 * Created by Nikita on 20.02.2016.
 */
public class Main {

    private static final int MaxY = 8;
    private static final int MaxX = 8;
    private static ResManager resManager = ResManager.getResManager();
    private static GBoard gBoard;

    public static void main(String[] args) {

        ResManager resManager = ResManager.getResManager();
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_BLACK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_WHITE));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_PAWN));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_ROOK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_HORSE));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_ELEPHANT));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_KING));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChess.CHESS_QUEEN));
        resManager.putImageIcon(ImageLoader.getImage(ImageName.NULL));


        GBoardFactory factoryGBoard = new GBoardFactoryDefault(new GPanelDefaultFactory());
        ListGCell<GCell> listGCell = new GCellChessFactory().createListGCell(MaxX, MaxY);
        gBoard = factoryGBoard.createGBoard(listGCell);

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
            GChes chess = factory.createPawn(resManager.getImageIcon(ImageNameChess.CHESS_PAWN));
            chess.getReceiverAction().setActionCommand(new CommandChesMove(chess,gBoard),0);
            chess.setX(x);
            chess.setY(6);
            listGCell.get(x,6).setGObject(chess);
            x++;
        }

        x = 0;
        for (int i = 0; i < 2; i++) {
            GChes rook = factory.createRook(resManager.getImageIcon(ImageNameChess.CHESS_ROOK));
            rook.getReceiverAction().setActionCommand(new CommandChesMove(rook,gBoard),0);
            rook.setX(x);
            rook.setY(7);
            listGCell.get(x,7).setGObject(rook);
            x = 7;
        }


        x = 1;
        for (int i = 0; i < 2; i++) {
            GChes horse = factory.createHorse(resManager.getImageIcon(ImageNameChess.CHESS_HORSE));
            horse.getReceiverAction().setActionCommand(new CommandChesMove(horse,gBoard),0);
            horse.setX(x);
            horse.setY(7);
            listGCell.get(x,7).setGObject(horse);
            x = 6;
        }


        x = 2;
        for (int i = 0; i < 2; i++) {
            GChes elephant = factory.createElephant(resManager.getImageIcon(ImageNameChess.CHESS_ELEPHANT));
            elephant.getReceiverAction().setActionCommand(new CommandChesMove(elephant,gBoard),0);
            elephant.setX(x);
            elephant.setY(7);
            listGCell.get(x,7).setGObject(elephant);
            x = 5;
        }

        GChes queen = factory.createQueen(resManager.getImageIcon(ImageNameChess.CHESS_QUEEN));
        queen.getReceiverAction().setActionCommand(new CommandChesMove(queen,gBoard),0);
        queen.setX(3);
        queen.setY(7);
        listGCell.get(3,7).setGObject(queen);

        GChes king = factory.createKing(resManager.getImageIcon(ImageNameChess.CHESS_KING));
        king.getReceiverAction().setActionCommand(new CommandChesMove(king,gBoard),0);
        king.setX(4);
        king.setY(7);
        listGCell.get(4,7).setGObject(king);
    }
}
