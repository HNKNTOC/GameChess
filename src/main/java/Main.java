import com.GameChes.logic.gCellChes.GCellChessFactory;
import com.GameChes.logic.gChes.GChes;
import com.GameChes.logic.gChes.actionMove.*;
import com.GameChes.logic.gChes.factory.GChessFactory;
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
        ListGCell<GCell> listGCell = new GCellChessFactory().createListGCell(MaxX, MaxY);
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
        display.start();
    }

    private static void loadImage() {
        ResManager resManager = ResManager.getResManager();
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CEll_BLACK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CELL_WHITE));
        resManager.putImageIcon(ImageLoader.getImage(ImageName.NULL));

        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_PAWN));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_ROOK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_HORSE));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_ELEPHANT));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_KING));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_QUEEN));

        ImageNameChes.setImageBlack();

        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_PAWN));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_ROOK));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_HORSE));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_ELEPHANT));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_KING));
        resManager.putImageIcon(ImageLoader.getImage(ImageNameChes.CHESS_QUEEN));

    }

    public static void addGChessBlack(){
        GChessFactory factory = new GChessFactory(false);

        int x = 0;
        for (int i = 0; i < 8; i++) {
            GChes chess = factory.createPawn();
            addGChes(chess,x,1);
            x++;
        }

        x = 0;
        for (int i = 0; i < 2; i++) {
            GChes rook = factory.createRook();
            addGChes(rook,x,0);
            x = 7;
        }


        x = 1;
        for (int i = 0; i < 2; i++) {
            GChes horse = factory.createHorse();
            addGChes(horse,x,0);
            x = 6;
        }


        x = 2;
        for (int i = 0; i < 2; i++) {
            GChes elephant = factory.createElephant();
            addGChes(elephant,x,0);
            x = 5;
        }

        GChes queen = factory.createQueen();
        addGChes(queen,3,0);

        GChes king = factory.createKing();
        addGChes(king,4,0);
    }

    private static void addGChesAll() {
        addGChessBlack();
        GChessFactory factory = new GChessFactory(true);

        int x = 0;
        for (int i = 0; i < 8; i++) {
            GChes chess = factory.createPawn();
            addGChes(chess,x,6);
            x++;
        }

        x = 0;
        for (int i = 0; i < 2; i++) {
            GChes rook = factory.createRook();
            addGChes(rook,x,7);
            x = 7;
        }


        x = 1;
        for (int i = 0; i < 2; i++) {
            GChes horse = factory.createHorse();
            addGChes(horse,x,7);
            x = 6;
        }


        x = 2;
        for (int i = 0; i < 2; i++) {
            GChes elephant = factory.createElephant();
            addGChes(elephant,x,7);
            x = 5;
        }

        GChes queen = factory.createQueen();
        addGChes(queen,3,7);

        GChes king = factory.createKing();
        addGChes(king,4,7);
    }

    private static void addGChes(GChes gChes,int x,int y){
        gChes.getReceiverAction().setActionCommand(new CommandChesMove(gChes,gBoard),0);
        gChes.setX(x);
        gChes.setY(y);
        listGCell.get(x,y).setGObject(gChes);
    }

}
