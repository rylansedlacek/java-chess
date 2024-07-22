import java.util.List;
import java.util.ArrayList;

class GenerateMoves {

    public GenerateMoves() { }

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
    } // end method
    
} //end class

