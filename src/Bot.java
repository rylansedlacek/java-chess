import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class Bot {
    private static Random RANDOM = new Random();
        
    public static void makeMove() throws InterruptedException {
        List<Move> validMoves = generateAllValidMoves();
        if (!validMoves.isEmpty()) {
           // int test = getBestMove();
          //  System.out.println(test);
          //  Move move = getBestMove();
           Move move = validMoves.get(RANDOM.nextInt(validMoves.size()));
            System.out.println();
            System.out.println("Thinking...");
            System.out.println();
            Thread.sleep(600);
            Background.instance().movePiece(move.fromRow, move.fromCol, move.toRow, move.toCol);
        }
    }  

    public static List<Move> generateAllValidMoves() {
        List<Move> validMoves = new ArrayList<>(); //learned this from leetCode!
        for (int i=0; i<Background.SIZE; i++) {
            for (int j=0; j<Background.SIZE; j++) {
                char piece = Background.board[i][j];
                if (Character.isUpperCase(piece)) {
                    for (int k=0; k<Background.SIZE; k++) {
                        for (int l =0; l<Background.SIZE; l++) {
                            if (Background.instance().isValidMove(piece, i, j, k, l)) {
                                validMoves.add(new Move(i,j,k,l));
                        }
                    }
                }
            }
        }
        
    } 
        return validMoves;  
    }   


    public static Move getBestMove() {
        List<Move> valid = generateAllValidMoves();
       int bestValue = -9999;
       int bestMoveIndex = 0;
        Move bestMove = null;

        // add from row
        // add from col
        // add to row
        // add to col
       
        for (int i=0; i<valid.size(); i++) {
            Move newMove = valid.get(i);
            Background.instance().movePiece(newMove.fromRow, newMove.fromCol, newMove.toRow, newMove.toCol);

            int boardVal = -boardValue();
            //System.out.println(boardVal);
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
      //  System.out.println("TOTAL: " + total);
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




} //end class 

