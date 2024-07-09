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
            case 'p': return validPawn(piece,fromRow,fromCol,toRow,toCol);
            case 'r': return validRook(fromRow,fromCol,toRow,toCol);
            case 'n': return validKnight(fromRow,fromCol,toRow,toCol);
            case 'b': return validBishop(fromRow,fromCol,toRow,toCol);
            /*
            case 'q': return validQueen(fromRow,fromCol,toRow,toCol);
            case 'k': return validKing(fromRow,fromCol,toRow,toCol);
            */

            default: return false;
        }
    } // end isValid
    
    public boolean validPawn(char piece, int fromRow, int fromCol, int toRow, int toCol) {
        int dir, startRow; // just learned how to do this haha

        if (Character.isUpperCase(piece)) {
            dir = 1; 
            startRow = 1;
        } else {
            dir = -1;
            startRow = 6;
        }
      
        if (fromCol == toCol) {
            if (toRow - fromRow == dir && board[toRow][toCol] == '.') {
                return true;
            }

            if (fromRow == startRow && toRow - fromRow == 2 * dir &&
                    board[toRow][toCol] == '.' && board[fromRow + dir][toCol] == '.') {
                return true;
            }   
        }

        if (Math.abs(fromCol - toCol) == 1 && toRow - fromRow == dir) {
             if (board[toRow][toCol] != '.' &&
                 Character.isUpperCase(piece) != Character.isUpperCase(board[toRow][toCol])) {
                    return true;
            }
        }
        return false; // default
    } //end pawn

    public boolean validRook(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow == toRow && fromCol == toCol) {
            return false;
        }

        int rowDir = Integer.signum(toRow - fromRow);
        int colDir = Integer.signum(toCol - fromCol);

        int currRow = fromRow + rowDir;
        int currCol = fromCol + colDir;

        while (currRow != toRow || currCol != toCol) {
            if (board[currRow][currCol] != '.') {
                return false;
            }
            currRow += rowDir;
            currCol += colDir;
        }

         if (board[toRow][toCol] != '.' && 
                 Character.isUpperCase(board[fromRow][fromCol]) == Character.isUpperCase(board[toRow][toCol])) {
            return false;
        }
        return true; //default
    } // end rook
    
    public boolean validKnight(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if ((rowDiff == 1 && colDiff == 2) || (rowDiff == 2 && colDiff == 1)) {
            if (board[toRow][toCol] == '.' || Character.isUpperCase(board[fromRow][fromCol]) != 
                    Character.isUpperCase(board[toRow][toCol])) {
                return true;
            }   
        }
        return false; // default
    } // end knight
    
    public boolean validBishop(int fromRow, int fromCol, int toRow, int toCol) {
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if (rowDiff != colDiff) {
            return false;
        }

        int rowDir = Integer.signum(toRow - fromRow);
        int colDir = Integer.signum(toCol - fromCol);

        int currRow = fromRow + rowDir;
        int currCol = fromCol + colDir;

        while (currRow != toRow || currCol != toCol) {
            if (board[currRow][currCol] != '.') {
                return false;
            }
            currRow += rowDir;
            currCol += colDir;
        }

        if (board[toRow][toCol] != '.' && 
                Character.isUpperCase(board[fromRow][fromCol]) == Character.isUpperCase(board[toRow][toCol])) {
            return false;
        }

        return true; //default
    } // end bishop



} // end CLASS
