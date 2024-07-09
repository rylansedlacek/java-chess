public class Chess {
    public static void main(String args[]) {

        Background game = Background.instance(); // singleton here

        // **TEST**
        // ****************
        //game.printSample();
        game.initBoard();
        game.printBoard();

        if (game.movePiece(6,4,4,4)) {
            game.printBoard();
        }

    }
}
