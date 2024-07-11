import java.util.Scanner;
public class Chess {
    public static void main(String args[]) {

        Background game = Background.instance(); // singleton here
        Tutorial t = new Tutorial(); // tut here
        Scanner stdin = new Scanner(System.in);
        boolean quit = false;
       // t.printSample();
        game.initBoard();
        game.printBoard();

        while (!quit) {

             System.out.print("From Row: ");
             int fromRow = stdin.nextInt();
             System.out.print("From Col: ");
             int fromCol = stdin.nextInt();
             System.out.print("To Row: ");
             int toRow = stdin.nextInt();
             System.out.print("To Col: ");
             int toCol = stdin.nextInt();
             System.out.println();

             boolean hey = game.movePiece(fromRow, fromCol, toRow, toCol);
             if (hey) {
                 game.printBoard();
                 hey = false;
             } else {
                 System.out.println("INVALID MOVE");
             }
        } // end while


    }    
}
