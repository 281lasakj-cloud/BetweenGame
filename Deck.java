import java.util.Random;

public class Deck
{
    private ArrayLog<Card> cards;
    private int next;

    public Deck(){
        shuffle();
    }

    public void shuffle()
    {
        cards = new ArrayLog<Card>("Deck");
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        
        for (String suit : suits)
        {
            for (int value = 1; value <= 13; value++)
            {
                cards.add(new Card(suit, value));
            }
        }

        Random rand = new Random();

        for (int i = cards.size() - 1; i > 0; i--)
        {
            int j = rand.nextInt(i + 1);

            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }

        next = 0;
    }

    public Card drawCard()
    {
        if (next >= cards.size())
        {
            System.out.println("The deck is empty. Reshuffling.");

            shuffle();
        }

        return cards.get(next++);
    }
}