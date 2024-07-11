public class Chess {
    public static void main(String args[]) {

        Background game = Background.instance(); // singleton here
        Tutorial t = new Tutorial(); // tut here

        // **TEST**
        // ****************
       // t.printSample();
        game.initBoard();
        game.printBoard();


        if (game.movePiece(6,4,4,4)) {
            if (game.movePiece(7,4,6,4)) {
                game.printBoard();
            }
        }
    }    
}
