import java.util.Scanner;

public class TicTacToe
{
   private Player player1;
   private Player player2;
   private Player currentPlayer;
   private Player enemyPlayer;
   private TicTacToeBoard tttBoard;
   private char[][] setup = {{'1','2','3'},
                             {'4','5','6'},
                             {'7','8','9'}};
   Scanner input = new Scanner(System.in);
   
   public TicTacToe()
   {  
   }
   
   public void play()
   {
      this.setupGame();
      char playerMove;
      while(tttBoard.isDraw() == false)
      {
         if(currentPlayer.getHuman())
         {
            //Human turn
            tttBoard.displayBoard();
            System.out.println(currentPlayer.getPlayerName() + ", enter your move: ");
            playerMove = input.next().charAt(0);
            if(tttBoard.validMove(playerMove) == false)
               System.out.println("That space isn't open! Try again.");
            else
            {
               tttBoard.changeSquare(playerMove, currentPlayer.getPlayerLetter());
               if (tttBoard.winner(currentPlayer))
               {
                  tttBoard.displayBoard();
                  System.out.println(currentPlayer.getPlayerName() + " is the winner!");
                  break;
               }
               else if(currentPlayer == player1)
               {
                  currentPlayer = player2;
                  enemyPlayer = player1;
               }
               else 
               {
                  currentPlayer = player1;
                  enemyPlayer = player2;
               }
            }
         }
         else
         {
            //Computer turn
            tttBoard.changeSquare(tttBoard.findBestMove(this.currentPlayer, this.enemyPlayer), this.currentPlayer.getPlayerLetter());
            if (tttBoard.winner(currentPlayer))
               {
                  tttBoard.displayBoard();
                  System.out.println(currentPlayer.getPlayerName() + " is the winner!");
                  break;
               }
               else if(currentPlayer == player1)
               {
                  currentPlayer = player2;
                  enemyPlayer = player1;
               }
               else
               {
                  currentPlayer = player1;
                  enemyPlayer = player2;
               }
         }
            
      }
      if(tttBoard.isDraw() && !tttBoard.winner(currentPlayer))
      {
         tttBoard.displayBoard();
         System.out.println("It's a draw.");
      }
   }
   
   private void setupGame()
   {
      System.out.println("Player 1, enter your name, or enter Computer for a computer player: ");
      String enteredName = input.nextLine();
      if(enteredName.equals("Computer") || enteredName.equals("computer"))
         player1 = new Player('X', "Computer", false);
      else player1 = new Player('X', enteredName, true);
      System.out.println("Player 2, enter your name, or enter Computer for a computer player: ");
      enteredName = input.nextLine();
      if(enteredName.equals("Computer") || enteredName.equals("computer"))
         player2 = new Player('O',"Computer", false);
      else player2 = new Player('O',enteredName, true);
      currentPlayer = player1;
      enemyPlayer = player2;
      tttBoard = new TicTacToeBoard(this.setup);      
   }
}