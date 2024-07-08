class Background {


    private static final int SIZE = 8;
    private static char[][] board;
    private static Background theInstance;

    public Background () {
        this.theInstance = theInstance;
        this.board = new char[SIZE][SIZE];
    }

    public static synchronized Background instance() {
        if (theInstance == null) {
            theInstance = new Background();
        } 
        return theInstance;
    }

    public void initBoard() {
        for (int i=0; i<this.SIZE; ++i) {
            board[1][i] = 'P'; //black
            board[6][i] = 'p'; // white
        }

        char backGuys[] = {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}; //black
        char backGuys2[] = {'r','n','b', 'q', 'k', 'b', 'n', 'r'}; // white
                                                                  

        for (int i=0; i<this.SIZE; ++i) {
            board[0][i] = backGuys[i];
            board[7][i] = backGuys2[i];
        }

        for (int i=2; i<6; i++) {
            for (int j=0; j<this.SIZE; ++j) {
                board[i][j] = '.';
            }
        }
    } //end init
    
    public void printBoard() {
        for (int i=0; i<this.SIZE; ++i) {
            for (int j=0; j<this.SIZE; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    } // end print
   
    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        char piece = board[fromRow][fromCol];

        if (isValidMove(piece, fromRow, fromCol, toRow, toCol)) {
            board[toRow][toCol] = piece;
            board[fromRow][fromCol] = '.';
            return true;
        }
          return false;
    } // end movePiece
    
    public boolean isValidMove(char piece, int fromRow, int fromCol, int toRow, int toCol) {

        if (fromRow == toRow && fromCol == toCol) {
            return false;
        } 
        if (toRow < 0 || toRow >= this.SIZE || toCol < 0 || toCol >= this.SIZE) {
            return false;
        }
        if (Character.isUpperCase(piece) && Character.isUpperCase(board[toRow][toCol]) ||
        Character.isLowerCase(piece) && Character.isLowerCase(board[toRow][toCol])) {
            return false;
        }

        switch (Character.toLowerCase(piece)) {
            case 'p': return validPawn(fromRow,fromCol,toRow,toCol);
            /*
            case 'r': return validRook(fromRow,fromCol,toRow,toCol);
            case 'n': return validKnight(fromRow,fromCol,toRow,toCol);
            case 'b': return validBishop(fromRow,fromCol,toRow,toCol);
            case 'q': return validQueen(fromRow,fromCol,toRow,toCol);
            case 'k': return validKing(fromRow,fromCol,toRow,toCol);
            */
            default: return false;
        }
    } // end isValid
    
    public boolean validPawn(int fromRow, int fromCol, int toRow, int toCol) {
        return false;
    }



}
