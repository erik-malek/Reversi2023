
/** This class will store a piece which is just an integer.
  * @author     Cathy Bareiss
  * @Modifier	Noah Jackson
  * @id         cathy.bareiss@betheluniversity.edu
  * @course     CSIS 321:  Programming 3
  * @assignment Reversi Project
  * @related    none
 */
public abstract class Piece {
// fields
    protected int type;

//Class constants
    public static final int BLANK = 0;
    protected static final int MIN = 0;
    protected static final int MAX = 2;

//Constructor
    public Piece (int inType) {
        if (inType < MIN || inType > MAX) { // exception for invalid type needed
            System.err.println("invalid piece valid");
            type = -1;
        }
        type = inType;
    }
    
//Accessors
    public int getType() {
        return type;
    }
    
//Modifier
    protected abstract void setType(int newType); //Leaves setType to the subclass to implement
		
//Helper methods
    public boolean equals(Piece otherPiece) {
        if (type == otherPiece.getType()) return true;
        return false;
    }
    
    public char toChar() {
        return ' ';
    }

    public String toString() {
        if (type == BLANK) return "blank";
        if (type == -1) return "invalid piece";
        return null;
    }
}
