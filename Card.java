public class Card
{
    private String suit;
    private String rank;
    private int value;

    public Card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    public String toString()
    {
        return value + " of " + suit;
    }
}