/** 
  * @author	 	 Noah Jackson
  * @id          noah.jackson@betheluniversity.edu
  * @course      CSC 321: Programming 3
  * @assignment  Reversi Project
  * @related     ReversiPiece, Board
  */
public class ReversiBoard extends Board {
//Class Constants
	private static final int ROWCHANGE = 0;
    private static final int COLCHANGE = 1;
    private static final int ROWBOUNDARY = 2;
    private static final int COLBOUNDARY = 2;
    private static final int NOBOUNDARY = -1;
  
//Fields
	private boolean[] dir;
	
//Constructor
	public ReversiBoard() {
		super();
        dir = new boolean[8];
        for(int i=0; i<8;i++) dir[i] = false;
		setGame();
	}
	
//Class Methods
	protected void blankBoard() {
        int row, column;

        for (row = 0; row < size; row++)
            for (column = 0; column < size; column++)
                pieces[row][column] = new ReversiPiece(Piece.BLANK);

    }
	
	public void setGame() {
        getPiece(3,3).setType(2);
		getPiece(3,4).setType(1);
		getPiece(4,3).setType(1);
		getPiece(4,4).setType(2);
    }	
	
	public boolean onBoard(int x, int y) {
        if (x> size-1 || x<0 || y> size-1 || y<0) return false;
        return true;
    }
	
	public void makeMove(int row, int col, ReversiPiece piece) {
		int color, rowStep, colStep;
		color = piece.getType();
		rowStep = row;
		colStep = col;
		
		int[] dirValues;
		dirValues = new int[4];
		
		if (isValid(row, col, piece)) {
			pieces[row][col] = piece;
			
			for(int i=0; i<8;i++) {
				dirValues = dirChange(i, dirValues);
	
				if(dir[i]) {
					rowStep+= dirValues[ROWCHANGE];
					colStep+= dirValues[COLCHANGE];
					while(getPiece(rowStep,colStep).getType() == piece.getOpp(color)) { 
						getPiece(rowStep,colStep).setType(color);
						rowStep+= dirValues[ROWCHANGE];
						colStep+= dirValues[COLCHANGE];
					}
					rowStep = row;
					colStep = col;
				}
			}
		}
	}
	
	public boolean isValid(int row, int col, ReversiPiece piece) {
		int color, rowStep, colStep;
		color = piece.getType();
		rowStep = row;
		colStep = col;
		
		int[] dirValues;
		dirValues = new int[4];
		
		if(!onBoard(row, col)) return false; 			 //checks in the piece is off the board
		if (pieces[row][col].getType() == Piece.BLANK) { //check for blank type
			for(int i=0; i<8;i++) {						 //For loop for each direction
				dirValues = dirChange(i, dirValues);	 //Sets the direction values for the new direction
	
				if(row != dirValues[ROWBOUNDARY] || col != dirValues[COLBOUNDARY]) { //sets the boundaries so the steppers
					rowStep+= dirValues[ROWCHANGE];									 //don't go <8 or >0
					colStep+= dirValues[COLCHANGE];
					while(getPiece(rowStep,colStep).getType() == piece.getOpp(color)) {  //Checks direction until there is an opp color
						rowStep+= dirValues[ROWCHANGE];
						colStep+= dirValues[COLCHANGE];
					}
					
					if(getPiece(row + dirValues[ROWCHANGE], col + dirValues[COLCHANGE]).getType() != color) 
						if(getPiece(rowStep,colStep).getType() == color) {dir[i] = true; return true;}
					rowStep = row; //resets steppers for next iteration
					colStep = col;
				}
			}
		}
		return false;
	}
	
	//Provides relevant values for queried direction
		//ROWCHANGE: The amount that the row changes for a given direction
		//COLCHANGE: The amount that the column changes for a given direction
		//ROWBOUNDARY: Shows the upper/lower row boundary of a given direction
		//COLBOUNDARY: Shows the upper/lower column boundary of a given direction
	public int[] dirChange(int dir, int[] dirValues) { 
		for(int i=0; i<2;i++) dirValues[i] = 0;  		 	//Initializes direction changers
		for(int i=2; i<4;i++) dirValues[i] = NOBOUNDARY; 	//Initializes direction boundaries
		
		switch (dir) {
			case (0): 
				dirValues[ROWCHANGE]=-1;
				dirValues[ROWBOUNDARY]=0;
				break;
			
			case (1): 
				dirValues[ROWCHANGE]=-1; 
				dirValues[COLCHANGE]=1;
				dirValues[ROWBOUNDARY]=0;
				dirValues[COLBOUNDARY]=size;
				break;
			
			case (2): 
				dirValues[COLCHANGE]=1;
				dirValues[COLBOUNDARY]=size;
				break;
			
			case (3): 
				dirValues[ROWCHANGE]=1; 
				dirValues[COLCHANGE]=1;
				dirValues[ROWBOUNDARY]=size;
				dirValues[COLBOUNDARY]=size;
				break;
			
			case (4): 
				dirValues[ROWCHANGE]=1;
				dirValues[ROWBOUNDARY]=size;
				break;
			
			case (5): 
				dirValues[ROWCHANGE]=1; 
				dirValues[COLCHANGE]=-1;
				dirValues[ROWBOUNDARY]=size;
				dirValues[COLBOUNDARY]=0;
				break;
			
			case (6): 
				dirValues[COLCHANGE]=-1;
				dirValues[COLBOUNDARY]=0;
				break;
				
			case (7): 
				dirValues[ROWCHANGE]=-1; 
				dirValues[COLCHANGE]=-1;
				dirValues[ROWBOUNDARY]=0;
				dirValues[COLBOUNDARY]=0;
				break;
		}
		return dirValues;
	}
	
	//Returns the score of a given player
	public int getScore(int team) {
		int counter;
		counter = 0;
		for(int i=0; i<8;i++) 
			for(int j=0; j<8;j++) 
				if(getPiece(i,j).getType() == team) {
					counter++;
				}	
		return counter;
	}
	
	//Checks for possible moves by either team
	public boolean gameOver() {
		ReversiPiece tester = new ReversiPiece(Piece.BLANK);
		
		for(int team=1; team <= 2; team++) {
			tester.setType(team);
			for(int i=0; i<8;i++) 
				for(int j=0; j<8;j++) {
					if(isValid(i,j,tester)) return true;
				}
		}
		return false;
	}
}