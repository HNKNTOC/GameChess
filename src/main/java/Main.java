import com.GameChes.logic.cell.CellChessFactory;
import com.GameChes.logic.ches.Ches;
import com.GameChes.logic.ches.actionMove.*;
import com.GameChes.logic.ches.factory.ChesFactory;
import com.GameChes.logic.mouseListener.MouseListenerGChes;
import com.GameChes.logic.res.ImageNameChes;
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
    private static GBoard gBoard;
    private static ListGCell<GCell> listGCell;

    public static void main(String[] args) {

        loadImage();


        GBoardFactory factoryGBoard = new GBoardFactoryDefault(new GPanelDefaultFactory());
        ListGCell<GCell> listGCell = new CellChessFactory().createListGCell(MaxX, MaxY);
        gBoard = factoryGBoard.createGBoard(listGCell);

        Main.listGCell = gBoard.getListGCell();
        addGChesAll();

        gBoard.getGPanel().setImageIcon(null);
        gBoard.updateGCell();

        Display display = new JDisplay();

        MouseListenerGChes l = new MouseListenerGChes(gBoard);
        for (GCell gCell : gBoard.getListGCell()) {
            gCell.getGPanel().addMouseListener(l);
        }


        display.showPanel(gBoard.getGPanel());
        display.getJFrame().setSize(420,390);
        display.start();
    }

    private static void loadImage() {
        ResManager resManager = ResManager.getResManager();
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CEll_BLACK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CELL_WHITE));
        resManager.putImageIcon(ImageLoader.getImage(ImageName.NULL));

        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_WHITE_PAWN));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_WHITE_ROOK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_WHITE_HORSE));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_WHITE_ELEPHANT));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_WHITE_KING));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_WHITE_QUEEN));

        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_PAWN));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_ROOK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_HORSE));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_ELEPHANT));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_KING));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_QUEEN));

    }

    public static void addGChessBlack() {
        ChesFactory factory = new ChesFactory(false);

        int x = 0;
        for (int i = 0; i < 8; i++) {
            Ches chess = factory.createPawn();
            addGChes(chess, x, 1);
            x++;
        }

        x = 0;
        for (int i = 0; i < 2; i++) {
            Ches rook = factory.createRook();
            addGChes(rook, x, 0);
            x = 7;
        }


        x = 1;
        for (int i = 0; i < 2; i++) {
            Ches horse = factory.createHorse();
            addGChes(horse, x, 0);
            x = 6;
        }


        x = 2;
        for (int i = 0; i < 2; i++) {
            Ches elephant = factory.createElephant();
            addGChes(elephant, x, 0);
            x = 5;
        }

        Ches queen = factory.createQueen();
        addGChes(queen, 3, 0);

        Ches king = factory.createKing();
        addGChes(king, 4, 0);
    }

    private static void addGChesAll() {
        addGChessBlack();
        ChesFactory factory = new ChesFactory(true);

        int x = 0;
        /*for (int i = 0; i < 8; i++) {
            Ches chess = factory.createPawn();
            addGChes(chess, x, 6);
            x++;
        }*/

        x = 0;
        for (int i = 0; i < 2; i++) {
            Ches rook = factory.createRook();
            addGChes(rook, x, 7);
            x = 7;
        }


        x = 1;
        for (int i = 0; i < 2; i++) {
            Ches horse = factory.createHorse();
            horse.getReceiverAction().setActionCommand(new CommandMoveHorse(horse, gBoard), 0);
            addGChes(horse, x, 7);
            x = 6;
        }


        x = 2;
        for (int i = 0; i < 2; i++) {
            Ches elephant = factory.createElephant();
            elephant.getReceiverAction().setActionCommand(new CommandMoveElephant(elephant, gBoard), 0);
            addGChes(elephant, x, 7);
            x = 5;
        }

        Ches queen = factory.createQueen();
        addGChes(queen, 3, 7);

        Ches king = factory.createKing();
        king.getReceiverAction().setActionCommand(new CommandMoveElephant(king, gBoard), 0);
        addGChes(king, 4, 7);
    }

    private static void addGChes(Ches ches, int x, int y) {
        ches.setX(x);
        ches.setY(y);
        listGCell.get(x, y).setGObject(ches);
    }

}
