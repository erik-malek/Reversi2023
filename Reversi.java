public class Reversi extends Board {
    private CheckerPiece[][] pieces;

    public Reversi() {
        size = DEFAULTSIZE;
        pieces = new CheckerPiece[size][size];
        initializeGame();
    }

    public CheckerPiece getPiece(int row, int column) {
        return pieces[row][column];
    }

    private void initializeGame() {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                pieces[row][column] = new CheckerPiece(Piece.BLANK);
            }
        }
        pieces[3][3].setType(2);
        pieces[3][4].setType(1);
        pieces[4][3].setType(1);
        pieces[4][4].setType(2);
    }

    public void makeMove(int row, int col, CheckerPiece move) {
        if (isValidMove(move, row, col)) {
            pieces[row][col] = move;
            flipEffectedPieces(row, col, move);
        }
    }

    private boolean isValidMove(CheckerPiece piece, int row, int col) {
        if (pieces[row][col].getType() == Piece.BLANK) {
            // check for playable spots for provided team
            // search board and analyze each piece
            // check all 8 directions for nearest "same color" piece
            // keep track of pieces to be flipped
        }
        return false;
    }

    private void flipEffectedPieces(int row, int col, CheckerPiece move) {
        // flip over the affected pieces
    }
}