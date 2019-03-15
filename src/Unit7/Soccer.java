package Unit7;

public class Soccer extends Sport {
    private int redCards;

    public Soccer()
    {
        setPlayers(22);
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}
