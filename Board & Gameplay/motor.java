public class motor {
    public static void main(String[] args) {
        Reversi board = new Reversi();
        CheckerPiece testmove = new CheckerPiece(2);
        board.make_a_Move(5, 3, testmove);
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(board.getPiece(i,j).toChar() + " ");
            }
        }
    }
}
