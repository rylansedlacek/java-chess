import java.util.Scanner;
public class Chess {
    public static void main(String args[]) {

        Background game = Background.instance(); // singleton here
        Tutorial t = new Tutorial(); // tut here
        Scanner stdin = new Scanner(System.in);
        boolean quit = false;
       
        int choice = 0;
        
        System.out.println("WELCOME TO CONSOLE CHESS");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("1 - Tutorial");
        System.out.println("2 - Play V.S. AI");
        System.out.println("3 - Player V.S. Player");
        System.out.print("> ");
        choice = stdin.nextInt();


        if (choice == 1) {
            try {
                t.printSample();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }


      if (choice == 2) {
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
                 System.out.println("**WHITE MOVE**");
                 game.printBoard();
                 hey = false;
                 System.out.println("**BLACK MOVE**");
                 Bot.makeMove();
                 game.printBoard();
             } else {
                 System.out.println("*****INVALID MOVE*****");
             }
        } // end while
    }

    if (choice == 3) {
        game.initBoard();
        game.printBoard();
        String color = "";
        int counter = 1;

        while (!quit) {
            if (counter % 2 == 0) {
                color = "BLACK";
            } else { color = "WHITE"; } 

        }


    }


    }    
}
