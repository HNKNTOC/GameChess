import com.GameChes.logic.cell.CellChessFactory;
import com.GameChes.logic.ches.Ches;
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
        addGChess(new ChesFactory(false, gBoard),1,0);
        addGChess(new ChesFactory(true, gBoard),6,7);

        gBoard.getGPanel().setImageIcon(null);
        gBoard.updateGCell();

        Display display = new JDisplay();

        MouseListenerGChes l = new MouseListenerGChes(gBoard);
        for (GCell gCell : gBoard.getListGCell()) {
            gCell.getGPanel().addMouseListener(l);
        }


        display.showPanel(gBoard.getGPanel());
        display.getJFrame().setSize(500,450);
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
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_QUEEN));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_ELEPHANT));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_BLACK_KING));

    }

    /**
     * Добавляет ches на доску одного из игроков.
     * @param factory фабрика создающая ches.
     * @param startPawn ось y на которой будут размешены Pawn.
     * @param startOthers ось y на которой будут размешены остальные Ches.
     */
    public static void addGChess(ChesFactory factory, final int startPawn , final int startOthers) {
        int x = 0;
        for (int i = 0; i < 8; i++) {
            Ches chess = factory.createPawn();
            addGChes(chess, x, startPawn);
            x++;
        }

        x = 0;
        for (int i = 0; i < 2; i++) {
            Ches rook = factory.createRook();
            addGChes(rook, x, startOthers);
            x = 7;
        }


        x = 1;
        for (int i = 0; i < 2; i++) {
            Ches horse = factory.createHorse();
            addGChes(horse, x, startOthers);
            x = 6;
        }


        x = 2;
        for (int i = 0; i < 2; i++) {
            Ches elephant = factory.createElephant();
            addGChes(elephant, x, startOthers);
            x = 5;
        }

        Ches queen = factory.createQueen();
        addGChes(queen, 3, startOthers);

        Ches king = factory.createKing();
        addGChes(king, 4, startOthers);
    }


    private static void addGChes(Ches ches, int x, int y) {
        System.out.println("=========="+x+";"+y);
        ches.setX(x);
        ches.setY(y);
        listGCell.get(x, y).setGObject(ches);
    }

}
