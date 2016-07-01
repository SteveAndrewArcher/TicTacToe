import java.util.Random;

public class TicTacToeBoard extends Board
{

   public TicTacToeBoard(char[][] boardsetup)
   {
      super(boardsetup);
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
      for(row=0; row < board.length; row++)
      {
         for(col=0; col < board[row].length; col++)  
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
      char bestMove = ' ';
      int v = 0;
      int maxValue = -2;
      for(int i=1; i<=9; i++)
      {
         char move = (char)i+48
         if(this.validMove(move)
         {
            testboard = (TicTacToeBoard) this.clone();
            testboard.changeSquare(move);
            v = testboard.maxValue(maximizingPlayer, minimizingPlayer);
            if(v > maxValue)
            {
               maxValue = v;
               char bestMove = move;           
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
      int v = -2;
      for(int i=1; i<=9; i++)
      {
         char move = (char)i+48
         if(this.validMove(move)
         {
            testboard = (TicTacToeBoard) this.clone();
            testboard.changeSquare(move);
            v = Math.max(testboard.minValue(maximizingPlayer, minimizingPlayer), v);
         }
      }
   }
   
   
   public int minValue(Player maximizingPlayer, Player minimizingPlayer)
   {
      if(this.winner(maximizingPlayer))
         return 1;
      else if(this.winner(minimizingPlayer))
         return -1;
      else if(this.isDraw())
         return 0;
      int v = 2;
      for(int i=1; i<=9; i++)
      {
         char move = (char)i+48
         if(this.validMove(move)
         {
            testboard = (TicTacToeBoard) this.clone();
            testboard.changeSquare(move);
            v = Math.min(testboard.maxValue(maximizingPlayer, minimizingPlayer), v);
         }
      }
   }
   
      
      
      
      
      
      
      
      
      
      

