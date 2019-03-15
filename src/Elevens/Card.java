package Elevens;

public class Card {
    private int nummericValue;

    public Card(int numericValue)
    {
        this.nummericValue = numericValue;
    }

    public String toString()
    {
        return Integer.toString(nummericValue);
    }
}
