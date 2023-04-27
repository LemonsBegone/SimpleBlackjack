import java.util.*;

public class Player implements Rules
{
    ArrayList<Card> hand;
    int playerCount = 0;
    private String name;
    private double money;
    public Player(String name, double money)
        {
            this.name = name;
            this.money = money;
            hand = new ArrayList<Card>();
        }
    public String getname(){
      return name;
    }
    public double getmoney(){
      return money;
    }
    public boolean bust(){
      if(this.checkValueOfAce() > 21){
        return true;
      }else{
        return false;
      }
    }
  
    public void compHit(Deck gamedeck){
    }
  
    public boolean twentyOneInTwo(){
      if(this.checkValueOfAce() == 21){
        return true;
      }else{
        return false;
      }
    }
    public void twoCards(Deck deckOfCards){
      for (int i = 0; i < 2; i++){
              hand.add(deckOfCards.drawCard());
            }
      playerCount = this.checkValueOfAce();
    }
    public void oneCard(Deck deckOfCards){
      hand.add(deckOfCards.drawCard());
      playerCount = this.checkValueOfAce();
    }
    public int checkValueOfAce(){
      int handcount = 0;
      int acecount = 0;
      for (int i = 0; i < hand.size(); i++){
        if(hand.get(i).getCardName().equals("Ace")){
          acecount++;
        }
        handcount += hand.get(i).getCardValue();
      }
      while(handcount > 21 && acecount > 0){
        handcount -= 10;
        acecount--;
      }
      return handcount;
    }
  public void resethand(){
    playerCount = 0;
    hand.clear();
  }
  public String toString(){
    return name;
  }
}