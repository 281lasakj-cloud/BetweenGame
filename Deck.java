import java.util.Random;

public class Deck
{
    private ArrayLog<Card> cards;
    private Random random;

    public Deck()
    {
        cards = new ArrayLog<Card>("Deck");
        random = new Random();

        createDeck();
        shuffle();
    }

    private void createDeck()
    {
        cards.clear();

        String[] suits = {
            "Hearts", "Diamonds", "Clubs", "Spades"
        };

        String[] ranks = {
            "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen",
            "King", "Ace"
        };

        for (String suit : suits)
        {
            for (int i = 0; i < ranks.length; i++)
            {
                cards.add(new Card(suit, ranks[i], i + 2));
            }
        }
    }

    public void shuffle()
    {
        for (int i = cards.size() - 1; i > 0; i--)
        {
            int j = random.nextInt(i + 1);

            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card drawCard()
    {
        if (cards.isEmpty())
        {
            createDeck();
            shuffle();
        }

        Card drawn = cards.remove(cards.size() - 1);

        if (cards.size() < 10 && !cards.isEmpty())
        {
            shuffle();
        }

        return drawn;
    }

    public int cardsRemaining()
    {
        return cards.size();
    }
}