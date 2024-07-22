import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class Bot {
    private static Random RANDOM = new Random();
    private static GenerateMoves mover = new GenerateMoves();
    private static Minimax max = new Minimax();
    private static boolean easy = false;
    private static boolean med = false;
    private static Move move = null;

    public static void setDiff(int choice) {
        if (choice == 1) {
            easy = true;
        } else if (choice == 2) {
            med = true;
        }
    }
        
    public static void makeMove() throws InterruptedException {
        List<Move> validMoves = mover.generateAllValidMoves();
        if (!validMoves.isEmpty()) {
         if (med) {
            move = max.getBestMove();
         }
            
         if (easy) {
            move = validMoves.get(RANDOM.nextInt(validMoves.size()));
         }
            System.out.println();
            System.out.println("Thinking...");
            System.out.println();
            Thread.sleep(600);
            Background.instance().movePiece(move.fromRow, move.fromCol, move.toRow, move.toCol);
        }
    }  

} //end class 

