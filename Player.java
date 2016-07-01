public class Player
{
   private char letter;
   private String name;
   private boolean human;
   
   public Player(char letter, String name, boolean human)
   {
      this.letter = letter;
      this.name = name;
      this.human = human;
   }
   
   public char getPlayerLetter()
   {
      return this.letter;
   }
   
   public String getPlayerName()
   {
      return this.name;
   }
   
   public boolean getHuman()
   {
      return this.human;
   }
   
}
   