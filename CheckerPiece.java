public class CheckerPiece extends Piece {
    public static final int BLACK = 2;
    public static final int WHITE = 1;

    
    public CheckerPiece(int inType) {
        super(inType);
        
    }
    
    public void setType(int newType) {
		type = newType;
	}

    public int getOpposite(int inType){
        if (inType < MAX-1 || inType > MAX)
            if (inType == 1) return 2;
            else return 1;
        return -1;
   }

    public char toChar() {
        if (type == BLACK) return 'B'; 
        if (type == WHITE) return 'W';    
        else return '-';
    }
}