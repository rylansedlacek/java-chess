public class Chess {
    public static void main(String args[]) {

        Background game = Background.instance(); // singleton here
        Tutorial t = new Tutorial(); // tut here

        // **TEST**
        // ****************
       // t.printSample();
        game.initBoard();
        game.printBoard();

        if (game.movePiece(6,3,4,3)) {
            if (game.movePiece(7,2,5,4)) {
                game.printBoard();
            }
        }

    }
}
