package clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public boolean getColor(int xCoordinatte, int yCoordinate, PieceColor color) {
        return pieces[xCoordinatte][yCoordinate].getPieceColor() != color;
    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (IsLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
        //throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        // Ar fi trebuit mai mare strict, altfel este o tabla 7*7, nu 8*8
        return !(xCoordinate >= MAX_BOARD_WIDTH || xCoordinate < 0 ||
                 yCoordinate >= MAX_BOARD_HEIGHT || yCoordinate < 0);
        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}
