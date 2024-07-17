class Tutorial {
           
    public Tutorial() { }

        public void printSample() throws InterruptedException {

        System.out.println();
        System.out.println("WELCOME TO TUTORIAL");
        System.out.println("=+=+=+=+=+=+=+=+=+=");
        System.out.println();
        System.out.println("Here is a sample board:");
        System.out.println();
        System.out.println("******SAMPLE******");
        Thread.sleep(200);
        System.out.println("  0 1 2 3 4 5 6 7");
        Thread.sleep(200);
        System.out.println("0 R N B Q K B N R");
        Thread.sleep(200);
        System.out.println("1 P P P P P P P P");
        Thread.sleep(200);
        System.out.println("2 . . . . . . . .");
        Thread.sleep(200);
        System.out.println("3 . . . . . . . .");
        Thread.sleep(200);
        System.out.println("4 . . . . . . . .");
        Thread.sleep(200);
        System.out.println("5 . . . . . . . .");
        Thread.sleep(200);
        System.out.println("6 p p p p p p p p");
        Thread.sleep(200);
        System.out.println("7 r n b q k b n r");
        Thread.sleep(200);
        System.out.println("******************");
        System.out.println();

        try {
            showMove();
        } catch (InterruptedException e) { e.printStackTrace(); }


    } //end sample

    public static void showMove() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Lets learn how to move a peice now.");
        System.out.println();
        System.out.println("First NOTE: all pieces move in proper CHESS fashion.");
        System.out.println();
        Thread.sleep(2000);

        System.out.println("Regardless of play style you see this menu:");
        System.out.println("From Row: ");
        System.out.println("From Col: ");
        System.out.println("To Row: ");
        System.out.println("To Col: ");
        System.out.println();
        Thread.sleep(5000);
        
        Thread.sleep(1000);
        System.out.println("Let's practice.");
        System.out.println();
        System.out.println("For our {FROM ROW] let's select 6");
        System.out.println("On the board we are selecting:");
        System.out.println();
        System.out.println("R N B Q K B N R");
        System.out.println("P P P P P P P P");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println("p p p p p p p p <----------");
        System.out.println("r n b q k b n r");
        System.out.println();
        Thread.sleep(5000);
        System.out.println("This is the white row of PAWNS");
        Thread.sleep(1000);

        Thread.sleep(2000);
        System.out.println("Great, now lets select our [FROM COl].");
        Thread.sleep(1000);
        System.out.println("Let's select, 4.");
        Thread.sleep(1000);
        System.out.println("On the board we are now selecting:");
        System.out.println();
        System.out.println("R N B Q K B N R");
        System.out.println("P P P P P P P P");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . | . . .");
        System.out.println(". . . . | . . .");
        System.out.println(". . . . V . . .");
        System.out.println("p p p p p p p p");
        System.out.println("r n b q k b n r");
        System.out.println();
        Thread.sleep(5000);
        System.out.println("The pawn at position 6,4");
        System.out.println();
        Thread.sleep(2000);

        Thread.sleep(1000);
        System.out.println("GREAT! now lets move our piece.");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("Let's set our [TO ROW] and [TO COL] to 4,4");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("That would be here:");
        System.out.println("R N B Q K B N R");
        System.out.println("P P P P P P P P");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . + . . .");
        System.out.println(". . . . . . . .");
        System.out.println("p p p p p p p p");
        System.out.println("r n b q k b n r");
        System.out.println();
        
        Thread.sleep(6000);
        System.out.println("Our Current values are:");
        System.out.println("From Row: 6");
        System.out.println("From Col: 4");
        System.out.println("To Row: 4");
        System.out.println("To Col: 4");
        System.out.println();
        Thread.sleep(4000);

        Thread.sleep(300);
        System.out.println("Upon hiting enter...");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("Our board reflects the movement");
        System.out.println();
        System.out.println("R N B Q K B N R");
        System.out.println("P P P P P P P P");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . . . . .");
        System.out.println(". . . . p . . .");
        System.out.println(". . . . . . . .");
        System.out.println("p p p p . p p p");
        System.out.println("r n b q k b n r");
        System.out.println();

        Thread.sleep(8000);
        System.out.println("Now you know how to play! Have fun!");
    } //end of the monster


} 

