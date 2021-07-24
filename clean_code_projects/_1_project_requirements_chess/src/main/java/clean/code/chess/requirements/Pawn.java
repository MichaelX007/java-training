package clean.code.chess.requirements;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        if (movementType == MovementType.MOVE && newX != xCoordinate)
            return;
        if (this.pieceColor == PieceColor.BLACK) {
            if (movementType == MovementType.MOVE && newY == yCoordinate - 1 &&
                newY >= 0 && newX == xCoordinate) {
                this.setXCoordinate(newX);
                this.setYCoordinate(newY);
            }
            if (movementType == MovementType.CAPTURE && newY == yCoordinate - 1 && Math.abs(newX - xCoordinate) == 1 &&
                    newY >= 0 && newX >= 0 && chessBoard.getColor(newX, newY, PieceColor.BLACK)) {
                this.setXCoordinate(newX);
                this.setYCoordinate(newY);
            }
        } else {
            if (movementType == MovementType.MOVE && newY == yCoordinate + 1 && chessBoard.IsLegalBoardPosition(newX, newY) &&
                    newY <= 7 && newX == xCoordinate) {
                this.setXCoordinate(newX);
                this.setYCoordinate(newY);
            }
            if (movementType == MovementType.CAPTURE && newY == yCoordinate + 1 && Math.abs(newX - xCoordinate) == 1 &&
                    newY <= 7 && newX >= 0 && chessBoard.getColor(newX, newY, PieceColor.WHITE)) {
                this.setXCoordinate(newX);
                this.setYCoordinate(newY);
            }
        }
        // throw new UnsupportedOperationException("Need to implement Pawn.Move()") ;
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
