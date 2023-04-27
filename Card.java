public class Card
{
   int cardValue;
   String cardName;
   String cardSuit;

   public Card()
   {

   } 

   public Card(String suit, int value, String name)
   {
       cardValue = value;
       cardName = name;
       cardSuit = suit;
   }

   public void setCardValue(int myCardValue)
   {
       cardValue = myCardValue;
   }
   public void setCardName(String myCardName){
        cardName = myCardName;
    }
    public void setCardSuit(String myCardSuit){
        cardSuit = myCardSuit;
    }
    public int getCardValue (){
        return cardValue;
    }
    public String getCardName (){
        return cardName;
    }
    public String getCardSuit(){
        return cardSuit;
    }
    public String toString(){
        return (getCardName() + " of " + getCardSuit());
    }

}
