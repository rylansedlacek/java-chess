import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Minimax {
  
   private static Random RANDOM = new Random(); 
   private static GenerateMoves mover = new GenerateMoves(); 
   public Minimax() {}


   public static Move getBestMove() {
       List<Move> valid = mover.generateAllValidMoves();
       int bestValue = -9999;
       int bestMoveIndex = 0;
        Move bestMove = null;

        // add from row
        // add from col
        // add to row
        // add to col

        for (int i= RANDOM.nextInt(valid.size()); i<valid.size(); i++) {
            Move newMove = valid.get(i);
            Background.instance().movePiece(newMove.fromRow, newMove.fromCol, newMove.toRow, newMove.toCol);

            int boardVal = -boardValue();
            Background.instance().bruteMove(newMove.toRow, newMove.toCol, newMove.fromRow, newMove.fromCol);

            if (boardVal > bestValue) {
                bestValue = boardVal;
                bestMove = newMove;
            }
        }
        return bestMove;
   } 

   public static int boardValue() {
           int total = 0;
        for (int i=0; i<8; ++i) {
            for (int j=0; j<8; ++j) {
                total += Math.abs(getPieceValue(Background.board[i][j]));
            }

        }
        return total;
    }

    public static int getPieceValue(char piece) {
        if (piece == '.') {
            return 0;
        }

        if (piece == 'p') {
            return 10;
        } else if (piece == 'r') {
            return 50;
        } else if (piece == 'n') {
            return 30;
        } else if (piece == 'b') {
            return 30;
        } else if (piece == 'q') {
            return 90;
        } else if (piece == 'k') {
            return 900;
        } else if (piece == 'P') {
            return -10;
        } else if (piece == 'R') {
            return -50;
        } else if (piece == 'N') {
            return -30;
        } else if (piece == 'B') {
            return -30;
        } else if (piece == 'Q') {
            return -90;
        } else if (piece == 'K') {
            return -900;
        } else {
            return 0;
        }
   }


} // end class 

