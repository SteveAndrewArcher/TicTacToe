import java.util.Scanner;

public class PlayGame
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      char again;
      while(true)
      {
         TicTacToe game = new TicTacToe();
         game.play();
         System.out.println("Play again? Type Y or N:");
         again = input.next().charAt(0);
         if(again!='Y' && again!='y')
            break;
      }
   }
}