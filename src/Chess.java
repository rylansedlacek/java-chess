public class Chess {
    public static void main(String args[]) {

        Background game = Background.instance(); // singleton here

        // **TEST**
        // ****************
        //game.printSample();
        game.initBoard();
        game.printBoard();

        if (game.movePiece(6,7,4,7)) {
            if (game.movePiece(7,7,5,7)) {
                game.printBoard();
            }
        }

    }
}
