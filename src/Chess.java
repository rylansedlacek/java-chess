import java.util.Scanner;
public class Chess {
    public static void main(String args[]) {

        Background game = Background.instance(); // singleton here
        Tutorial t = new Tutorial(); // tut here
        Scanner stdin = new Scanner(System.in);
        boolean quit = false;
       
        int choice = 0;
       
        while (true) {
        System.out.println("WELCOME TO CONSOLE CHESS");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("1 - Tutorial");
        System.out.println("2 - Play V.S. AI");
        System.out.println("3 - Player V.S. Player");
        System.out.println("4 - Exit");
        System.out.print("> ");
        choice = stdin.nextInt();

        if (choice == 4) {System.exit(1);}

        if (choice == 1) {
            try {
                t.printSample();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }


      if (choice == 2) {
       game.initBoard(); 
       System.out.println();
       game.printBoard();

        while (!quit) {
            System.out.println("++YOUR MOVE++");
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
                 try {
                 Bot.makeMove();
                 System.out.println("**BLACK MOVE**"); 
                 } catch (InterruptedException e) { e.printStackTrace(); } 
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
           

          System.out.println("++" + color + " MOVE" + "++");
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
              counter++;
              game.printBoard();
              hey = false;
          } else { System.out.println("*****INVALID MOVE*****"); }
        }
    }
    } // end big while

    }    
}
