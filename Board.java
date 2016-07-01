public class Board
{
   protected char[][] board;
   
   public Board(char[][] boardsetup)
   {
      board = boardsetup;
   }
   
   public char getSquare(char displayValue)
   {
      int[] coordinates = convertToCoord(displayValue);
      return this.board[coordinates[0]][coordinates[1]];
   }
   
   public void changeSquare(char displayValue, char newValue)
   {
       int[] coordinates = this.convertToCoord(displayValue);
       this.board[coordinates[0]][coordinates[1]] = newValue;
   }
   
   public void displayBoard()
   {               
      int row, col;
      for (row=0; row<this.board.length; row++)
      {
         for(col=0; col<this.board[row].length; col++)
         {
            if(col<this.board[row].length-1)
               System.out.print("     |");
            else
               System.out.print("     \n");
         }
         for(col=0; col<this.board[row].length; col++)
         {
            if(col<this.board[row].length-1)
               System.out.print("  " + this.board[row][col] + "  |");
            else System.out.print("  " + this.board[row][col] + "  \n");
         }
         for(col=0; col<this.board[row].length; col++)
         {
            if(row<this.board.length-1)
            {
               if(col<this.board[row].length-1)
                  System.out.print("_____|");
               else System.out.print("_____\n");
            }
            else
            {
               if(col<this.board[row].length-1)
                  System.out.print("     |");
               else System.out.print("     \n");
            }
         }
      }
   }
   
   public boolean validMove(char enteredMove)
   {
      int row, col;
      for(row=0; row < this.board.length; row++)
      {
         for(col=0; col < this.board[row].length; col++)
         {
            if(board[row][col] == enteredMove)
               return true;
         }
      }
      return false;      

   }
   
   private int[] convertToCoord(char displayValue)
   {
      int row, col;
      int[] coordinates = new int[2];
      for(row=0; row < this.board.length; row++)
      {
         for(col=0; col < this.board[row].length; col++)
         {
            if(board[row][col] == displayValue)
            {
               coordinates[0] = row;
               coordinates[1] = col;
               return coordinates;
            }
         }
      }       
      return coordinates;
   }    
}
      