import java.util.*;

public class Game {
  private Deck gamedeck;
  private ArrayList<Player> Players;
  Scanner input;
  boolean rungame = false;
  private double ante;

  public Game() {
    Players = new ArrayList<Player>();
    gamedeck = new Deck();
    input = new Scanner(System.in);

    System.out.println("Would you like to play... a game? :)");
    String playGame = input.nextLine();
    if (playGame.toLowerCase().equals("no") || playGame.toLowerCase().equals("n")) {
      System.out.println("Oh, okay. See you then.");
      System.exit(0);
    }
    if (playGame.toLowerCase().equals("yes") || playGame.toLowerCase().equals("y")) {
      rungame = true;
    }
    // System.out.println("What is the ante of the game?");
    // double gameante = Double.parseDouble(input.nextLine());
    System.out.println("How much money do all players have?");
    double gamemoney = Double.parseDouble(input.nextLine());
    System.out.println("How many players would you like?");
    int playerstotal = Integer.parseInt(input.nextLine());
    this.playersetup(playerstotal, gamemoney);

  }

  public void playgame() {
    if (rungame == false) {
      System.exit(0);
    }

    System.out.println("How many rounds will be played?");
    int numberrounds = Integer.parseInt(input.nextLine());
    Dealer bobby = new Dealer();

    for (int k = 0; k < numberrounds; k++) {
      ArrayList<Integer> Winners = new ArrayList<Integer>();
      for (int i = 0; i < Players.size(); i++) {
        Players.get(i).twoCards(gamedeck);
        if (Players.get(i).twentyOneInTwo()) {
          Winners.add(i);
        }
      }

      bobby.twoCards(gamedeck);
      int bustcount = 0;
      for (int i = 0; i < Players.size(); i++) {
        boolean stay = false;
        System.out.println("It's " + Players.get(i) + "'s turn.");
        System.out.println(Players.get(i) + "'s hand value is " + Players.get(i).checkValueOfAce() + ".");

        while (!stay && !Players.get(i).bust()) {
          System.out.println("Would you like to hit?");
          String hitorstay = input.nextLine();
          if (hitorstay.toLowerCase().equals("hit") || hitorstay.toLowerCase().equals("h")) {
            Players.get(i).oneCard(gamedeck);
            if (Players.get(i).bust()) {
              System.out
                  .println(Players.get(i) + " busted with a hand value of " + Players.get(i).checkValueOfAce() + ".\n");
              bustcount++;
            } else {
              System.out.println(Players.get(i) + "'s new hand value is " + Players.get(i).checkValueOfAce() + ".\n");
            }
          } else {
            stay = true;
            System.out.println(
                Players.get(i) + " chose to stay with a hand value of " + Players.get(i).checkValueOfAce() + ".\n");
          }

        }
      }

      if (bustcount == Players.size()) {
        System.out.println("All players have busted. I win.");
      } else {
        bobby.compHit(gamedeck);
        
        if (bobby.bust()){
          for(int i = 0; i < Players.size(); i++){
            Winners.add(i);
          }
          System.out
                  .println("I busted with a hand value of " + bobby.checkValueOfAce() + ".\n");
        }

        int winnerindex = -1;
        int winnerhandval = bobby.checkValueOfAce();

        for (int i = 0; i < Players.size(); i++) {
          if (winnerhandval < Players.get(i).checkValueOfAce() && Players.get(i).checkValueOfAce() < 22) {
            winnerindex = i;
            winnerhandval = Players.get(i).checkValueOfAce();
          }
        }
        if (winnerindex == -1) {
          System.out.println("\n\nI win the round with a hand value of " + bobby.checkValueOfAce());
        } else {
          System.out.println("\n\n" + Players.get(winnerindex) + " wins the round with a hand value of "
              + Players.get(winnerindex).checkValueOfAce());
        }
      }
      for (int i = 0; i < Players.size(); i++) {
        Players.get(i).resethand();
      }
      bobby.resethand();
    }
  }

  public void playersetup(int playerstotal, double gamemoney) {
    for (int i = 0; i < playerstotal; i++) {
      System.out.println("What is name of Player " + (i + 1) + "?");
      String playeriname = input.nextLine();
      Player currentplayer = new Player(playeriname, gamemoney);
      Players.add(currentplayer);
    }
  }
  
  public void whowinner() {

  }

  public void endgame() {

  }

}