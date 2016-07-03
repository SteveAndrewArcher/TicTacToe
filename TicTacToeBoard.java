import java.util.Random;

public class TicTacToeBoard implements Cloneable
{
   private char[][] board;
   public TicTacToeBoard(char[][] boardsetup)
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

   public boolean winner(Player player)
   {
      return((this.board[0][0]==player.getPlayerLetter()&&this.board[0][1]==player.getPlayerLetter()&&this.board[0][2]==player.getPlayerLetter())
            ||
            (this.board[1][0]==player.getPlayerLetter()&&this.board[1][1]==player.getPlayerLetter()&&this.board[1][2]==player.getPlayerLetter())
            ||
            (this.board[2][0]==player.getPlayerLetter()&&this.board[2][1]==player.getPlayerLetter()&&this.board[2][2]==player.getPlayerLetter())
            ||
            (this.board[0][0]==player.getPlayerLetter()&&this.board[1][0]==player.getPlayerLetter()&&this.board[2][0]==player.getPlayerLetter())
            ||
            (this.board[0][1]==player.getPlayerLetter()&&this.board[1][1]==player.getPlayerLetter()&&this.board[2][1]==player.getPlayerLetter())
            ||
            (this.board[0][2]==player.getPlayerLetter()&&this.board[1][2]==player.getPlayerLetter()&&this.board[2][2]==player.getPlayerLetter())
            ||
            (this.board[0][0]==player.getPlayerLetter()&&this.board[1][1]==player.getPlayerLetter()&&this.board[2][2]==player.getPlayerLetter())
            ||
            (this.board[2][0]==player.getPlayerLetter()&&this.board[1][1]==player.getPlayerLetter()&&this.board[0][2]==player.getPlayerLetter()));
   }
   
   public boolean isDraw()
   {
      int row, col;
      for(row=0; row < this.board.length; row++)
      {
         for(col=0; col < this.board[row].length; col++)  
         {
            if(board[row][col] != 'X' && board[row][col] != 'O')
               return false;  
         }
      } 
      return true;      
   }
   
   public char findBestMove(Player maximizingPlayer, Player minimizingPlayer)
   {  
      TicTacToeBoard testboard = null;
      TicTacToeBoard[] testboards = new TicTacToeBoard[10];
      char bestMove = ' ';
      int v = 0;
      int bestValue = -2;
      for(int i=1; i<=9; i++)
      {  
         int movenum = i + 48;
         char move = (char)movenum;
         if(this.validMove(move))
         {  
            try
            {
               testboard = (TicTacToeBoard) this.clone();
            }
            catch(Exception e)
            {
               System.out.println("OMG its exception "+e);
            }
            testboard.changeSquare(move, maximizingPlayer.getPlayerLetter());
            testboards[i] = testboard;
         }
      }      
      for(int i = 1; i<testboards.length; i++)
      {  
         int movenum = i + 48;
         char move = (char)movenum;
         if(testboards[i] != null)
         {
            v = testboards[i].maxValue(maximizingPlayer, minimizingPlayer);
            
            if(v > bestValue)
            {
               bestValue = v;
               bestMove = move;           
            }
         }
      }
      return bestMove;
    }
    
    public int maxValue(Player maximizingPlayer, Player minimizingPlayer)
    {
      
      if(this.winner(maximizingPlayer))
         return 1;
      else if(this.winner(minimizingPlayer))
         return -1;
      else if(this.isDraw())
         return 0;
      TicTacToeBoard testboard = null;
      TicTacToeBoard[] testboards = new TicTacToeBoard[10];   
      int v = -2;
      for(int i=1; i<=9; i++)
      {
         int movenum = i + 48;
         char move = (char)movenum;
         if(this.validMove(move))
         {
            try
            {
               testboard = (TicTacToeBoard) this.clone();
            }
            catch(Exception e)
            {
               System.out.println("OMG its exception "+e);
            }
            testboard.changeSquare(move, minimizingPlayer.getPlayerLetter());
            testboards[i] = testboard;
         }
      }
      for(int i=1; i <= 9; i++)
      {
         if(testboards[i] != null)
            v = Math.max(testboards[i].minValue(maximizingPlayer, minimizingPlayer), v);
      }
      
      return v;
   }
   
   
   public int minValue(Player maximizingPlayer, Player minimizingPlayer)
   {
      if(this.winner(maximizingPlayer))
         return 1;
      else if(this.winner(minimizingPlayer))
         return -1;
      else if(this.isDraw())
         return 0;
      TicTacToeBoard testboard = null;
      TicTacToeBoard[] testboards = new TicTacToeBoard[10];   
      int v = 2;
      for(int i=1; i<=9; i++)
      {
         int movenum = i + 48;
         char move = (char)movenum;
         if(this.validMove(move))
         {
            try
            {
               testboard = (TicTacToeBoard) this.clone();
            }
            catch(Exception e)
            {
               System.out.println("OMG its exception "+e);
            }
            testboard.changeSquare(move, maximizingPlayer.getPlayerLetter());
            testboards[i] = testboard;
         }
      }
      for(int i=1; i <= 9; i++)
      {
         if(testboards[i] != null)
            v = Math.min(testboards[i].maxValue(maximizingPlayer, minimizingPlayer), v);
      }
      
      return v; 
   }
   
   @Override
   public TicTacToeBoard clone()
   {  
      char[][] boardcopy = new char[3][3];
      for(int row=0; row<this.board.length; row++)
      {
         for(int col=0; col<this.board[row].length; col++)
         {
            boardcopy[row][col] = this.board[row][col];
         }
      }
      TicTacToeBoard copy = new TicTacToeBoard(boardcopy);
      return copy;
   }
}   
      
      
      
      
      
      
      
      
      
      

