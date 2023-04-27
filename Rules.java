public interface Rules{
    //You may change the interface slightly by allowing the functions to accept parameters.
    
    // this function has the player win immediately if they have 21 in two cards only.
    // if the player does not have 21 in two cards, but the dealer does, the dealer wins immediately.
    boolean twentyOneInTwo();
    // this function will guarantee that the ace is an eleven unless the eleven causes you to bust.
    // the ace rule holds for both the player and the dealer.
    int checkValueOfAce();
    //guarantees the dealer has to hit if 17 or less and may not hit if over 17.
    void compHit(Deck gamedeck);
    // checks if player of dealer busts, if so the game ends immediately.  
    boolean bust();
}