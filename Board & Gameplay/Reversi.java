public class Reversi extends Board {
    private CheckerPiece[][] pieces;
    private boolean up, upR, right, downR, down, downL, left, upL;

    public Reversi() {
        size = DEFAULTSIZE;
        pieces = new CheckerPiece[size][size];

        right = false;
        upR = false;
        downR = false;
        left = false;
        upL = false;
        up = false;
        downL = false;
        down = false;
        setGameOn();
    }

   
    //Accessors
    public CheckerPiece getPiece(int row, int column) {
        return pieces[row][column];
    }

    //Class methods
    private void setGameOn() {
        for (int row = 0; row < size; row++)
            for (int column = 0; column < size; column++)
                pieces[row][column] = new CheckerPiece(Piece.BLANK);
        getPiece(3,3).setType(2);
        getPiece(3,4).setType(1);
        getPiece(4,3).setType(1);
        getPiece(4,4).setType(2);
    }    

    public void make_a_Move(int row, int col, CheckerPiece piece) 
    {
        int team, rowStep, colStep;
        team = piece.getType();
        rowStep = row;
        colStep = col;

        if(isValid(row, col, piece)) {
            pieces[row][col] = piece;
            //flip over the effected pieces


            //Direction =  Right
            if (right) { 
                colStep++;
                while (getPiece(row, colStep).getType() == piece.getOpp(team)) {
                    getPiece(row, colStep++).setType(team);
                }
                col = colStep;
            }


             //Direction = up Right
             if (upR) {
                int currentRow = row - 1, currentCol = col + 1;
                while (currentRow >= 0 && currentCol < 8 && getPiece(currentRow, currentCol).getType() == piece.getOpp(team)) 
                {
                    getPiece(currentRow, currentCol).setType(team);
                    currentRow--;
                    currentCol++;
                }
            }


             //Direction =  down right
             while(downR) {
                rowStep++;
                colStep++;
                if(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) {
                    getPiece(rowStep,colStep).setType(team);
                } else {
                    downR = false;
                }
                colStep = col;
                rowStep = row;
            }

            //Direction = left
            if(left) {
                if(getPiece(row,colStep).getType() != piece.getOpp(team)) {
                    left = false;
                } else {
                    getPiece(row,colStep).setType(team);
                }
                colStep = col;

            }


            //Direction = upleft
            if (upL) { 
                rowStep--;
                colStep--;
                while (getPiece(rowStep, colStep).getType() == piece.getOpp(team)) {
                    getPiece(rowStep--, colStep--).setType(team);
                }
                row = rowStep;
                col = colStep;
            }


            //Direction = down left
            while(downL) {
                rowStep++;
                colStep--;
                if(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) {
                    getPiece(rowStep,colStep).setType(team);
                } else {
                    downL = false;
                }
                rowStep = row;
                colStep = col;
            }
        

            // Direction = up
            if (up) {
                int currentRow = row - 1;
                while (currentRow >= 0 && getPiece(currentRow, col).getType() == piece.getOpp(team)) 
                {
                    getPiece(currentRow, col).setType(team);
                    currentRow--;
                }
            }
        

            //Direction = down
            while(down) {
                rowStep++;
                if(getPiece(rowStep,col).getType() == piece.getOpp(team)) {
                    getPiece(rowStep,col).setType(team);
                } else {
                    down = false;
                }
                rowStep = row;

            }
 

        }
      
    }
    
    public boolean isValid(int row, int col, CheckerPiece piece) { 
        int team, rowStep, colStep;
        team = piece.getType();
        rowStep = row;
        colStep = col;
    
        if (row > size || col > size) return false;

        if (pieces[row][col].getType() == Piece.BLANK) {
            boolean up = false, upR = false;
            rowStep = row; colStep = col;


            //Direction: right
            if (col != size) {
                colStep = col + 1;
                while (getPiece(row, colStep).getType() == piece.getOpp(team)) {
                    colStep++;
                }
                if (getPiece(row, colStep).getType() == team) {
                    right = true;
                    return true;
                }
            }


            //Direction: UP right
            if (row != 0 && col != size) {
                rowStep = row - 1; colStep = col + 1;
                while (getPiece(rowStep, colStep).getType() == piece.getOpp(team)) {
                    rowStep--;
                    colStep++;
                }
                if (getPiece(rowStep, colStep).getType() == team) {
                    upR = true;
                    return true;
                }
            }


            //Direction: down right
            if (row != size && col != size) {
                rowStep = row + 1; colStep = col + 1;
                while (getPiece(rowStep, colStep).getType() == piece.getOpp(team)) {
                    rowStep++;
                    colStep++;
                }
                if (getPiece(rowStep, colStep).getType() == team) {
                    downR = true;
                    return true;
                }
            }



             // Direction left
             if (col != 0) {
                colStep = col - 1;
                while (getPiece(row, colStep).getType() == piece.getOpp(team)) {
                    colStep--;
                }
                if (getPiece(row, colStep).getType() == team) {
                    left = true;
                    return true;
                }
            }

            //Direction up left
            if (row != 0 && col != 0) {
                rowStep = row - 1; colStep = col - 1;
                while (getPiece(rowStep, colStep).getType() == piece.getOpp(team)) {
                    rowStep--;
                    colStep--;
                }
                if (getPiece(rowStep, colStep).getType() == team) {
                    upL = true;
                    return true;
                }
            }


            //Direciton down left
            if (row != size && col != 0) {
                rowStep = row + 1; colStep = col - 1;
                while (getPiece(rowStep, colStep).getType() == piece.getOpp(team)) {
                    rowStep++;
                    colStep--;
                }
                if (getPiece(rowStep, colStep).getType() == team) {
                    downL = true;
                    return true;
                }
            }


            //Direction UP
            if (row != 0) {
                rowStep = row - 1;
                while (getPiece(rowStep, col).getType() == piece.getOpp(team)) {
                    rowStep--;
                }
                if (getPiece(rowStep, col).getType() == team) {
                    up = true;
                    return true;
                }
            }

            //Direction: down
            if (row != size) {
                rowStep = row + 1;
                while (getPiece(rowStep, col).getType() == piece.getOpp(team)) {
                    rowStep++;
                }
                if (getPiece(rowStep, col).getType() == team) {
                    down = true;
                    return true;
                }
            }


        }
        return false;
    }

    public boolean game_is_Over() {
        CheckerPiece tester = new CheckerPiece(Piece.BLANK);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int team = 1; team <= 2; team++) {
                    tester.setType(team);
                    if (isValid(i, j, tester)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
