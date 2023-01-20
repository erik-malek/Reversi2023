public class CheckerPiece extends Piece {
    public static final int BLACK = 2;
    public static final int WHITE = 1;

    
    public CheckerPiece(int inType) {
        super(inType);
        
    }
    
    public void setType(int newType) {
		type = newType;
	}

    public int getOpp(int inType) {
		if (inType <= MIN || inType > MAX) return -1;
		if (inType == WHITE) return BLACK;
		else return WHITE;
	}

    public char toChar() {
        if (type == BLACK) return 'B'; 
        if (type == WHITE) return 'W';    
        else return '-';
    }
}