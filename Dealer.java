import java.util.*;

public class Dealer implements Rules
    {
        ArrayList <Card> dealer;
        int dealerCount = 0;
        public Dealer()
        {
            dealer = new ArrayList<Card>();
        }
    public boolean bust(){
      if(this.checkValueOfAce() > 21){
        return true;
      }else{
        return false;
      }
    }
    public void compHit(Deck gamedeck){
      while (this.checkValueOfAce() < 17) {
          this.oneCard(gamedeck);
        }
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
          dealer.add(deckOfCards.drawCard());
          }
      System.out.println("\n\nI am showing a(n) " + dealer.get(1) + "\n");
      dealerCount = this.checkValueOfAce();
    }

    public void oneCard(Deck deckOfCards){
      if(dealerCount < 21){
        dealer.add(deckOfCards.drawCard());
      dealerCount = this.checkValueOfAce();
      for (int i = 1; i < dealer.size(); i++){
      System.out.println("I draw a(n) " + dealer.get(i) + ", bringing my hand total to " + dealerCount);
        if (dealerCount > 21){
        bust();
        }
      }
      }
    }
      
    public int checkValueOfAce(){
    int handcount = 0;
    int acecount = 0;
      for (int i = 0; i < dealer.size(); i++){
        if(dealer.get(i).getCardName().equals("Ace")){
        acecount++;
        }
        handcount += dealer.get(i).getCardValue();
      }
      while(handcount > 21 && acecount > 0){
        handcount -= 10;
        acecount--;
      }
      return handcount;
    }
        
        /*public ArrayList<Card> twoCards(ArrayList<Card>deckOfCards)
        {
            for (int i = 0; i < 2; i++)
            {
                int index = (int)(Math.random() * deckOfCards.size() -1);
                deckOfCards.remove(index);
                //System.out.println(index);
                dealer.add(deckOfCards.get(index));
                dealerHandvalue = dealerHandvalue + dealer.get(dealerCount).getCardValue();
            }
            dealerCount ++;
         System.out.println("The dealer is showing a " + dealer.get(dealerCount).getCardName() + " of " +  dealer.get(dealerCount).getCardSuit() + "\n");   
          return deckOfCards;  
        }*/
  public void resethand(){
    dealerCount = 0;
    dealer.clear();
  } 
public ArrayList<Card> finishGame(ArrayList<Card>deckOfCards)
        {
           return deckOfCards; 
        }
    }
