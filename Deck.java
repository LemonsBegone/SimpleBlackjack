import java.util.*;

public class Deck
{
    private ArrayList <Card> cardDeck = new ArrayList <Card>();
    private int valueArray[] = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    private String nameArray[] = {"2", "3", "4","5","6", "7","8","9","10","Jack","Queen","King","Ace"};
    private String suitArray [] = {"Clubs","Diamonds","Hearts","Spades"};
    Random rand;
    
    public Deck() 
    {    
        rand = new Random();
        for (int suitIndex = 0; suitIndex < suitArray.length; suitIndex ++)
        {
            for (int nameIndex = 0; nameIndex < nameArray.length; nameIndex++)
            {
                cardDeck.add(new Card(suitArray[suitIndex], valueArray[nameIndex], nameArray[nameIndex]));
            }
        }
    }
    public Card drawCard(){
      int index = rand.nextInt(cardDeck.size());
      Card drawncard = cardDeck.get(index);
      cardDeck.remove(index);
      return drawncard;
    }

    public void printDeck()
    {
        for (int i = 0; i < 52; i++)
        {
            System.out.println(cardDeck.get(i));
        }
    }
    
}
