/** 
  * @author	 	 Noah Jackson
  * @id          noah.jackson@betheluniversity.edu
  * @course      CSC 321: Programming 3
  * @assignment  Reversi Project
  * @related     Piece
  */
public class ReversiPiece extends Piece {
	
//Class Constants
	public static final int WHITE = 1;
	public static final int BLACK = 2;
	
//Constructor
	public ReversiPiece(int inType) {
		super(inType);
	}
	
//Accessors
	public int getOpp(int inType) {
		if (inType <= MIN || inType > MAX) return -1;
		if (inType == WHITE) return BLACK;
		else return WHITE;
	}
	
//Modifiers
	protected void setType(int newType) {
		type = newType;
	}
	
//Helpers
	public char toChar() {
        if (type == WHITE) return 'W'; //White
        if (type == BLACK) return 'B'; //Black
        else return '-'; 		   //Blank
    }
}
