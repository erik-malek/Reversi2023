/** This class will store a generic square board of pieces.
  *     Details about how the board is used in a given game must
  *     be implemented in a subclass.
  *
  * @author      Cathy Bareiss
  * @Modifier	 Noah Jackson
  * @id          cathy.bareiss@betheluniversity.edu
  * @course      CSC 321: Programming 3
  * @assignment  Reversi Project
  * @related     Piece
  */
public abstract class Board implements BoardInterface{
// Fields
    protected Piece[][] pieces;
    protected int size;

//Class Constants
    public static final int DEFAULTSIZE = 8;
    public static final int ENDGAME = -1;
    public static final int LEGALMOVE = 0;
    public static final int BADMOVE = 1;
    
//Constructors
    public Board() {
        size = DEFAULTSIZE;
        pieces = new Piece[size][size];
        blankBoard();
    }

    //creates a square board of the size requested
    public Board(int inSize) {
        size = inSize;
        pieces = new Piece[size][size];
        blankBoard();
    }

    
    // set all pieces to blank
    protected abstract void blankBoard(); 

//Mutators
    public void setPiece(Piece inPiece, int row, int column) {
        pieces[row][column] = inPiece;
    }

//Accessors
    public Piece getPiece(int row, int column) {
        return pieces[row][column];
    }

    public int getSize() {
        return size;
    }

//Helpers

    // is a given location on the board?
    public boolean onBoard(int row, int column) {
        if (row < 0) return false;
        if (column  < 0) return false;
        if (row >= size) return false;
        if (column >= size) return false;
        return true;
    }

    public boolean equals(BoardInterface otherBoard) {
        int row, column;
        boolean same;

        same = true;
        if (size != otherBoard.getSize()) return false;
        for (row = 0; row < size; row++)
            for (column=0; column < size; column++)
                if (!pieces[row][column].equals(
                            otherBoard.getPiece(row,column)))
                    same = false;
        return same;
    }

    public String toString() {
        String tempString;
        int row, column;

        tempString = null;
        for (row = 0; row < size; row++) {
            for (column = 0; column < size; column++) {
                tempString = tempString+pieces[row][column].toChar()+" ";
            }
            tempString = tempString+"\n";
        }
        return tempString;
    }
}